package cl.uchile.dcc.citric
package model.norma.factory

import model.norma.{Norma, NormaLevel5}

/** Trait that represents a factory of a norma level 5
 *
 *
 * for instance, this norma factory should be able to:
 * - create new normas level 5
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
object Norma5Factory extends NormaFactory {
  /** Method that creates a new norma level 5
   *
   * @return a norma level 5
   */
  def apply(): Norma = new NormaLevel5
}
