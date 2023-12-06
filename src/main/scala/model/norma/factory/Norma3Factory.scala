package cl.uchile.dcc.citric
package model.norma.factory

import model.norma.{Norma, NormaLevel3}

/** Trait that represents a factory of a norma level 3
 *
 *
 * for instance, this norma factory should be able to:
 * - create new normas level 3
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
object Norma3Factory extends NormaFactory {
  /** Method that creates a new norma level 3 */
  def apply(): Norma = new NormaLevel3
}
