package cl.uchile.dcc.citric
package model.units

/** The IWildUnit interface represents the not controllable units,
 * they hold the same attributes that a game unit has
 *
 * besides them, a wild unit should be also able to:
 * - Drop stars to a player (intended for when a wild unit is defeated in combat)
 * - Take stars from a player (intended for when a wild unit defeats a player in combat)
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */

trait IWildUnit extends IUnit{

  /** A method that wil take half of the stars of a player
   * an adds them to the stars quantity of the wild unit
   *
   * @param player: the player whose stars will be removed
   */
  def takeStarsFrom(player:PlayerCharacter): Unit

  /** A method that wil give to a player the stars that
   * the wild unit is holding
   *
   * @param player : the player to whom the stars will be given
   */
  def dropStarsTo(player:PlayerCharacter): Unit
}
