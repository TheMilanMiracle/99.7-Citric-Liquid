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
 * @param next array containing the panels directly next to this one
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class EncounterPanel(next: ArrayBuffer[Panel], pos: Int) extends abstractPanel{
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
   * @return
   */
  def spawnWildUnit(): WildUnit = {
    val rand: Int = between(1,4)

    if(rand == 1) new Chicken()
    if(rand == 2) new RoboBall()
    else new Seagull()
  }

}
