package cl.uchile.dcc.citric
package model.units

import model.units.player.PlayerCharacter

/** The abstractWildUnit class implements the common behaviour between wild units
 *
 * the common behaviour that it implements is:
 * - a wild unit should be able to increase the victories of a player by 1
 *
 * @param unit_maxHP maximum health point the unit can have
 * @param unit_attack attack that the unit has
 * @param unit_defense defense that the unit has
 * @param unit_evasion evasion that the unit has
 * @param unit_name name of the unit
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */

abstract class AbstractWildUnit(unit_maxHP: Int,
                                unit_attack: Int,
                                unit_defense: Int,
                                unit_evasion: Int,
                                unit_name: String) extends AbstractGameUnit(unit_maxHP, unit_attack, unit_defense, unit_evasion, unit_name) with WildUnit {
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
