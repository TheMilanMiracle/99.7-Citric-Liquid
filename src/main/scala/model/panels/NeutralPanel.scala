package cl.uchile.dcc.citric
package model.panels

import scala.collection.mutable.ArrayBuffer

/** This class represent the Neutral type of panel
 *
 * When a player lands on this panel nothing is meant to happen, and the player's
 * tur should end afterwards
 *
 * @param next array containing the panels directly next to this one
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NeutralPanel(next: ArrayBuffer[Panel], pos: Int) extends abstractPanel {
  /** An array of panels that are directly positioned next to this one
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   */
  var nextPanels: ArrayBuffer[Panel] = next

  /** The position of the panel on the board
   *
   * every panel has its own unique position in the board that has to be defines at
   * the beginning of a game
   *
   */
  var position: Int = pos

  /** Triggers the effect of the panel
   *
   * This method will do nothing
   * In the context of the game, when a player lands in this kind of panel
   * his turn will end with no changes
   *
   */
  def triggerEffect(): Unit = {}

}
