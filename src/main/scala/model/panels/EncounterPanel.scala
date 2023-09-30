package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.{Chicken, GameUnit, WildUnit, PlayerCharacter, RoboBall, Seagull}

import scala.collection.mutable.ArrayBuffer
import scala.util.Random.between

/** This class represent the Encounter type of panel
 *
 * When a player lands on this panel, the player will enter a combat
 * with a random generated wild unit
 *
 * after triggering the effect, the player's turn will end
 *
 * @param _nextPanels array containing the panels directly next to this one
 * @param _position integer of the position of the panel on the board
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class EncounterPanel(val _nextPanels: ArrayBuffer[Panel], val _position: Int) extends abstractPanel{
  /** The wild unit in the panel
   *
   * The panel has to have a wild unit, that will be generated randomly each time
   * the initial wild unit will also be generated randomly
   *
   */
  var wildUnit: WildUnit = spawnWildUnit()

  /** Triggers the effect of the panel
   *
   * this method will make the player that lands on it engage combat with
   * a random wild unit
   *
   */
  def triggerEffect(): Unit = {
    //val lastplayer: PlayerCharacter = this.characters(characters.size - 1)

    //startFight(lastplayer, wildUnit) //combat is not yet implemented
  }

  /** Method that will spawn a random wild unit
   *
   * The function will decide randomly between the 3 possible wild
   * units: chicken, robo-ball and seagull
   *
   * @return a random wild unit, it could be a chicken, robo ball or seagull
   */
  def spawnWildUnit(): WildUnit = {
    val rand: Int = between(1,4)

    if(rand == 1) new Chicken()
    if(rand == 2) new RoboBall()
    else new Seagull()
  }

}
