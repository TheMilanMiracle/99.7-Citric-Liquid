package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.{ArrayBuffer, ArrayStack}

/** An abstract class that implements common behaviour between Panels
 *
 *  even tho each kind of panel has its own effect, there are some actions/values
 *  that every panel has to be able to do/have independent of its type and the
 *  implementation/value is the same
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
abstract class abstractPanel extends Panel{
  /** Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   * At the beginning of a game there are no player in any panel so the array begins
   * the game empty
   */
  val characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()

  /** Adds a character to the list of characters currently on this panel.
   *
   * This method must be invoked when a player moves to this panel or starts their turn on it.
   *
   * @param player The player character to add to this panel.
   */
  def addCharacter(player: PlayerCharacter): Unit = {
    this.characters.append(player)
  }

  /** Removes a character from the list of characters currently on this panel.
   *
   * This method must be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */
  def removeCharacter(player: PlayerCharacter): Unit = {
    this.characters -= player
  }

  /** Defines the way a panel compares itself with other types
   *
   * @param obj an object that will be compared to the panel
   */
  override def equals(obj: Any): Boolean = {
    if(obj.isInstanceOf[Panel]){
      obj.asInstanceOf[Panel]
      obj.getClass == this.getClass
    }
    else false
  }
}
