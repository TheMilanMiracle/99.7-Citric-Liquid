package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the panel effect state
 *
 * when this state is reached, the controller will trigger
 * the effect of the landed panel,
 * to then transition to the combat states if required
 * or go back to the turn loop state
 *
 * this class overrides the next transitions:
 * - noCombat (PanelEffectState -> TurnLoopState)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class PanelEffectState extends AbstractGameState {
  /** transition the game state from the panel effect state to the turn loop state
   *
   * @param c controller context of the state
   * */
  override def noCombat(c: GameController): Unit = {
    c.gameState = new TurnLoopState
  }

  /** transitions the game state from the panel effect state to the attack state
   *
   * @param c controller context of the state
   */
  override def combat(c: GameController): Unit = {
    c.gameState = new AttackState
  }

  /** Method that defines how a Game Unit prints itself */
  override def toString: String = "Panel Effect State"

}
