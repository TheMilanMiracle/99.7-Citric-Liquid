package cl.uchile.dcc.citric
package model.panels

import controller.GameController
import model.units.{Chicken, RoboBall, Seagull, WildUnit}
import scala.util.Random

/** This class represent the Encounter type of panel
 *
 * When a player lands on this panel, the player will enter a combat
 * with a random generated wild unit
 *
 * after triggering the effect, the player's turn will end
 *
 * @param pos integer of the position of the panel on the board
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class EncounterPanel(pos: Int) extends AbstractPanel(pos){
  /** The wild unit in the panel
   *
   * The panel has to have a wild unit, that will be generated randomly each time
   * when the the variable is empty it means there is no wild unit yet
   */
  private var _wildUnit: Option[WildUnit] = None

  /** Getter for the wild unit of the encounter of the panel */
  def wildUnit: WildUnit = {
    if(_wildUnit.isEmpty) spawnWildUnit()
    _wildUnit.get
  }

  /** Method that empties the wild unit variable
   *
   * calling this method means that the wild unit was defeated
   * so the panel doesnt have one now
   */
  def wildUnitDefeated(): Unit = {
    _wildUnit = None
  }

  /** Triggers the effect of the panel
   *
   * this method will make the player that lands on it engage combat with
   * a random wild unit
   *
   * @param c context of the panel
   */
  def apply(c: GameController): Unit = {
    if(_wildUnit.isEmpty) spawnWildUnit()

    c.combatPvW(this)
  }

  /** Method that will spawn a random wild unit
   *
   * The function will decide randomly between the 3 possible wild
   * units: chicken, robo-ball and seagull
   *
   * @return a random wild unit, it could be a chicken, robo ball or seagull
   */
  private def spawnWildUnit(): Unit = {
    val rand: Int = Random.between(1,4)

    if(rand == 1) _wildUnit = Some(new Chicken())
    if(rand == 2) _wildUnit = Some(new RoboBall())
    else _wildUnit = Some(new Seagull())
  }

}
