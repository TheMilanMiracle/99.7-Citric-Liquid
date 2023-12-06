package cl.uchile.dcc.citric
package model.norma

import model.norma.factory.Norma5Factory

/** A Class that represents the level of "Norma" 4
 *
 * This is the level comes after level 3
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel4 extends AbstractNorma(120, 10, Some(Norma5Factory)){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 4
   */
  def getInt: Int = 4
}