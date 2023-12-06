package cl.uchile.dcc.citric
package controller

import controller.states.{AttackState, GameEndsState, MovingPlayerState, NewChapterState, PanelEffectState, RecoveryState, ResponseState, StarsAndDiceState, StartingState, TurnLoopState}

import cl.uchile.dcc.citric.model.norma.NullNorma
import cl.uchile.dcc.citric.model.norma.factory.NullNormaFactory
import cl.uchile.dcc.citric.model.panels.EncounterPanel
import cl.uchile.dcc.citric.model.stance.DefendingStance
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter


class GameControllerTest extends munit.FunSuite {
  val board: GameBoard = GameBoard.getInstance
  var controller: GameController = GameController.getInstance


  override def beforeEach(context: BeforeEach):Unit = {
    controller.setUpController()
    controller.gameState = new StartingState
  }

  test("the game controller should have its attributes initially well defined"){
    controller.setUpController()

    assertEquals(controller.gameState.getClass.getName, (new StartingState).getClass.getName)
    assertEquals(controller.getPlayer(0).name, "player1")
    assertEquals(controller.getPlayer(1).name, "player2")
    assertEquals(controller.getPlayer(2).name, "player3")
    assertEquals(controller.getPlayer(3).name, "player4")
  }

  test("the game controller should be able to transition from the starting state to the new chapter state"){
    controller.startGame()
    assertEquals(controller.gameState.getClass.getName, (new NewChapterState).getClass.getName)
  }

  test("the game controller should be able to transition from the new chapter state to the turn loop state"){
    controller.gameState = new NewChapterState
    controller.newChapter()
    assertEquals(controller.gameState.getClass.getName, (new TurnLoopState).getClass.getName)
  }

  test("the game controller should be able to transition from the turn loop state to the new chapter"){
    controller.gameState = new TurnLoopState
    controller.chapterEnds()
    assertEquals(controller.gameState.getClass.getName, (new NewChapterState).getClass.getName)
  }

  test("the game controller should be able to transition from the stars and dice state to the moving player state"){
    controller.gameState = new StarsAndDiceState
    controller.startMovement()
    assertEquals(controller.gameState.getClass.getName, (new MovingPlayerState).getClass.getName)
  }

  test("the game controller should be able to transition from the panel effect state to the turn loop state"){
    controller.gameState = new PanelEffectState
    controller.noCombat()
    assertEquals(controller.gameState.getClass.getName, (new TurnLoopState).getClass.getName)
  }

  test("the game controller should be able to transition from the panel effect state to the attack state"){
    controller.gameState = new PanelEffectState

    controller.getPlayer(0).currentPosition = 3
    board.getPanel(controller.getPlayer(0).currentPosition).addCharacter(controller.getPlayer(0))
    board.getPanel(controller.getPlayer(0).currentPosition).addCharacter(controller.getPlayer(1))

    controller.combatPvP()
    assertEquals(controller.gameState.getClass.getName, (new AttackState).getClass.getName)

    controller.gameState = new PanelEffectState
    controller.combatPvW(new EncounterPanel(0))
    assertEquals(controller.gameState.getClass.getName, (new AttackState).getClass.getName)
  }

  test("the game controller should be able to transition from the attack state to the response state"){
    controller.gameState = new PanelEffectState

    controller.getPlayer(0).currentPosition = 3
    board.getPanel(controller.getPlayer(0).currentPosition).addCharacter(controller.getPlayer(0))
    board.getPanel(controller.getPlayer(0).currentPosition).addCharacter(controller.getPlayer(1))
    controller.getPlayer(0).stance = new DefendingStance

    controller.combatPvP()

    controller.unitAttacks()

    assertEquals(controller.gameState.getClass.getName, (new ResponseState).getClass.getName)
  }

  test("the game controller should be able to transition from the response state to the attack state in two ways"){
    controller.gameState = new PanelEffectState

    controller.getPlayer(0).currentPosition = 3
    board.getPanel(controller.getPlayer(0).currentPosition).addCharacter(controller.getPlayer(0))
    board.getPanel(controller.getPlayer(0).currentPosition).addCharacter(controller.getPlayer(1))
    controller.getPlayer(0).stance = new DefendingStance
    controller.getPlayer(1).stance = new DefendingStance

    controller.combatPvP()
    controller.decideAttack()
    controller.unitDefends()

    assertEquals(controller.gameState.getClass.getName, (new AttackState).getClass.getName)

    controller.unitAttacks()

    controller.getPlayer(0).currentHP = 0
    controller.getPlayer(1).currentHP = 0

    controller.unitEvades()

  }

