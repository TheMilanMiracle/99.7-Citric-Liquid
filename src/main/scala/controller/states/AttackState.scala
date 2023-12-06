package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the attack state
 *
 * this state represent the first part of a combat turns
 * when a unit starts to attack it transitions the game state
 * to the response state when the receiver unit decides what to
 * do about the attack
 *
 * this calls overrides the next transitions:
 * - unitAttacks (attack state to response state)
 * - combatEnds (attack state to turn loop state)
 * - receiverNotKO (remains in attack state)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class AttackState extends AbstractGameState {
  /** transitions the game state from the attack state to the response state
   *
   * @param c controller context of the state
   */
  override def unitAttacks(c: GameController): Unit = {
    c.gameState = new ResponseState
  }

  /** transitions the game state from the attack state to the turn loop state
   *
   * @param c controller context of the state
   */
  override def combatEnds(c: GameController): Unit = {
    c.gameState = new TurnLoopState
  }

  /** transitions the game state from the attack state to itself
   *
   * @param c controller context of the state
   */
  override def receiverNotKO(c: GameController): Unit = {}

  /** Method that defines how a Game Unit prints itself
   *
   * @return a string representing the class
   */
  override def toString: String = "Attack State"
}
