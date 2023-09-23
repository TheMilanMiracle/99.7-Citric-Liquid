package cl.uchile.dcc.citric
package model.norma

import scala.collection.mutable.ArrayBuffer

/** Class that represent a list with all the norma levels available in the game
 *
 * Particularly, the first level on the list will be the one level that every player will have when starting a game
 * and the last one will be the level that makes a player win the game when reached.
 *
 * This class should be able to:
 * - compare any level of norma and return if it is the last one on the list
 * - return the next level on the list from a given one
 * - return any norma level from the list
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class normaList{
  /**List that contains all of the norma levels to be had in the game
   *
   * Particularly, the first level on the list will be the one level that every player will have when starting a game
   * and the last one will be the level that makes a player win the game when reached.
   */
  private val List: ArrayBuffer[Norma] = ArrayBuffer[Norma](new NormaLevel1,new NormaLevel2, new NormaLevel3,
    new NormaLevel4, new NormaLevel5, new NormaLevel6)

  /** returns the norma with level equals to the given int
   *
   * @param level the norma level that wil be returned
   *
   * @return the norma level which int equals the given as a parameter
   */
  def getLevel(level: Int): Norma = {
    List(level - 1)
  }

  /** Method that check if the given norma level is the last one in the list
   *
   * @param norma the norma level that will be checked
   *
   * @return whether or not the norma level given as a parameter is the last one in the norma list
   */
  def isLast(norma: Norma): Boolean = {
    norma.getInt == List(List.size-1).getInt
  }

  /** Method that returns the next norma level from a given one
   *
   * @param norma the previous norma from the returned one
   */
  def next(norma: Norma): Norma = {
    List(norma.getInt)
  }
}
