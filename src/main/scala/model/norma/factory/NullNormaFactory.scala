package cl.uchile.dcc.citric
package model.norma.factory

import model.norma.{Norma, NullNorma}

/** Trait that represents a factory of null normas
 *
 *
 * for instance, this norma factory should be able to:
 * - create new null normas
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
object NullNormaFactory extends NormaFactory {
  /** Method that creates a new null norma
   *
   * @return a null norma
   */
  def apply(): Norma = new NullNorma
}
