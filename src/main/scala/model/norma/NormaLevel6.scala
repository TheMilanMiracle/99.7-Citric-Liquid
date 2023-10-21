package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the level of "Norma" 6
 *
 * This is the level comes after level 5 and is the final level, meaning that if a
 * player has it, he won the game. Therefore this norma level is the only one that will
 * never norma checked
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel6 extends abstractNorma(-1, -1, new NormaWon){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 6
   */
  def getInt: Int = 6
}
