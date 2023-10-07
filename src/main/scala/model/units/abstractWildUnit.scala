package cl.uchile.dcc.citric
package model.units

/** The abstractWildUnit class implements the common behaviour between wild units
 *
 * the common behaviour that it implements is:
 * - a wild unit should be able to increase the victories of a player by 1
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */

abstract class abstractWildUnit extends WildUnit{
  /** Method that allows a unit to increase the victories of another one
   *
   * in the context of a game this method is meant to be used after a combat is finished,
   * and this is the only ways this variable from player characters is increased/changed
   *
   * when a wild unit increases the victories of a player, this value is incremented by 1
   */
  def increaseVictoriesTo(p: PlayerCharacter): Unit = {
    p.victories = (p.victories + 1)
  }

}
