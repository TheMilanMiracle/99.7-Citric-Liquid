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
 * - Vary and return their own current HP
 * - return and vary their own stars
 * - return their own name
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait GameUnit {
  /** Maximum health the unit can have
   *
   *  In the context of the game, units can be healed, this attributes is useful
   *  to not surpass it when healing the unit
   *
   */
  val maxHP: Int

  /** Current hp of the unit
   *
   *  Units health can vary when a combat with another Unit is initiated
   *  its value is initiated with the maxHp declared at the constructor of
   *  the class
   *
   */
  var _currentHP: Int

  /** Base attack of the unit
   *
   *  It defines the damage dealing capacities of a unit
   *
   */
  val _attack: Int

  /** Base defense of the unit
   *
   *  It defines damage mitigation capacities of a unit
   *
   */
  val _defense: Int

  /** Base evasion of the unit
   *
   *  It defines the capacity of the unit of completely avoid certain attacks
   *
   */
  val _evasion: Int

  /** The name of the unit
   *
   *  Every unit has a name, in the case of player character it has to be unique,
   *  in the case of wild units it has to be one of the ones that are
   *  available in the game
   *
   */
  val _name: String

  /** Stars that the Unit has
   *
   * Units can holds stars and the number can vary depending on the
   * outcome of combats with other Units, the stars start at 0
   *
   */
  var _stars: Int

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

  /** A Unit can vary their own current hp
   *
   * In the context of the game, any game unit can engage
   * combat, so it is required that they can vary their own current hp
   *
   * this variable can NOT be less than zero or over the unit maxHP
   */
  def varyCurrentHP(delta: Int): Unit

  /** Returns the current HP of the unit
   *
   * @return the current HP of the unit
   */
  def currentHP: Int

  /** Returns the quantity of stars that the unit currently has
   *
   * @return the current stars of the unit
   */
  def stars: Int

  /** A Unit can vary their own current hp
   *
   * In the context of the game, any game unit can engage
   * combat, so it is required that they can vary their own current hp
   *
   * this variable can NOT be less than zero or over the unit maxHP
   */
  def varyStars(delta:Int): Unit

  /** Returns the name of the game unit
   *
   * @return the name of the unit
   */
  def name: String

}
