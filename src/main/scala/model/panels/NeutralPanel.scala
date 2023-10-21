package cl.uchile.dcc.citric
package model.panels

import scala.collection.mutable.ArrayBuffer

/** This class represent the Neutral type of panel
 *
 * When a player lands on this panel nothing is meant to happen, and the player's
 * tur should end afterwards
 *
 * @param pos integer of the position of the panel on the board
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NeutralPanel(pos: Int) extends abstractPanel(pos) {
  /** Triggers the effect of the panel
   *
   * This method will do nothing
   * In the context of the game, when a player lands in this kind of panel
   * his turn will end with no changes
   *
   */
  def apply(): Unit = {}

}
