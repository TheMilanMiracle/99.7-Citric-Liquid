package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the level of "Norma" 3
 *
 * This is the level comes after level 2
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel3 extends abstractNorma(70, 6, new NormaLevel4){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 3
   */
  def getInt: Int = 3
}