package cl.uchile.dcc.citric
package model.units

/** The IUnit interface represent the entity that will participate
 * in the game, whether as a player character, controller by an user, or as a
 * wild unit, not controllable by an user. All game units have an unique name,
 * basic attributes as HP, attack, defense and evasion. Game units can hold
 * a quantity of stars that may vary throughout a game
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait IUnit {
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
  var currentHP: Int

  /** Base attack of the unit
   *
   *  It defines the damage dealing capacities of a unit
   *
   */
  val attack: Int

  /** Base defense of the unit
   *
   *  It defines damage mitigation capacities of a unit
   *
   */
  val defense: Int

  /** Base evasion of the unit
   *
   *  It defines the capacity of the unit of completely avoid certain attacks
   *
   */
  val evasion: Int

  /** The name of the unit
   *
   *  Every unit has a name, in the case of player character it has to be unique,
   *  in the case of wild units it has to be one of the ones that are
   *  available in the game
   *
   */
  val name: String

  /** Stars that the Unit has
   *
   * Units can holds stars and the number can vary depending on the
   * outcome of combats with other Units, the stars start at 0
   *
   */
  var stars: Int
}
