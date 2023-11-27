package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the attack state
 *
 * this state represent the second part of a combat
 * turn, when reached, a unit can choose to defend or to
 * try to evade an attack, then the controller transitions to the
 * attackState again
 * this calls overrides the next transitions:
 * -
 * -
 * -
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class ResponseState extends abstractGameState {
  /** transitions the game state from the response state to the attack state
   *
   * @param c controller context of the state
   */
  override def unitEvades(c: GameController): Unit = {
    c.gameState = new AttackState
  }

  /** transitions the game state from the response state to the attack state
   *
   * @param c controller context of the state
   */
  override def unitDefends(c: GameController): Unit = {
    c.gameState = new AttackState
  }
}
