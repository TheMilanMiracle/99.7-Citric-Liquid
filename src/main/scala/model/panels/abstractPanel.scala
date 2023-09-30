package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

/** An abstract class that implements common behaviour between Panels
 *
 *  even tho each kind of panel has its own effect, there are some actions/values
 *  that every panel has to be able to do/have independent of its type and the
 *  implementation/value is the same
 *
 *  the common behaviour that this abstract class implements is:
 *  - A panel can get its position, a copy of its players and a copy of its panels
 *  - A panel can hold one or more players
 *  - A panel can add or remove a player from itself
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
abstract class abstractPanel extends Panel{
  /** An array of panels that are directly positioned next to this one
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   */
  protected val _nextPanels: ArrayBuffer[Panel]

  /** The position of the panel on the board
   *
   * every panel has its own unique position in the board that has to be defines at
   * the beginning of a game
   *
   */
  protected val _position: Int

  /** Array of the characters currently positioned on this panel.
   *
   * In the game, multiple characters might be on the same panel at once, e.g., if multiple players
   * land on the same space.
   * At the beginning of a game there are no player in any panel so the array begins
   * the game empty
   */
  protected val _characters: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()

  /** returns the panels next to this one (not modifiable)
   *
   * @return an array buffer of panels, this are the ones positioned next to this one
   */
  def nextPanels: ArrayBuffer[Panel] = {
    val aux = this._nextPanels
    aux
  }

  /**returns the position of the panel
   *
   * @return an integer representing the position of the panel in the board
   */
  def position: Int = {this._position}

  /** returns the characters on the panel
   *
   * @return an array buffer of PlayerCharacters representing the characters currently on the panel
   */
  def characters: ArrayBuffer[PlayerCharacter] = {
    val aux = this._characters
    aux
  }

  /** Adds a character to the list of characters currently on this panel.
   *
   * This method must be invoked when a player moves to this panel
   *
   * @param player The player character to add to this panel.
   */
  def addCharacter(player: PlayerCharacter): Unit = {
    this._characters.append(player)
  }

  /** Removes a character from the list of characters currently on this panel.
   *
   * This method must be invoked when a player moves off this panel.
   *
   * @param player The player character to remove from this panel.
   */
  def removeCharacter(player: PlayerCharacter): Unit = {
    this._characters -= player
  }
}
