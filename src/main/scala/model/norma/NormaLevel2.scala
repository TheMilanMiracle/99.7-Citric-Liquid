package cl.uchile.dcc.citric
package model.norma

import model.norma.factory.Norma3Factory

/** A Class that represents the level of "Norma" 2
 *
 * This is the level comes after level 1
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel2 extends AbstractNorma(30, 3, Some(Norma3Factory)){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 2
   */
  def getInt: Int = 2
}
