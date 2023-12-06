package cl.uchile.dcc.citric
package model.units.player

import cl.uchile.dcc.citric.controller.Observer

/** Trait that represent an observable entity
 *
 *
 * a subject should be able to:
 * - add an observer
 * - notify the observers
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait Subject[T] {
  /** Method that adds a new observer */
  def addObserver(o: Observer[T]): Unit

  /** Method that notifies all of the observers */
  def notifyObservers(): Unit

}
