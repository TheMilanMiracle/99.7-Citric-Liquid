package cl.uchile.dcc.citric
package model.objectives

import model.units.PlayerCharacter

/** An interface that represent the objective of a player
 *
 * in the context of the game a player's objective is the way that a player will try
 * to level up its norma level
 *
 * An objective should be able to:
 * - correctly perform a norma check
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait Objective {
  /**Method that will perform a norma check on a player
   * depending their objective
   *
   * @param player the player that has this objective and want to perform a norma check
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheck(player: PlayerCharacter): Boolean
}
