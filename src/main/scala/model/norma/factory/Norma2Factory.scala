package cl.uchile.dcc.citric
package model.norma.factory

import model.norma.{Norma, NormaLevel2}

/** Trait that represents a factory of a norma level 2
 *
 *
 * for instance, this norma factory should be able to:
 * - create new normas level 2
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
object Norma2Factory extends NormaFactory{
  /** Method that creates a new norma level 2
   *
   * @return a norma level 2
   */
  def apply(): Norma = new NormaLevel2
}
