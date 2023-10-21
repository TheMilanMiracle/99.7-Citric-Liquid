package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.norma.NormaList
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
 * @param pos integer of the position of the panel on the board
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class HomePanel(pos: Int) extends abstractPanel(pos) {
  /** Triggers the effect of the panel
   *
   * if possible this method will heal one health point to the player that landed on the panel
   * and will do a norma check (check if the player matches the requirements to upgrade
   * his norma level)
   *
   */
  def apply(): Unit = {
    val lastplayer: PlayerCharacter = this.characters(characters.size - 1)
    val norma = lastplayer.norma
    val normaList = new NormaList()

    lastplayer.currentHP = ( lastplayer.currentHP + 1)

    if(lastplayer.objective == "stars"){
      if(norma.normaCheck(lastplayer.stars, lastplayer.objective)){
        lastplayer.norma_=(normaList.next(norma))
      }
    }
    else{
      if(norma.normaCheck(lastplayer.victories, lastplayer.objective)){
        lastplayer.norma_=(normaList.next(norma))
      }
    }
  }

}
