package cl.uchile.dcc.citric
package model.norma

import model.utilities.clonableEntity

/** An abstract class that that implements common behaviour between normas
 * and set some private attributes that the normas have
 *
 * it implements:
 * - norma check method for stars
 * - norma check method for victories
 * - getNext method
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
abstract class AbstractNorma(stars: Int, victories: Int, next: Option[Norma]) extends Norma with clonableEntity[Norma]{
  /** The amount of stars that the current level requires to level up */
  private val stars_required: Int = stars

  /** The amount of victories that the current level requires to level up */
  private val victories_required: Int = victories

  /** The norma level next to this one */
  private val _next: Option[Norma] = next

  /** Method that return the norma level new to the current one
   *
   * the last level just returns itself
   */
  def getNext: Norma = {
    if(_next.isDefined) {this._next.get}
    else new NormaLevel6
  }

  /** Method that checks if the requirements for leveling up are met
   *
   * @param current the current quantity of stars for checking
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheckStars(current: Int): Boolean = {
    this.stars_required <= current
  }

  /** Method that checks if the requirements for leveling up are met
   *
   * @param current the current quantity of victories for checking
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheckVictories(current: Int): Boolean = {
    this.victories_required <= current
  }
}
