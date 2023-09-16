package cl.uchile.dcc.citric
package model.units

/** An abstract class that implements common behaviour between Wilds Units
 *
 *  it implements the next common behaviours:
 * - Drop stars to a player (intended for when a wild unit is defeated in combat)
 * - Take stars from a player (intended for when a wild unit defeats a player in combat)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
abstract class abstractWildUnit extends IWildUnit {

  /** A method that wil take half of the stars of a player
   * an adds them to the stars quantity of the wild unit
   *
   * @param player : the player whose stars will be removed
   */
  def takeStarsFrom(player:PlayerCharacter): Unit = {
    this.stars += (player.stars / 2)
    player.stars /= 2
  }

  /** A method that wil give to a player the stars that
   * the wild unit is holding
   *
   * @param player : the player to whom the stars will be given
   */
  override def dropStarsTo(player: PlayerCharacter): Unit = {
    player.stars += this.stars
    this.stars = 0
  }
}