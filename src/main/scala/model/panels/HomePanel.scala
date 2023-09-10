package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** This class represent the Home type of panel
 *
 * Each player has a personal home panel that is picked when the game begins,
 * this kind of panel can be triggered in two different ways:
 *
 * -when a player lands on the panel
 * -when the owner of the home panel run into this panel and decides to stop in its position
 *
 *  after triggering the effect, the player's turn will end
 *
 * @param next array containing the panels directly next to this one
 */
class HomePanel(next: ArrayBuffer[Panel]) extends abstractPanel {
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
   * if possible this method will heal one health point to the player that landed on the panel
   * and will do a norma check (check if the player matches the requirements to upgrade
   * his norma level)
   *
   */
  def triggerEffect(): Unit = {
    val lastplayer: PlayerCharacter = characters(characters.size - 1)
    if(lastplayer.currentHP <= lastplayer.maxHP) lastplayer.currentHP += 1

    if(lastplayer.norma == 1 && (lastplayer.stars >= 10 || lastplayer.victories >= 1)) lastplayer.norma += 1
    if(lastplayer.norma == 2 && (lastplayer.stars >= 30 || lastplayer.victories >= 3)) lastplayer.norma += 1
    if(lastplayer.norma == 3 && (lastplayer.stars >= 70 || lastplayer.victories >= 6)) lastplayer.norma += 1
    if(lastplayer.norma == 4 && (lastplayer.stars >= 120 || lastplayer.victories >= 10)) lastplayer.norma += 1
    if(lastplayer.norma == 5 && (lastplayer.stars >= 200 || lastplayer.victories >= 14)) lastplayer.norma += 1
  }

}
