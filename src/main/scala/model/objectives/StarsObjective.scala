package cl.uchile.dcc.citric
package model.objectives

import model.units.PlayerCharacter

/** A class that represent the objective of Stars
 *
 * in the context of the game, a player that has this objective represent
 * that the player will try to level its norma through getting stars
 *
 * an stars objective:
 * - correctly perform a norma check using stars
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class StarsObjective extends Objective {
  /** Method that will perform a norma check on a player
   * depending their objective
   *
   * @param player the player that has this objective and want to perform a norma check
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheck(player: PlayerCharacter): Boolean = {
    player.norma.normaCheckStars(player.stars)
  }
}
