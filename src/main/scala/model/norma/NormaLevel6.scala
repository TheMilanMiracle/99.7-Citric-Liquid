package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the level of "Norma" 6
 *
 * This is the level comes after level 5 and is the final level, meaning that if a
 * player has it, he won the game. Therefore this norma level is the only one that will
 * never norma check
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel6 extends AbstractNorma(-1, -1, None){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return -1, this norma is not supposed to act like the others
   */
  def getInt: Int = -1

  /** Method that makes a copy of the game entity
   *
   * @return a new instance of a norma level 6
   */
  def cloneEntity: Norma = new NormaLevel6
}