  test("the controller should be able to decide to play a turn if the currentPlayer is not KO"){
    controller.gameState = new TurnLoopState

    controller.decideTurnLoop()
    assertEquals(controller.gameState.getClass.getName, (new StarsAndDiceState).getClass.getName)
  }

  test("the controller should be able to decide to go to the recovery state if the current player is KO"){
    controller.gameState = new TurnLoopState


    controller.getPlayer(0).currentHP = 0
    controller.decideTurnLoop()
    assertEquals(controller.gameState.getClass.getName, (new RecoveryState).getClass.getName)
  }

  test("the controller should be able to decide to go to the ending state if the game has to end"){
    controller.gameState = new TurnLoopState

    controller.getPlayer(0).changeNormaWith(NullNormaFactory)
    controller.decideTurnLoop()
    assertEquals(controller.gameState.getClass.getName, (new GameEndsState).getClass.getName)
  }

  test("the controller should be able to decide to go to the turn loop state or the stars and dice state depending on the player roll") {
    controller.startGame()
    controller.gameState = new RecoveryState

    var i = 0
    while (i < 10) {
      controller.decideRecovery()

      val result = controller.gameState.getClass.getName
      assert(result == (new TurnLoopState).getClass.getName || result == (new StarsAndDiceState).getClass.getName)

      controller.gameState = new RecoveryState
      i += 1
    }
  }

  test("the controller should be able to decide to which state transition from the player moving state (players stops or keeps moving)") {
    controller.gameState = new StarsAndDiceState
    controller.startMovement()
    controller.gameState = new MovingPlayerState

    var i = 0
    while (i < 10) {
      controller.gameState = new MovingPlayerState

      controller.decidePlayerMoving()

      val result = controller.gameState.getClass.getName
      assert(result == (new PanelEffectState).getClass.getName || result == (new MovingPlayerState).getClass.getName)

      controller.gameState = new MovingPlayerState
      i += 1
    }
  }

  test("the controller should be able to decide to which state transition from the player moving state (home panel stop or keeps moving)") {
    controller.getPlayer(0).currentPosition += 5

    controller.gameState = new TurnLoopState
    controller.decideTurnLoop()

    controller.gameState = new StarsAndDiceState
    controller.startMovement()

    controller.gameState = new MovingPlayerState

    var i = 0
    while (i < 10) {
      controller.gameState = new MovingPlayerState

      controller.decidePlayerMoving()

      val result = controller.gameState.getClass.getName
      assert(result == (new PanelEffectState).getClass.getName || result == (new MovingPlayerState).getClass.getName)

      controller.gameState = new MovingPlayerState
      i += 1
    }
  }

  test("the controller should correctly decide which state to transition from the panel effect state"){
    val p: PlayerCharacter = controller.getPlayer(0)
    controller.gameState = new PanelEffectState
    GameBoard.getInstance.getPanel(p.currentPosition).addCharacter(p)

    var i = 0
    while(i < 5){
      controller.decidePanelEffect()
      val result = controller.gameState.getClass.getName

      assert(result == (new TurnLoopState).getClass.getName || result == (new AttackState).getClass.getName)

      p.currentPosition += 1
      GameBoard.getInstance.getPanel(p.currentPosition).addCharacter(p)
      controller.gameState = new PanelEffectState
      i+=1
    }
  }

  test("the controller should correctly decide which state to transition from the attack state"){
    controller.gameState = new PanelEffectState

    controller.getPlayer(0).currentPosition = 3
    board.getPanel(controller.getPlayer(0).currentPosition).addCharacter(controller.getPlayer(0))
    board.getPanel(controller.getPlayer(0).currentPosition).addCharacter(controller.getPlayer(1))
    controller.getPlayer(0).stance = new DefendingStance
    controller.getPlayer(1).stance = new DefendingStance

    controller.combatPvP()
    controller.decideAttack()

    assertEquals(controller.gameState.getClass.getName, (new ResponseState).getClass.getName)

    controller.unitDefends()
    controller.decideAttack()

    assertEquals(controller.gameState.getClass.getName, (new ResponseState).getClass.getName)

    controller.unitDefends()
    controller.decideAttack()

    assertEquals(controller.gameState.getClass.getName, (new TurnLoopState).getClass.getName)
  }

  test("the controller should correctly tell when the game is finished"){
    assertEquals(controller.isDone, false)

    controller.getPlayer(0).changeNormaWith(NullNormaFactory)
    controller.getPlayer(0).notifyObservers()

    assertEquals(controller.isDone, true)
  }
}

