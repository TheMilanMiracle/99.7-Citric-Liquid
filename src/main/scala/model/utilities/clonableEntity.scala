package cl.uchile.dcc.citric
package model.utilities

/** Interface that represent any kind of game entity that should
 * be able to copy itself
 *
 * The usefulness of this interface is evident when we define getters of an instance of an
 * object with attributes, because if we don't return a copy, we return the whole object. Meaning that its attributes
 * would be directly changeable, making the fact of them being private meaningless
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait clonableEntity[T] {
  /** Method that makes a copy of the game entity
   *
   * @return a copy of the instance of the object
   */
  def cloneEntity: T
}
