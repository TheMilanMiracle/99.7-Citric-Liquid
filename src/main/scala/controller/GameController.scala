package cl.uchile.dcc.citric
package controller

import controller.states.{GameState, StartingState}

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** Class that represent the game controller
 *
 * it has the responsibility of controlling the state
 * of the game and transition between these states
 * accordingly
 *
 * the game controller can:
 * - call resetController, a transition from the starting state to NewChapterState
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class GameController{
  /** Current game state */
  private var _gameState:GameState = {new StartingState}

  /** List of players that represents the order in which they must play*/
  private val playerOrder: ArrayBuffer[PlayerCharacter] = ArrayBuffer()

  /** Current chapter of the game */
  private var _chapter: Int = 0

  /** Getter for the game state attribute */
  def gameState:GameState = {_gameState}

  /** Setter for the game state attribute */
  def gameState_=(s: GameState): Unit = {_gameState = s}

  /** Method that allows to add a player to the playerOrderList
   *
   * there cannot be more than 4 players in the list and the order in which
   * they are added will be the order for their turns
   *
   * @param p the player that will be added to the list
   */
  def addPlayer(p:PlayerCharacter):Unit = {
    if(playerOrder.length < 4) playerOrder += p
  }

  /** Method that allows to get a player from the list by their order
   *
   * @param i order of the player
   */
  def getPlayer(i: Int): PlayerCharacter = {
    playerOrder(i)
  }

  /** transitions the game state from the starting one to the new chapter state */
  def resetController(): Unit = {
    _gameState.resetController(this)
  }

  /** transitions the game state from the new chapter state to the turn loop state */
  def newChapter(): Unit = {
    _gameState.newChapter(this)
  }

  /** transitions the game state from the turn loop state to the new chapter state */
  def chapterEnds(): Unit = {
    _gameState.chapterEnds(this)
  }

  /** transitions the game state from the turn loop state to the recovery state */
  def playerKO(): Unit = {
    _gameState.playerKO(this)
  }

  /** transition the game state from the recovery state to the turn loop state*/
  def diceMiss(): Unit = {
    _gameState.diceMiss(this)
  }

  /** transition the game state from the recovery state to the stars and dice state */
  def diceHit(): Unit = {
    _gameState.diceHit(this)
  }

  /** transitions the game state from the turn loop state to the stars and dice state */
  def playerNotKO(): Unit = {
    _gameState.playerNotKO(this)
  }

  /** transitions the game state from the stars and dice state to the moving player state */
  def startMovement(): Unit = {
    _gameState.startMovement(this)
  }

  /** transitions the game state from the moving player state to itself */
  def keepsMoving(): Unit = {
    _gameState.keepsMoving(this)
  }

  /** transitions the game state from the moving player state to panel effect state */
  def playerStops(): Unit = {
    _gameState.playerStops(this)
  }

  /** transitions the game state from the moving player state to panel effect state */
  def playerHomePanel(): Unit = {
    _gameState.playerHomePanel(this)
  }

  /** transition the game state from the panel effect state to the turn loop state  */
  def noCombat(): Unit = {
    _gameState.noCombat(this)
  }

  /** transition the game state from the turn loop state to the game ends state*/
  def playerWins(): Unit = {
    _gameState.playerWins(this)
  }

  /** transitions the game state from the panel effect state to the attack state */
  def combat(): Unit = {
    _gameState.combat(this)
  }

  /** transitions the game state from the attack state to the response state */
  def unitAttacks(): Unit = {
    _gameState.unitAttacks(this)
  }

  /** transitions the game state from the response state to the attack state */
  def unitEvades(): Unit = {
    _gameState.unitEvades(this)
  }

  /** transitions the game state from the response state to the attack state */
  def unitDefends(): Unit = {
    _gameState.unitDefends(this)
  }

  /** transitions the game state from the attack state to the turn loop state */
  def combatEnds(): Unit = {
    _gameState.combatEnds(this)
  }

  /** transitions the game state from the attack state to itself */
  def receiverNotKO(): Unit = {
    _gameState.receiverNotKO(this)
  }

}
