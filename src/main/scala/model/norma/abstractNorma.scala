package cl.uchile.dcc.citric
package model.norma

/** An abstract class that that implements common behaviour between normas
 * and set some private attributes that the normas have
 *
 * it implements:
 * - norma check method
 * - getNext method
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
abstract class abstractNorma(stars: Int, victories: Int, next: Norma) extends Norma {
  /** The amount of stars that the current level requires to level up */
  private val stars_required: Int = stars

  /** The amount of victories that the current level requires to level up */
  private val victories_required: Int = victories

  /** The norma level next to this one */
  private val _next = next

  /** Method that checks if the requirements for leveling up are met
   *
   * @param current   the current quantity of stars/victories for checking
   * @param objective the objective of the player, it could be "stars"/"victories"
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheck(current: Int, objective: String): Boolean = {
    if (objective == "stars") current >= this.stars_required
    else current >= this.victories_required
  }

  /** Method that return the norma level new to the current one
   *
   * the last level just returns itself
   */
  def getNext: Norma = {
    this._next
  }

}
