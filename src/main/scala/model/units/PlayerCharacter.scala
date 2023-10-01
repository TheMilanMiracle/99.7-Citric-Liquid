package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norma.{Norma, NormaLevel1}

import scala.util.Random

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
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param _name The name of the player. This is an identifier and should be unique.
  * @param _maxHP The maximum health points a player can have. It represents the player's endurance.
  * @param _attack The player's capability to deal damage to opponents.
  * @param _defense The player's capability to resist or mitigate damage from opponents.
  * @param _evasion The player's skill to completely avoid certain attacks.
  * @param homePos The player's home panel position on the board
  *
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/TheMilanMiracle/ Luciano Márquez C.]]
  */
class PlayerCharacter(val _name: String,
                      val _maxHP: Int,
                      val _attack: Int,
                      val _defense: Int,
                      val _evasion: Int,
                      homePos: Int) extends abstractGameUnit {
  /** Current hp of the unit
   *
   * Units health can vary when a combat with another Unit is initiated
   * its value is initiated with the maxHp declared at the constructor of
   * the class
   *
   */
  var _currentHP: Int = _maxHP

  /** The position of the home panel that this player owns
   *
   * In the context of the game, each player has a home panel of his own
   *
   */
  private var _homePanel: Int = homePos

  /** Victories that the Player has
   *
   * Player can obtain victories when defeating other Units in
   * combat, the quantity starts at 0
   *
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
  private var _norma: Norma = new NormaLevel1

  /** Current Objective of the player
   *
   * a player can choose between "stars" and "victories" as objectives,
   * these are chosen when a player levels up an cannot be changed until
   * the next level up
   *
   * this value is initialized with a meaningless value because the objective is
   * chosen for the first time at norma level 2
   */
   private var _objective: String = "init"

  /** Return the position of the home panel of the player
   *
   * @return an integer corresponding to the position of the player's home panel
   * */

  def homePanel: Int = this._homePanel

  /** returns the victories that the Player has
   *
   * @return the current victories of the player
   */
  def victories: Int = this._victories

  /** Increases number of victories after winning a combat against a wild unit
   *
   * In the context of the game, this value should increase in 1 if
   * the player defeated a wilds unit
   */
  def increaseVictories(wildUnit: WildUnit): Unit = {
    this._victories += 1
  }

  /** Increases number of victories after winning a combat against a wild unit
   *
   * In the context of the game, this value should increase in 2 if
   * the player defeated another player
   */
  def increaseVictories(playerCharacter: PlayerCharacter): Unit = {
    this._victories += 2
  }

  /** Returns the current norma level of the player
   *
   * @return the current norma of the player
   */
  def norma: Norma = this._norma

  /** Changes the current norma level of the player
   *
   * @param norma the new norma level of the player
   */
  def norma_=(norma: Norma): Unit = this._norma = norma

  /** return the current objective of the player
   *
   * @return the current objective of the player
   */
  def objective:String = this._objective

  /** Setter for the objective attribute
   *
   * @param obj objective that will be set
   */
  def objective_=(obj: String): Unit = {
    this._objective = obj
  }
}
