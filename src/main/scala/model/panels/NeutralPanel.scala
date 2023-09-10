package cl.uchile.dcc.citric
package model.panels

import scala.collection.mutable.ArrayBuffer

/** This class represent the Neutral type of panel
 *
 * When a player lands on this panel nothing is meant to happen, and the player's
 * tur should end afterwards
 *
 * @param next array containing the panels directly next to this one
 */
class NeutralPanel() extends abstractPanel {
  /** An array of panels that are directly positioned next to this one
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var nextPanels: ArrayBuffer[Panel] = next

  /** Triggers the effect of the panel
   *
   * This method will do nothing
   * In the context of the
   *
   */
  def triggerEffect(): Unit = {}

}
