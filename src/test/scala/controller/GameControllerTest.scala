package cl.uchile.dcc.citric
package controller

import controller.states.{AttackState, GameEndsState, MovingPlayerState, NewChapterState, PanelEffectState, RecoveryState, ResponseState, StarsAndDiceState, StartingState, TurnLoopState}

import cl.uchile.dcc.citric.model.units.PlayerCharacter


class GameControllerTest extends munit.FunSuite {
  var controller: GameController = new GameController


  override def beforeEach(context: BeforeEach):Unit = {
    controller = new GameController
  }

  test("the game controller should have its attributes initially well defined"){
    assertEquals(controller.gameState.getClass.getName, (new StartingState).getClass.getName)
  }

  test("the game controller can add players to the list of player order and get them by place in the order list"){
    val p1 = new PlayerCharacter("1",1,1,1,1,1)
    val p2 = new PlayerCharacter("2",1,1,1,1,2)
    val p3 = new PlayerCharacter("3",1,1,1,1,3)
    val p4 = new PlayerCharacter("4",1,1,1,1,4)

    controller.addPlayer(p1)
    controller.addPlayer(p2)
    controller.addPlayer(p3)
    controller.addPlayer(p4)

    assertEquals(controller.getPlayer(0), p1)
    assertEquals(controller.getPlayer(1), p2)
    assertEquals(controller.getPlayer(2), p3)
    assertEquals(controller.getPlayer(3), p4)
  }

  test("the game controller should be able to transition from the starting state to the new chapter state"){
    controller.resetController()
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

  test("the game controller should be able to transition from the turn loop state to the recovery state"){
    controller.gameState = new TurnLoopState
    controller.playerKO()
    assertEquals(controller.gameState.getClass.getName, (new RecoveryState).getClass.getName)
  }

  test("the game controller should be able to transition from the recovery state to the turn loop state"){
    controller.gameState = new RecoveryState
    controller.diceMiss()
    assertEquals(controller.gameState.getClass.getName, (new TurnLoopState).getClass.getName)
  }

  test("the game controller should be able to transition from the recovery state to the stars and dice state"){
    controller.gameState = new RecoveryState
    controller.diceHit()
    assertEquals(controller.gameState.getClass.getName, (new StarsAndDiceState).getClass.getName)
  }

  test("the game controller should be able to transition from the turn loop state to the stars and dice state"){
    controller.gameState = new TurnLoopState
    controller.playerNotKO()
    assertEquals(controller.gameState.getClass.getName, (new StarsAndDiceState).getClass.getName)
  }

  test("the game controller should be abel to transition from the stars and dice state to the moving player state"){
    controller.gameState = new StarsAndDiceState
    controller.startMovement()
    assertEquals(controller.gameState.getClass.getName, (new MovingPlayerState).getClass.getName)
  }

  test("the game controller should be able to transition from the moving player state to itself"){
    controller.gameState = new MovingPlayerState
    controller.keepsMoving()
    assertEquals(controller.gameState.getClass.getName, (new MovingPlayerState).getClass.getName)
  }

  test("the game controller should be able to transition from the moving player state to the panel effect state in two ways"){
    controller.gameState = new MovingPlayerState
    controller.playerStops()
    assertEquals(controller.gameState.getClass.getName, (new PanelEffectState).getClass.getName)

    controller.gameState = new MovingPlayerState
    controller.playerHomePanel()
    assertEquals(controller.gameState.getClass.getName, (new PanelEffectState).getClass.getName)
  }

  test("the game controller should be able to transition from the panel effect state to the turn loop state"){
    controller.gameState = new PanelEffectState
    controller.noCombat()
    assertEquals(controller.gameState.getClass.getName, (new TurnLoopState).getClass.getName)
  }

  test("the game controller should be able to transition from the turn loop state to the game ends state"){
    controller.gameState = new TurnLoopState
    controller.playerWins()
    assertEquals(controller.gameState.getClass.getName, (new GameEndsState).getClass.getName)
  }

  test("the game controller should be able to transition from the panel effect state to the attack state"){
    controller.gameState = new PanelEffectState
    controller.combat()
    assertEquals(controller.gameState.getClass.getName, (new AttackState).getClass.getName)
  }

  test("the game controller should be able to transition from the attack state to the response state"){
    controller.gameState = new AttackState
    controller.unitAttacks()
    assertEquals(controller.gameState.getClass.getName, (new ResponseState).getClass.getName)
  }

  test("the game controller should be able to transition from the response state to the attack state in two ways"){
    controller.gameState = new ResponseState
    controller.unitEvades()
    assertEquals(controller.gameState.getClass.getName, (new AttackState).getClass.getName)

    controller.gameState = new ResponseState
    controller.unitDefends()
    assertEquals(controller.gameState.getClass.getName, (new AttackState).getClass.getName)
  }

  test("the game controller should be able to transition from the attack state to the turn loop state"){
    controller.gameState = new AttackState
    controller.combatEnds()
    assertEquals(controller.gameState.getClass.getName, (new TurnLoopState).getClass.getName)
  }

  test("the game controller should be able to transition from the attack state to itself"){
    controller.gameState = new AttackState
    controller.receiverNotKO()
    assertEquals(controller.gameState.getClass.getName, (new AttackState).getClass.getName)
  }
}
