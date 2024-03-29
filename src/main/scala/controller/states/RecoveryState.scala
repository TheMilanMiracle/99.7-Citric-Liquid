package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the recovery game state
 *
 * this state is reached when the current player playing
 * is KO, meaning, its HP are 0 and to get out of recovery
 * the player has to roll a dice
 * if the dice meets the needed roll the controller transitions
 * to the StarsAndDiceState
 * if the dice doesnt meets the needed roll the controller goes back to
 * the TurnLoopState with the next player
 *
 * this class overrides the next transitions:
 * - diceMiss (recovery state to turn loop state)
 * - diceHit (recovery state to stars and dice state)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class RecoveryState extends AbstractGameState {
  /** transition the game state from the recovery state to the turn loop state
   *
   * @param c controller context of the state
   */
  override def diceMiss(c: GameController): Unit = {
    c.gameState = new TurnLoopState
  }

  /** transition the game state from the recovery state to the stars and dice state
   *
   * @param c controller context of the state
   */
  override def diceHit(c: GameController): Unit = {
    c.gameState = new StarsAndDiceState
  }

  /** Method that defines how a Game Unit prints itself
   *
   * @return a string representing the class
   */
  override def toString: String = "Recovery State"
}
