package cl.uchile.dcc.citric
package model.stance

import model.units.GameUnit

/** Interface that represent the combat stance of a player
 *
 * in the context of the game a player have a combat stance that defines
 * how will a player react to receiving an attack
 *
 * because of this, a combat stance should be able to:
 * - receive an attack
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait CombatStance {
  /**  Method that defines how a combat stance react to an attack
   *
   * @param attacker the unit that is attacking the unit that has this stance
   * @param receiver the unit that is receiving an attack and owner of this stance*/
  def reactToAttackFrom(attacker: GameUnit, receiver: GameUnit): Unit
}
