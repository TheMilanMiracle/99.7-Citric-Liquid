package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the level of "Norma" 4
 *
 * This is the level comes after level 3
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel4 extends abstractNorma(120, 10, new NormaLevel5){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 4
   */
  def getInt: Int = 4
}