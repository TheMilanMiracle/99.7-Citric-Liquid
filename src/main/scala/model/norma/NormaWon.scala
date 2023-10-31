package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the *state* of having won the game
 * is not exactly a norma, its meant to be used like a 'None' of the norma type
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaWon extends Norma{
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return an int that represents a norma level
   */
  def getInt: Int = -1

  /** Method that checks if the requirements for leveling up are met
   *
   * @param current   the current quantity of stars for checking
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheckStars(current: Int): Boolean = false

  /** Method that checks if the requirements for leveling up are met
   *
   * @param current   the current quantity of victories for checking
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheckVictories(current: Int): Boolean = false

  /** Method that return the norma level new to the current one
   *
   * in this case the class just returns itself
   */
  def getNext: Norma = this

}
