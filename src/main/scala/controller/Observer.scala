package cl.uchile.dcc.citric
package controller

import model.units.player.Subject

/** trait that represent an Observer entity
 *
 *
 * in the context of the game, the controller will be
 * the observer of the players. It will 'observe' them waiting
 * to get notified that one of them has won the game, when this happens
 * the controller will receive the player an declare them the winner
 *
 * an observer should be able to:
 * - update
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */

trait Observer[T] {
  /** method that updates information from the observer entity
   *
   * @param s subject that the observer is observing
   * @param p extra information about the update
   */
  def update(s: Subject[T], p: T): Unit
}
