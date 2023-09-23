package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.norma.normaList
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
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class HomePanel(next: ArrayBuffer[Panel], pos: Int) extends abstractPanel {
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
   * if possible this method will heal one health point to the player that landed on the panel
   * and will do a norma check (check if the player matches the requirements to upgrade
   * his norma level)
   *
   */
  def triggerEffect(): Unit = {
    val lastplayer: PlayerCharacter = this.characters(characters.size - 1)
    val norma = lastplayer.getNorma
    val normaList = new normaList()

    if(lastplayer.getObjective == "stars"){
      if(norma.normaCheck(lastplayer.getStars, lastplayer.getObjective)){
        lastplayer.changeNorma(normaList.next(norma))
      }
    }
    else{
      if(norma.normaCheck(lastplayer.getVictories, lastplayer.getObjective)){
        lastplayer.changeNorma(normaList.next(norma))
      }
    }
  }

}
