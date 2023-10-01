package cl.uchile.dcc.citric
package model.units

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
 *
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

  /** Rolls a dice and returns a value between 1 to 6 representing the faces of a dice
   *
   * @return an int between 1-6 (including 1 and 6)
   */
  def rollDice(): Int

  /** Method that allows a game Unit to attack another one
   *
   * the damage depends on a dice roll and the unit attack stat
   *
   * @return an integer representing how much raw damage the unit will make
   */
  def attack(gu: GameUnit): Int

  /** Method that allows a game Unit to defend itself from an attack
   *
   * the damage absorbed depends on a dice roll and the unit defense stat
   *
   * @return an integer representing how much damage the unit will not receive from the attack
   */
  def defend(gu: GameUnit): Int

  /** Method that allows a game Unit to evade an attack from another one
   *
   * the capability of evading an attack depends on a dice roll an the unit evasion stat
   *
   * @return an integer representing how much capability of evading the attack the unit has
   */
  def evade(gu: GameUnit): Int
}
