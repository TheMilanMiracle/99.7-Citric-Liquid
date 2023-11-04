package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the level of "Norma" 4
 *
 * This is the level comes after level 3
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel4 extends abstractNorma(120, 10, Some(new NormaLevel5)){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 4
   */
  def getInt: Int = 4

  /** Method that makes a copy of the game entity
   *
   * @return a new instance of a norma level 4
   */
  def cloneEntity: Norma = new NormaLevel4
}