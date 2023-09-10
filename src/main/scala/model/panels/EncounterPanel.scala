package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer
import scala.util.Random.between

/** This class represent the Encounter type of panel
 *
 * When a player lands on this panel, the player will enter a combat
 * with a random generated wild unit
 *
 * after triggering the effect, the player's turn will end
 *
 * @param next array containing the panels directly next to this one
 */
class EncounterPanel(next: ArrayBuffer[Panel]) extends abstractPanel{
  /** An array of panels that are directly positioned next to this one
   *
   * In the context of the game, multiple routes or paths may exist, this could represent the
   * possible next steps a player might take after being on this panel.
   *
   * @return a List of Panel instances that are adjacent or connected to this panel.
   */
  var nextPanels: ArrayBuffer[Panel] = next

  /** The wild unit in the panel
   *
   * The panel has to have a wild unit, that will be generated randomly each time
   * the initial wild unit will also be generated randomly
   *
   */
    var wildUnit: IUnit = spawnWildUnit()

  /** Triggers the effect of the panel
   *
   * this method
   *
   */
  def triggerEffect(): Unit = {
    val lastplayer: PlayerCharacter = this.characters(characters.size - 1)

    startFight(lastplayer, wildUnit)
  }

  /** Method that will spawn a random wild unit
   *
   * The function will decide randomly between the 3 possible wild
   * units: chicken, robo-ball and seagull
   *
   * @return
   */
  def spawnWildUnit(): IUnit = {
    val rand: Int = between(1,4)

    if(rand == 1) new Chicken()
    if(rand == 2) new RoboBall()
    if(rand == 3) new Seagull()
  }

}