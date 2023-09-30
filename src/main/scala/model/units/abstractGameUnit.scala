package cl.uchile.dcc.citric
package model.units

/** An abstract class that implements common behaviour between Game Units
 *
 *  it implements the next common behaviours:
 * - a game unit can get their basics stats HP, attack, defense, evasion and its name
 * - a game unit can get and set their current HP, maintaining the value between 0 and maxHP
 * - a game unit can get and set their current number of stars
 *
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
abstract class abstractGameUnit extends GameUnit {
  /** Maximum health the unit can have
   *
   * In the context of the game, units can be healed, this attributes is useful
   * to not surpass it when healing the unit
   *
   */
  protected val _maxHP: Int

  /** Current hp of the unit
   *
   * Units health can vary when a combat with another Unit is initiated
   * its value is initiated with the maxHp declared at the constructor of
   * the class
   *
   */
  protected var _currentHP: Int

  /** Base attack of the unit
   *
   * It defines the damage dealing capacities of a unit
   *
   */
  protected val _attack: Int

  /** Base defense of the unit
   *
   * It defines damage mitigation capacities of a unit
   *
   */
  protected val _defense: Int

  /** Base evasion of the unit
   *
   * It defines the capacity of the unit of completely avoid certain attacks
   *
   */
  protected val _evasion: Int

  /** The name of the unit
   *
   * Every unit has a name, in the case of player character it has to be unique,
   * in the case of wild units it has to be one of the ones that are
   * available in the game
   *
   */
  protected val _name: String

  /** Stars that the Unit has
   *
   * Units can holds stars and the number can vary depending on the
   * outcome of combats with other Units
   * Any kind of unit starts with 0 stars
   *
   */
  protected var _stars: Int = 0

  /** Returns the maxHP of the unit
   *
   * @return an integer representing the maximum HP the unit can have */
  def maxHP: Int = {this._maxHP}

  /** Returns the current HP of the unit
   *
   * its value only can be between 0 and the maxHP of the unit
   *
   * @return an integer representing the current HP of the unit
   */
  def currentHP: Int = {this._currentHP}

  /** sets the current hp of the unit to a given number
   *
   * in case the given number is out of range, the set value will be
   * modified to do so
   *
   * @param n an integer representing the new hp of the unit
   */
  def currentHP_=(n: Int): Unit = {
    if(n <= 0) this._currentHP = 0
    else if(n >= this._maxHP) this._currentHP = this._maxHP
    else this._currentHP = n
  }

  /** Returns the attack of the unit
   *
   * @return an integer representing the attack of the unit */
  def attack: Int = {this._attack}

  /** Returns the defense of the unit
   *
   * @return an integer representing the defense of the unit */
  def defense: Int = {this._defense}

  /** Returns the evasion of the unit
   *
   * @return an integer representing the evasion of the unit */
  def evasion: Int = {this._evasion}

  /** Returns the quantity of stars that the unit currently has
   *
   * @return an integer representing the current stars of the unit
   */
  def stars: Int = {this._stars}

  /** Changes the current stars of the units
   *
   * @param n an integer representing the new quantity of stars */
  def stars_=(n: Int): Unit = {this._stars = n}

  /** Returns the name of the game unit
   *
   * @return a string representing the name of the unit
   */
  def name: String = {this._name}
}
