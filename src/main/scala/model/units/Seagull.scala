package cl.uchile.dcc.citric
package model.units

/** Class that represent the wild unit Seagull
 * this class defines the base values for maxHp, attack,
 * defense, evasion, stars and name
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class Seagull extends abstractWildUnit(3, 1, -1, -1, "Seagull") {
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
