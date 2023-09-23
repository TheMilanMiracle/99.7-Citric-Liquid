package cl.uchile.dcc.citric
package model.units

/** An abstract class that implements common behaviour between Game Units
 *
 *  it implements the next common behaviours:
 * - a game unit can vary their own current HP
 * - a game unit can return and vary their own stars
 * - a game unit can return their own name
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait abstractGameUnit extends GameUnit {
  /** A Unit can vary their own current hp
   *
   * In the context of the game, any game unit can engage
   * combat, so it is required that they can vary their own current hp
   *
   * this variable can NOT be less than zero or over the unit maxHP
   *
   * @param delta how much the currentHP value is gonna change
   */
  def varyCurrentHP(delta: Int):Unit = {
    this.currentHP += delta
    if(this.currentHP > this.maxHP) this.currentHP = this.maxHP
    if(this.currentHP < 0) this.currentHP = 0
  }

  /** Returns the current HP of the unit
   *
   * @return the current HP of the unit
   */
  def getCurrentHP: Int = this.currentHP

  /** Returns the quantity of stars that the unit currently has
   *
   * @return the current stars of the unit
   */
  def getStars: Int = this.stars

  /** A Unit can vary their own current hp
   *
   * In the context of the game, any game unit can engage
   * combat, so it is required that they can vary their own current hp
   *
   * this variable can NOT be less than zero or over the unit maxHP
   *
   * @param delta how much the stars value is gonna change
   */
  def varyStars(delta: Int): Unit = {this.stars += delta}

  /** Returns the name of the game unit
   *
   * @return the name of the unit
   */
  def getName: String = {this.name}
}
