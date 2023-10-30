package cl.uchile.dcc.citric
package model.units

/** Class that represent the wild unit Chicken
 * this class defines the base values for maxHp, attack,
 * defense, evasion, stars and name
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class Chicken extends abstractWildUnit(3, -1, -1, 1, "Chicken") {
  /** Method that allow a unit to drop their stars to a PlayerCharacter
   *
   * when a chicken drops its stars, it will give all of its stars + 3 to a PlayerCharacter
   *
   * @param player the player character that will gain the stars dropped
   */
  def dropStarsTo(player: PlayerCharacter): Unit  = {
    player.stars = player.stars + (this.stars + 3)
  }
}
