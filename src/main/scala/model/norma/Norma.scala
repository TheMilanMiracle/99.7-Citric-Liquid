package cl.uchile.dcc.citric
package model.norma

/** An interface that represents the level of "Norma"'s that a player can have
 *
 * -A player character will win the game when his level of norma reaches 6
 * -Every player starts the game with norma level 1
 * -Every level of norma is represented with a different class
 *
 * a norma instance should be able to:
 * -return an int representing its level
 * -check if the requirements for leveling up are met
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait Norma {
  /** Method that returns an int of the norma level that is represented by the instance */
  def getInt: Int

  /**Method that checks if the requirements for leveling up are met
   *
   * @param current the current quantity of stars/victories for checking
   * @param objective the objective of the player, it could be "stars"/"victories"
   */
  def normaCheck(current: Int, objective: String): Boolean
}







