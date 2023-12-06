package cl.uchile.dcc.citric
package model.norma

import model.norma.factory.NullNormaFactory

/** A Class that represents the NullObject of a norma
 *
 * This is the level comes after level 5 and is the final level, meaning that if a
 * player has it, he won the game. Therefore this norma level is the only one that will
 * never norma check, it also returns -1 because is not really a norma that a player
 * will have *during* a game
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NullNorma extends AbstractNorma(-1, -1, None){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return -1, this norma is not supposed to act like the others
   */
  def getInt: Int = -1
}
