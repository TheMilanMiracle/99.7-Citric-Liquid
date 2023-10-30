package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/** An abstract class that implements common behaviour between Game Units
 *
 *  it implements the next common behaviours:
 * - a game unit can get their basics stats HP, attack, defense, evasion and its name
 * - a game unit can get and set their current HP, maintaining the value between 0 and maxHP
 * - a game unit can get and set their current number of stars
 *
 * @param unit_maxHP maximum health point the unit can have
 * @param unit_attack attack that the unit has
 * @param unit_defense defense that the unit has
 * @param unit_evasion evasion that the unit has
 * @param unit_name name of the unit
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
abstract class abstractGameUnit(unit_maxHP: Int, unit_attack: Int, unit_defense: Int, unit_evasion: Int, unit_name: String) extends GameUnit {
  /** Maximum health the unit can have
   *
   * In the context of the game, units can be healed, this attributes is useful
   * to not surpass it when healing the unit
   *
   */
  private val _maxHP: Int = unit_maxHP

  /** Current hp of the unit
   *
   * Units health can vary when a combat with another Unit is initiated
   * its value is initiated with the maxHp declared at the constructor of
   * the class
   *
   */
  private var _currentHP: Int = unit_maxHP

  /** Base attack of the unit
   *
   * It defines the damage dealing capacities of a unit
   *
   */
  private val _attack: Int = unit_attack

  /** Base defense of the unit
   *
   * It defines damage mitigation capacities of a unit
   *
   */
  private val _defense: Int = unit_defense

  /** Base evasion of the unit
   *
   * It defines the capacity of the unit of completely avoid certain attacks
   *
   */
  private val _evasion: Int = unit_evasion

  /** The name of the unit
   *
   * Every unit has a name, in the case of player character it has to be unique,
   * in the case of wild units it has to be one of the ones that are
   * available in the game
   *
   */
  private val _name: String = unit_name

  /** Stars that the Unit has
   *
   * Units can holds stars and the number can vary depending on the
   * outcome of combats with other Units
   * Any kind of unit starts with 0 stars
   *
   */
  private var _stars: Int = 0

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

  /** Rolls a dice and returns a value between 1 to 6 representing the faces of a dice
   *
   * @return an int between 1-6 (including 1 and 6)
   */
  def rollDice(): Int = {Random.between(1,7)}

  /** Method that allows a game Unit to attack another one
   *
   * the damage depends on a dice roll and the unit attack stat
   *
   * @return an integer representing how much raw damage the unit will make
   */
  def attack(gu: GameUnit): Int = {
    val roll_attack = this.rollDice()

    this.attack + roll_attack
  }

  /** Method that allows a game Unit to defend itself from an attack
   *
   * the damage absorbed depends on a dice roll and the unit defense stat
   *
   * @return an integer representing how much damage the unit will not receive from the attack
   */
  def defend(gu: GameUnit): Int = {
    val roll_defense = this.rollDice()

    this.defense + roll_defense
  }

  /** Method that allows a game Unit to evade an attack from another one
   *
   * the capability of evading an attack depends on a dice roll an the unit evasion stat
   *
   * @return an integer representing how much capability of evading the attack the unit has
   */
  def evade(gu: GameUnit): Int = {
    val roll_evasion = this.rollDice()

    this.evasion + roll_evasion
  }
}
