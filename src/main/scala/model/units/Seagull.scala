package cl.uchile.dcc.citric
package model.units

/** Class that represent the wild unit Seagull
 * this class defines the base values for maxHp, attack,
 * defense, evasion, stars and name
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class Seagull extends abstractWildUnit {
  /** Maximum health the unit can have
   *
   * In the context of the game, units can be healed, this attributes is useful
   * to not surpass it when healing the unit
   *
   */
  val _maxHP: Int = 3

  /** Current hp of the unit
   *
   * Units health can vary when a combat with another Unit is initiated
   * its value is initiated with the maxHp declared at the constructor of
   * the class
   *
   */
  var _currentHP: Int = _maxHP

  /** Base attack of the unit
   *
   * It defines the damage dealing capacities of a unit
   *
   */
  val _attack: Int = 1

  /** Base defense of the unit
   *
   * It defines damage mitigation capacities of a unit
   *
   */
  val _defense: Int = -1

  /** Base evasion of the unit
   *
   * It defines the capacity of the unit of completely avoid certain attacks
   *
   */
  val _evasion: Int = -1

  /** The name of the unit
   *
   * Every unit has a name, in the case of player character it has to be unique,
   * in the case of wild units it has to be one of the ones that are
   * available in the game
   *
   */
  val _name: String = "Seagull"

  /** Method that allow a unit to drop their stars to a PlayerCharacter
   *
   * when a seagull drops its stars, it will give all of its stars + 2 to a PlayerCharacter
   *
   * @param player the player character that will gain the stars dropped
   */
  def dropStarsTo(player: PlayerCharacter): Unit = {
    player.stars = player.stars + (this.stars + 2)
  }
}
