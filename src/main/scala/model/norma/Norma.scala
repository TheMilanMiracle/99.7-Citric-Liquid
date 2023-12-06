package cl.uchile.dcc.citric
package model.norma

import model.norma.factory.NormaFactory

/** An interface that represents the level of "Norma"'s that a player can have
 *
 * -A player character will win the game when his level of norma reaches 6
 * -Every player starts the game with norma level 1
 * -Every level of norma is represented with a different class
 *
 * a norma instance should be able to:
 * -return an int representing its level
 * -check if the requirements for leveling up are met according to the stars
 * -check if the requirements for leveling up are met according to the victories
 * -return which normaLevel factory is next the current one
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait Norma {
  /** Method that returns an int of the norma level that is represented by the instance
   * @return an int that represents a norma level
   */
  def getInt: Int

  /**Method that checks if the requirements for leveling up are met
   *
   * @param current the current quantity of stars for checking
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheckStars(current: Int): Boolean

  /** Method that checks if the requirements for leveling up are met
   *
   * @param current the current quantity of victories for checking
   * @return a boolean, whether or not the requirements are met for leveling up
   */
  def normaCheckVictories(current: Int): Boolean

  /** Method that return the factory of the norma level new to the current one */
  def getNext: NormaFactory
}








