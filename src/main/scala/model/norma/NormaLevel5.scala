package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the level of "Norma" 5
 *
 * This is the level comes after level 4
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel5 extends abstractNorma(200, 14, Some(new NormaLevel6)){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 5
   */
  def getInt: Int = 5

  /** Method that makes a copy of the game entity
   *
   * @return a new instance of a norma level 5
   */
  def cloneEntity: Norma = new NormaLevel5
}