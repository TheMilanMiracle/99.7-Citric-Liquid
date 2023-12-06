package cl.uchile.dcc.citric
package model.norma.factory

import model.norma.{Norma, NormaLevel1}

/** Trait that represents a factory of a norma level 1
 *
 *
 * for instance, this norma factory should be able to:
 * - create new normas level 1
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
object Norma1Factory extends NormaFactory {
  /** Method that creates a new norma level 1 */
  def apply(): Norma = new NormaLevel1
}
