package cl.uchile.dcc.citric
package model.norma.factory

import model.norma.Norma

/** Trait that represents a factory of a norma type
 *
 *
 * for instance, a norma factory should be able to:
 * - create new normas
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 *
 */
trait NormaFactory {
  /** Method that creates a new norma
   *
   * @return the specific norma level of this factory
   */
  def apply(): Norma
}
