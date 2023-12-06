package cl.uchile.dcc.citric
package model.objectives

import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

/** A class that represent the objective of Victories
 *
 * in the context of the game, a player that has this objective represent
 * that the player will try to level its norma through getting victories
 *
 * an stars objective:
 * - correctly perform a norma check using victories
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class VictoriesObjective extends Objective {
  /** Method that will perform a norma check on a player
   * depending their objective
   *
   * @param player the player that has this objective and want to perform a norma check
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheck(player: PlayerCharacter): Boolean = {
    player.norma.normaCheckVictories(player.victories)
  }
}
