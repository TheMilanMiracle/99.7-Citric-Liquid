package cl.uchile.dcc.citric
package model.units

/** Class that represent the wild unit Chicken
 * this class defines the base values for maxHp, attack,
 * defense, evasion, stars and name
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class Chicken extends AbstractWildUnit(3, -1, -1, 1, "Chicken") {
  /** Method that allow a unit to drop their stars to a PlayerCharacter
   *
   * when a chicken drops its stars, it will give all of its stars + 3 to a PlayerCharacter
   * (this method will never be called to drop stars to another wild unit)
   *
   * @param unit the unit that will gain the stars dropped
   */
  def dropStarsTo(unit: GameUnit): Unit  = {
    unit.stars = unit.stars + (this.stars + 3)
  }
}
