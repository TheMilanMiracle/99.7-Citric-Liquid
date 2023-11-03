package cl.uchile.dcc.citric
package model.stance

import model.units.GameUnit

/** Class that represent the evading combat stance
 *
 * In the context of the game, a unit that try to evade an attack
 * could evade the attack completely or fail to do so and get the whole hit
 *
 * the evading stance should able to:
 * - receive an attack and try to evade it
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class EvadingStance extends CombatStance {
  /** Method that defines how a combat stance react to an attack
   *
   * @param attacker the unit that is attacking the unit that has this stance
   * @param receiver the unit that is trying to evade the attack and owner of this stance */
  def reactToAttackFrom(attacker: GameUnit, receiver: GameUnit): Unit = {
    val attackRoll = attacker.rollDice()
    if(receiver.rollDice() + receiver.evasion <= attackRoll + attacker.attack){
      receiver.currentHP = receiver.currentHP - (attackRoll + attacker.attack)
    }
  }

}
