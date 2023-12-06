package cl.uchile.dcc.citric
package controller

import controller.states.{GameState, StartingState}
import model.units.player.{PlayerCharacter, Subject}
import model.panels.{EncounterPanel, GamePanel}

import cl.uchile.dcc.citric.model.units.GameUnit

import scala.collection.mutable.ArrayBuffer

/** Class that represent the game controller
 *
 * it has the responsibility of controlling the state
 * of the game and transition between these states
 * accordingly
 *
 * the game controller can:
 * - get and set its game state
 * - add and get a player from the order list
 * - update with notification from player
 * - tell if the game is done
 * - call ALL of the transitions methods to update its state
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class GameController private extends Observer[PlayerCharacter]{
  /** Current game state */
  private var _gameState:GameState = {new StartingState}

  /** List of players that represents the order in which they must play*/
  private var player_order: ArrayBuffer[PlayerCharacter] = ArrayBuffer()

  /** Current player turn */
  private var turn: Int = 0

  /** Current combat turn */
  private var combat_turn = 0

  /** Current Roll of the current player */
  private var current_roll: Int = 0

  /** Current chapter of the game */
  private var _chapter: Int = 0

  /** Winner PlayerCharacter
   *
   * if this variable is defined, it means that a player has already won the game so it should end
   */
  private var winner: Option[PlayerCharacter] = None

  /** Variable that stores the attacker, useful when there is combat */
  private var attacker: Option[GameUnit] = None

  /** Variable that stores the receiver of an attack, useful when there is combat */
  private var receiver: Option[GameUnit] = None

  /** Variable that stores the board of the game */
  private var board: Option[GameBoard] = None

  /** method that resets all the variable of the controller and sets them up with the initial values */
  def setUpController(): Unit = {
    _gameState = new StartingState
    player_order = ArrayBuffer()
    turn = 0
    current_roll = 0
    _chapter = 0
    winner = None

    val p1: PlayerCharacter = new PlayerCharacter("player1", 20, 5, 3, 2, 0)
    val p2: PlayerCharacter = new PlayerCharacter("player2", 20, 5, 3, 2, 5)
    val p3: PlayerCharacter = new PlayerCharacter("player3", 20, 5, 3, 2, 9)
    val p4: PlayerCharacter = new PlayerCharacter("player4", 20, 5, 3, 2, 14)

    board = Some(GameBoard.getInstance)

    p1.addObserver(this)
    p2.addObserver(this)
    p3.addObserver(this)
    p4.addObserver(this)

    addPlayer(p1)
    addPlayer(p2)
    addPlayer(p3)
    addPlayer(p4)
  }

  /** Getter for the game state attribute */
  def gameState:GameState = _gameState

  /** Setter for the game state attribute */
  def gameState_=(s: GameState): Unit = _gameState = s

  /** Method that allows to add a player to the playerOrderList
   *
   * there cannot be more than 4 players in the list and the order in which
   * they are added will be the order for their turns
   *
   * @param p the player that will be added to the list
   */
  private def addPlayer(p:PlayerCharacter):Unit = {
    if(player_order.length < 4) player_order += p
  }

  /** Method that allows to get a player from the list by their order
   *
   * @param i order of the player
   */
  def getPlayer(i: Int): PlayerCharacter = {
    player_order(i)
  }

  /** method that decides to what state transition from the turn loop state
   *
   * transitions to:
   * - chapter ends state if all players already had their turns
   * - game ends state if a player has won the game
   * - recovery state if the current player is ko
   * - stars and dice state if the current player is not ko
   */
  def decideTurnLoop(): Unit = {
    player_order.foreach(_.notifyObservers())

    val currentPlayer: PlayerCharacter = player_order(turn)


    if (turn > 3) this.chapterEnds()
    else if(winner.isDefined) _gameState.playerWins(this)
    else if(currentPlayer.currentHP == 0) _gameState.playerKO(this)
    else _gameState.playerNotKO(this)
  }

  /** method that decides to what state transition from the recovery state
   *
   * transitions to:
   * - stars and dice state if the current player's roll is minimum the required amount
   * - turn loop state if not
   */
  def decideRecovery(): Unit = {
    val currentPlayer: PlayerCharacter = player_order(turn)
    current_roll = currentPlayer.rollDice()

    if(current_roll >= 6 - _chapter) _gameState.diceHit(this)
    else _gameState.diceMiss(this)
  }

  /** method that decides to what state transition from the player moving state
   *
   * transitions to:
   * - player moving state if the player has to keep moving
   * - panel effect state if the player stops moving (by choosing to stop on its home panel or normally)
   */
  def decidePlayerMoving(): Unit = {
    val currentPlayer: PlayerCharacter = player_order(turn)

    //for simplicity, the player always stops at his home panel
    if (currentPlayer.currentPosition == currentPlayer.homePanelPosition) {
      _gameState.playerHomePanel(this)
      board.get.getPanel(currentPlayer.currentPosition).addCharacter(currentPlayer)
    }
    else if (current_roll > 0) {
      _gameState.keepsMoving(this)
      current_roll -= 1
      currentPlayer.currentPosition += 1
      decidePlayerMoving()
    }
    else if (current_roll == 0) {
      _gameState.playerStops(this)
      board.get.getPanel(currentPlayer.currentPosition).addCharacter(currentPlayer)
    }
  }

  /** Method that decides to what state transition from the panel effect state
   *
   * transitions to:
   * - attack state if the panel is an encounter one
   * - turn loop state if the panel is not an encounter one
   */
  def decidePanelEffect(): Unit = {
    val currentPlayer: PlayerCharacter = player_order(turn)
    val currentPanel: GamePanel = board.get.getPanel(currentPlayer.currentPosition)

    //the state change decision is delegated
    currentPanel.apply(this)
  }

  /** method that decides to what state to transition from the attack state
   *
   * it transitions to:
   * - turn loop state if the combat has to end
   * - to attack state again if there is an attack from the receiver
   * - to attack response state if there is an attack
   */
  def decideAttack(): Unit = {
    if(combat_turn == 0) _gameState.combatEnds(this)

    else if(combat_turn == 1){
      if(receiver.get.currentHP == 0) _gameState.combatEnds(this)
      else{
        val aux = attacker
        attacker = receiver
        receiver = aux

        this.unitAttacks()
      }
    }

    else this.unitAttacks()
  }

  /** returns if the game has defined a winner */
  def isDone: Boolean = {
    if(winner.isEmpty) false
    else true
  }

  /** transitions the game state from the starting one to the new chapter state */
  def startGame(): Unit = {
    setUpController()

    _gameState.startGame(this)
  }

  /** transitions the game state from the new chapter state to the turn loop state */
  def newChapter(): Unit = {
    _gameState.newChapter(this)
  }

  /** transitions the game state from the turn loop state to the new chapter state */
  def chapterEnds(): Unit = {
    _chapter += 1
    turn = 0

    _gameState.chapterEnds(this)
  }

  /** transitions the game state from the stars and dice state to the moving player state */
  def startMovement(): Unit = {
    val currentPlayer: PlayerCharacter = player_order(turn)
    current_roll = currentPlayer.rollDice()

    board.get.getPanel(currentPlayer.currentPosition).removeCharacter(currentPlayer)

    _gameState.startMovement(this)
  }

  /** transition the game state from the panel effect state to the turn loop state  */
  def noCombat(): Unit = {
    _gameState.noCombat(this)
  }

  /** transitions the game state from the panel effect state to the attack state */
  def combatPvP(): Unit = {
    _gameState.combat(this)

    combat_turn = 2

    val currentPlayer: PlayerCharacter = player_order(turn)
    val currentPanel: GamePanel = board.get.getPanel(currentPlayer.currentPosition)

    attacker = Some(currentPlayer)
    receiver = Some(currentPanel.characters(currentPanel.characters.length - 2))
  }

  /** transitions the game state from the panel effect state to the attack state */
  def combatPvW(p: EncounterPanel): Unit = {
    _gameState.combat(this)

    combat_turn = 2

    val currentPlayer: PlayerCharacter = player_order(turn)

    attacker = Some(currentPlayer)
    receiver = Some(p.wildUnit)

  }

  /** transitions the game state from the attack state to the response state */
  def unitAttacks(): Unit = {
    if(attacker.isDefined && receiver.isDefined) attacker.get.attackUnit(receiver.get)

    _gameState.unitAttacks(this)
  }

  /** transitions the game state from the response state to the attack state */
  def unitEvades(): Unit = {
    _gameState.unitEvades(this)

    combat_turn -= 1
  }

  /** transitions the game state from the response state to the attack state */
  def unitDefends(): Unit = {
    _gameState.unitDefends(this)

    combat_turn -= 1
  }

  /** method that updates info from the observer entity
   *
   * @param s subject that the observer is observing
   * @param p the player that won
   */
  def update(s: Subject[PlayerCharacter], p: PlayerCharacter): Unit = {
    if(winner.isEmpty) winner = Some(p)
  }

}

/** Object that ensures that the GameController class
 * can only have one instance and provide a global access
 * to said instance
 *
 *
 * for instance this object can:
 * - store an instance of the class GameController
 * - return the instance, creating it if is not created yet
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
object GameController {
  /** only instance of the class GameController */
  private var _intance: Option[GameController] = None

  /** gets the GameController instance, creating it if is not created yet */
  def getInstance: GameController = {
    if(_intance.isEmpty){_intance =
      Some(new GameController)
      _intance.get.setUpController()
      _intance.get.gameState = new StartingState
    }
    _intance.get
  }
}
