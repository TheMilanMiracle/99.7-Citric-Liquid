package cl.uchile.dcc.citric
package model.stance

import model.units.{GameUnit, PlayerCharacter}

/** Class that represent the defending combat stance
 *
 * In the context of the game, a unit that defends an attack is able
 * to block part of the damage depending on the stats of the related units
 *
 * the defending stance should able to:
 * - receive an attack and block part of its damage
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class DefendingStance extends CombatStance {
  /** Method that defines how a combat stance react to an attack
   *
   * @param attacker the unit that is attacking the unit that has this stance
   * @param receiver the unit that is defending the attack and owner of this stance */
  def reactToAttackFrom(attacker: GameUnit, receiver: GameUnit): Unit = {
    //receiver.currentHP = receiver.currentHP - (1.max(attacker.rollDice() + attacker.attack - (receiver.rollDice() + receiver.defense)))
    receiver.currentHP = receiver.currentHP - 1
  }

}
