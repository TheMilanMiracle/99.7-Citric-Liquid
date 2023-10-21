package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** This class represent the Drop type of panel
 *
 * When a player lands on this panel, the player has to roll the dice
 * and he will lose stars, depending on the number obtained from the dice
 * and the norma that it has
 *
 * after triggering the effect, the player's turn will end
 *
 * @param pos integer of the position of the panel on the board
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class DropPanel(pos: Int) extends abstractPanel(pos){
  /** Triggers the effect of the panel
   *
   * This method will make the player that triggered the effect roll the dice
   * and make him lose a number of stars equals to roll * norma
   *
   */
  def apply(): Unit = {
    val lastplayer: PlayerCharacter = this.characters(characters.size - 1)
    val roll: Int = lastplayer.rollDice()

    lastplayer.stars_=(lastplayer.stars - (roll * lastplayer.norma.getInt))
  }

}
