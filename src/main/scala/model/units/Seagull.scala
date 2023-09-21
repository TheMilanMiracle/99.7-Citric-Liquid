package cl.uchile.dcc.citric
package model.units

/** Class that represent the wild unit Seagull
 * this class defines the base values for maxHp, attack,
 * defense, evasion, stars and name
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class Seagull extends WildUnit {
  /** Maximum health the unit can have
   *
   * In the context of the game, units can be healed, this attributes is useful
   * to not surpass it when healing the unit
   *
   */
  val maxHP: Int = 3

  /** Current hp of the unit
   *
   * Units health can vary when a combat with another Unit is initiated
   * its value is initiated with the maxHp declared at the constructor of
   * the class
   *
   */
  var currentHP: Int = maxHP

  /** Base attack of the unit
   *
   * It defines the damage dealing capacities of a unit
   *
   */
  val attack: Int = 1

  /** Base defense of the unit
   *
   * It defines damage mitigation capacities of a unit
   *
   */
  val defense: Int = -1

  /** Base evasion of the unit
   *
   * It defines the capacity of the unit of completely avoid certain attacks
   *
   */
  val evasion: Int = -1

  /** Stars that the Unit has
   *
   * Units can holds stars and the number can vary depending on the
   * outcome of combats with other Units, the stars start at 0
   *
   */
  var stars: Int = 0

  /** The name of the unit
   *
   * Every unit has a name, in the case of player character it has to be unique,
   * in the case of wild units it has to be one of the ones that are
   * available in the game
   *
   */
  val name: String = "Seagull"
}
