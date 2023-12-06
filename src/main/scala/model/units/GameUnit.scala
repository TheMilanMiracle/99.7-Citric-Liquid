package cl.uchile.dcc.citric
package model.units

import model.stance.CombatStance

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

/** The GameUnit interface represent the entity that will participate
 * in the game, whether as a player character, controller by an user, or as a
 * wild unit, not controllable by an user. All game units have an unique name,
 * basic attributes as HP, attack, defense and evasion. Game units can hold
 * a quantity of stars that may vary throughout a game
 *
 * For instance, game units can:
 *
 * - get their basics stats HP, attack, defense, evasion and its name
 * - get and set their current HP, maintaining the value between 0 and maxHP
 * - get and set their current number of stars
 * - increase the victories of a PlayerCharacter
 * - win stars from another unit
 * - drop stars to a game unit
 * - attack another game unit
 * - print itself properly
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait GameUnit {
  /** Returns the maxHP of the unit
   *
   * @return an integer representing the maximum HP the unit can have */
  def maxHP: Int

  /** Returns the current HP of the unit
   *
   * its value only can be between 0 and the maxHP of the unit
   *
   * @return an integer representing the current HP of the unit
   */
  def currentHP: Int

  /** sets the current star of the unit to a given number
   *
   * in case the given number is out of range, the set value will be
   * modified to do so
   *
   * @param n an integer representing the new number of stars of the unit
   */
  def currentHP_=(n: Int): Unit

  /**Returns the attack of the unit
  *
  * @return an integer representing the attack of the unit */
  def attack: Int

  /** Returns the defense of the unit
   *
   * @return an integer representing the defense of the unit */
  def defense: Int

  /** Returns the evasion of the unit
   *
   * @return an integer representing the evasion of the unit */
  def evasion: Int

  /** Returns the quantity of stars that the unit currently has
   *
   * @return an integer representing the current stars of the unit
   */
  def stars: Int

  /** Changes the current stars of the units
   *
   * @param n an integer representing the new quantity of stars */
  def stars_=(n: Int): Unit

  /** Returns the name of the game unit
   *
   * @return a string representing the name of the unit
   */
  def name: String

  /** Returns the combat stance of the Unit */
  def stance: Option[CombatStance]

  /** Changes the current combat stance of the Unit */
  def stance_=(s: CombatStance): Unit

  /** Rolls a dice and returns a value between 1 to 6 representing the faces of a dice
   *
   * @return an int between 1-6 (including 1 and 6)
   */
  def rollDice(): Int

  /** Method that allows a unit to increase the victories of another one
   *
   * in the context of a game this method is meant to be used after a combat is finished,
   * and this is the only ways this variable from player characters is increased/changed
   *
   * @param p the player that will gain the victories
   */
  def increaseVictoriesTo(p: PlayerCharacter): Unit

  /** Method that allows a game unit to win stars
   *
   * in the context of the game a unit will win stars from another
   * when winning a combat against them
   *
   * @param unit the unit that was defeated and will drop stars
   */
  def winStars(unit: GameUnit): Unit

  /** Method that allow a unit to drop their stars to a PlayerCharacter
   *
   * in the context of the game, the kinds of game unit have uniques ways to
   * drop their stars
   *
   * @param unit the unit that will gain the stars dropped
   */
  def dropStarsTo(unit: GameUnit): Unit

  /** Method that allows a unit to attack another one
   *
   * @param receiver the unit that will receive an attack
   */
  def attackUnit(receiver: GameUnit): Unit
}
