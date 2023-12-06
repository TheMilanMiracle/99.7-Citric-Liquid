package cl.uchile.dcc.citric
package model.norma.factory

import model.norma.{Norma, NormaLevel4}

/** Trait that represents a factory of a norma level 4
 *
 *
 * for instance, this norma factory should be able to:
 * - create new normas level 4
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
object Norma4Factory extends NormaFactory {
  /** Method that creates a new norma level 4
   *
   * @return a norma level 4
   */
  def apply(): Norma = new NormaLevel4
}
