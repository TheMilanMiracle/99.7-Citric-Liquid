package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** This class represent the Bonus type of panel
 *
 * When a player lands on this panel, the player has to roll the dice
 * to obtain a number of stars, depending on the number obtained from the dice
 * and the norma that it has
 *
 * after triggering the effect, the player's turn will end
 *
 * @param next array containing the panels directly next to this one
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class BonusPanel(next: ArrayBuffer[Panel], pos: Int) extends abstractPanel {
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
   * This method will make the player that triggered the effect roll the dice
   * and give him a number of stars depending on the roll number an the player's norma
   *
   * the player will win min(roll * norma, roll * 3) stars
   *
   */
  def triggerEffect(): Unit = {
    val lastplayer: PlayerCharacter = this.characters(characters.size - 1)
    val roll: Int = lastplayer.rollDice()

    val min = (roll * lastplayer.norma.getInt).min(roll * 3)
    lastplayer.varyStars(min)
  }

}
