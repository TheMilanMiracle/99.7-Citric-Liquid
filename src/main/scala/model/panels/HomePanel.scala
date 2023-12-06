package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

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
 * @param panel_owner the player character to own this home panel
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class HomePanel(pos: Int, panel_owner: PlayerCharacter) extends AbstractPanel(pos) {
  /** The PlayerCharacter that owns this panel
   *
   * In the context of the game, a Home Panel should be able to tell if a passing by PlayerCharacter
   * is its owner, to let them stop in this position
   */
  private val _owner: PlayerCharacter = panel_owner

  /** Getter for the player character owner of this home panel */
  def owner: PlayerCharacter = {this._owner}

  /** Triggers the effect of the panel
   *
   * if possible this method will heal one health point to the player that landed on the panel
   * and will do a norma check (check if the player matches the requirements to upgrade
   * his norma level)
   *
   * @param c context of the panel
   */
  def apply(c: GameController): Unit = {
    val lastplayer: PlayerCharacter = this.characters(characters.size - 1)
    val norma = lastplayer.norma

    lastplayer.currentHP = ( lastplayer.currentHP + 1)

    lastplayer.normaCheck()

    //for simplicity, if there is another player in the panel it triggers combat with the last one in
    if (characters.length > 1) c.combatPvP()
    else c.noCombat()
  }

}
