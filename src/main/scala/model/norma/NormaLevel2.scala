package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the level of "Norma" 2
 *
 * This is the level comes after level 1
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel2 extends abstractNorma(30, 3, Some(new NormaLevel3)){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 2
   */
  def getInt: Int = 2

  /** Method that makes a copy of the game entity
   *
   * @return a new instance of a norma level 2
   */
  def cloneEntity: Norma = new NormaLevel2
}
