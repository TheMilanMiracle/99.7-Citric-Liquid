package cl.uchile.dcc.citric
package model.units.player

import model.norma.Norma
import model.norma.factory.NormaFactory
import model.objectives.Objective
import model.units.{AbstractGameUnit, GameUnit}
import controller.Observer

import cl.uchile.dcc.citric.model.norma.factory.Norma1Factory

import scala.collection.mutable.ArrayBuffer

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  *
  * For instance, players can:
  *
  * - Roll a dice, a common action in many board games.
  * - return and change its own norma level
  * - return and increase their victories
  * - return an change their own objective
  * - a player character should be able to win victories
  * - a PlayerCharacter can increase the victories of another PlayerCharacter
  * - a PlayerCharacter can drop stars to a PlayerCharacter
  * - perform a norma check
  *
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHP The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param homePos The player's home panel position on the board
  *
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/TheMilanMiracle/ Luciano Márquez C.]]
  */
class PlayerCharacter(name: String,
                      maxHP: Int,
                      attack: Int,
                      defense: Int,
                      evasion: Int,
                      homePos: Int) extends AbstractGameUnit(maxHP, attack, defense, evasion, name) with Subject[PlayerCharacter] {
  /** The position of the home panel that this player owns
   *
   * In the context of the game, each player has a home panel of his own
   */
  private val _homePanelPosition: Int = homePos

  /** Current position of the player on the board */
  private var _currentPosition: Int = 0

  /** Victories that the Player has
   *
   * Player can obtain victories when defeating other Units in
   * combat, the quantity starts at 0
   */
  private var _victories: Int = 0

  /** Norma level of the player
   *
   *  this variable represent how much a player has advanced in the game,
   *  it can be upgraded when the player lands on a home panel and it affects
   *  many situations of the game that depend on the norma level
   *
   *  It starts at level 1
   */
  private var _norma: Option[Norma] = None

  /** Norma factory used by the player to update its norma level */
  private var _normaFactory: NormaFactory = Norma1Factory

  /** Current Objective of the player
   *
   * a player can choose between "stars" and "victories" as objectives,
   * these are chosen when a player levels up an cannot be changed until
   * the next level up
   */
  private var _objective: Option[Objective] = None

  /** list of observers of the subject */
  private val observers: ArrayBuffer[Observer[PlayerCharacter]] = ArrayBuffer()

  /** Return the position of the home panel of the player
   *
   * @return an integer corresponding to the position of the player's home panel
   */
  def homePanelPosition: Int = this._homePanelPosition

  /** Return the current position of the player
   *
   * @return an integer representing the position of the player on the board*/
  def currentPosition: Int = this._currentPosition

  /** Method that allows a player to change its current position
   *
   * @param p the new position for the player
   */
  def currentPosition_=(p: Int): Unit = this._currentPosition = p

  /** returns the victories that the Player has
   *
   * @return the current victories of the player
   */
  def victories: Int = this._victories

  /** Changes the current victories of the player
   *
   * @param v the new victories that the player will have
   */
  def victories_=(v: Int): Unit = this._victories = v

  /** Method tha allows a player to win victories
   *
   * in the context of the game a players wins victories when defeating
   * another unit and the amount depends on the defeated unit
   *
   * @param unit the defeated unit
   */
  def winVictories(unit: GameUnit): Unit = {
    unit.increaseVictoriesTo(this)
  }

  /** Method that allows a unit to increase the victories of another one
   *
   * in the context of a game this method is meant to be used after a combat is finished,
   * and this is the only ways this variable from player characters is increased/changed
   *
   * when a player increases the victories of another player, this value is incremented by 2
   *
   * @param p the player that will gain the victories
   */
  def increaseVictoriesTo(p: PlayerCharacter):Unit = {
    p.victories = p.victories + 2
  }

  /** Method that allow a unit to drop their stars to a PlayerCharacter
   *
   * when a player drop their stars to a unit he will drop half of the current stars
   * to the other
   *
   * @param unit the unit that will gain the stars dropped
   */
  def dropStarsTo(unit: GameUnit): Unit = {
    unit.stars = unit.stars + (this.stars/2)
    this.stars /= 2
  }

  /** Returns the current norma level of the player
   *
   * @return the current norma of the player
   */
  def norma: Norma = {
    if(this._norma.isEmpty) updateNorma()
    _norma.get
  }

  /** Changes the current stored norma factory and updates the norma accordingly
   *
   * @param normaFactory the new norma factory
   */
  def changeNormaWith(normaFactory: NormaFactory): Unit = {
    _normaFactory = normaFactory
    updateNorma()
  }

  /** Method that updates the current norma level of the player
   * depending of the current stored factory
   */
  private def updateNorma(): Unit = this._norma = Some(_normaFactory.apply())

  /** return the current objective of the player
   *
   * @return the current objective of the player
   */
  def objective: Option[Objective] = this._objective

  /** Setter for the objective attribute
   *
   * @param obj objective that will be set
   */
  def objective_=(obj: Objective): Unit = {
    this._objective = Some(obj)
  }

  /** Method that checks if the requirements for leveling up are met and uses the factory to update the norma if so */
  def normaCheck(): Unit = {
    if(this._objective.isDefined && this._objective.get.normaCheck(this)) this.changeNormaWith(this.norma.getNext)
  }


  /** Method that adds a new observer
   *
   * @param o the observer that will be added
   */
  def addObserver(o: Observer[PlayerCharacter]): Unit = {
    this.observers += o
  }

  /** Method that notifies all of the observers
   *
   * the subject player doesn't need an extra value to notify its observer,
   * because for the game controller all that needs is the subject itself
   */
  def notifyObservers(): Unit = {
    if(this.norma.getInt == -1) observers.foreach(_.update(this,this))
  }
}
