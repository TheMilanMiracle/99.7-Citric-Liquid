package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** Represents a single cell on a board, known as a Panel.
  *
  * Each panel has its own effect, which can be applied to a character.
  * In the context of the board game, a panel represents a tile or space that a character lands on
  * and experiences an effect (e.g., losing stars, fighting an enemy, etc.).
  * Panels can also be connected to other panels, allowing for the formation of complex board
  * structures.
  *
  * A panel should be able to:
  * - get its position on the board, a copy of its players and a copy of its next panels
  * - Hold one or more players
  * - Be able to add and remove a player from the panel
  * - Be able to add and remove a panel from its next panels
  *
  * @author [[https://github.com/r8vnhill Ignacio Slater M.]]
  * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
  */
trait GamePanel {
  /** returns the panels next to this one (not modifiable)
   *
   * @return an array buffer of panels, this are the ones positioned next to this one
   */
  def nextPanels: ArrayBuffer[GamePanel]

  /** returns the position of the panel
   *
   * @return an integer representing the position of the panel in the board
   */
  def position: Int

  /** returns the characters on the panel
   *
   * @return an array buffer of PlayerCharacters representing the characters currently on the panel
   */
  def characters: ArrayBuffer[PlayerCharacter]

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

  /** Adds a Panel to the list of panels currently next to this panel.
   *
   * @param panel The panel that will be added to this panel next list.
   */
  def addPanel(panel: GamePanel): Unit

    /** Removes a Panel from the list of panels currently next to this panel.
   *
   * @param panel The panel that will be removed from this panel next list.
   */
  def removePanel(panel: GamePanel): Unit

  /** Triggers the effect of the panel
   *
   *  This method will trigger a different effect depending on the type of the panel
   *
   * @param c context of the panel
   */
  def apply(c: GameController): Unit
}
