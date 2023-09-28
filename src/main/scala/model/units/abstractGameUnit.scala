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
abstract class abstractGameUnit extends GameUnit {
  /** Stars that the Unit has
   *
   * Units can holds stars and the number can vary depending on the
   * outcome of combats with other Units
   * Any kind of unit starts with 0 stars
   *
   */
  var _stars: Int = 0

  /** Returns the attack of the unit
   *
   * @return an integer representing the attack of the unit */
  def attack: Int = this._attack

  /** Returns the defense of the unit
   *
   * @return an integer representing the defense of the unit */
  def defense: Int = this._defense

  /** Returns the evasion of the unit
   *
   * @return an integer representing the evasion of the unit */
  def evasion: Int = this._evasion

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
    this._currentHP += delta
    if(this.currentHP > this.maxHP) this._currentHP = this.maxHP
    if(this.currentHP < 0) this._currentHP = 0
  }

  /** Returns the current HP of the unit
   *
   * @return the current HP of the unit
   */
  def currentHP: Int = this._currentHP

  /** Returns the quantity of stars that the unit currently has
   *
   * @return the current stars of the unit
   */
  def stars: Int = this._stars

  /** A Unit can vary their own current hp
   *
   * In the context of the game, any game unit can engage
   * combat, so it is required that they can vary their own current hp
   *
   * this variable can NOT be less than zero or over the unit maxHP
   *
   * @param delta how much the stars value is gonna change
   */
  def varyStars(delta: Int): Unit = this._stars += delta

  /** Returns the name of the game unit
   *
   * @return the name of the unit
   */
  def name: String = this._name
}
