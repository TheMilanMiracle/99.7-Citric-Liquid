package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter
import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
  */
trait Panel {

  /** Array of the characters currently positioned on this panel.
    *
    * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
    * land on the same space.
    */
  val characters: ArrayBuffer[PlayerCharacter]

  /** An array of panels that are directly positioned next to this one
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var nextPanels: ArrayBuffer[Panel]

  /** Adds a character to the list of characters currently on this panel.
    *
    * This method must be invoked when a player moves to this panel or starts their turn on it.
    *
    * @param player The player character to add to this panel.
    */
  def addCharacter(player: PlayerCharacter): Unit

  /** Removes a character from the list of characters currently on this panel.
    *
    * This method must be invoked when a player moves off this panel.
    *
    * @param player The player character to remove from this panel.
    */
  def removeCharacter(player: PlayerCharacter): Unit

  /** Triggers the effect of the panel
   *
   *  This method will trigger a different effect depending on the type of the panel
   *
   */
  def triggerEffect(): Unit

  /** Defines the way a panel compares itself with other types
   *
   * @param obj an object that will be compared to the panel
   */
  def equals(obj: Any): Boolean
}