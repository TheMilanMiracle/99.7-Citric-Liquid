package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the moving player state
 *
 * when this is the state in the game controller, it represents
 * a player moving through the board, it can transition to itself
 * representing that it still has to move
 * or it will transition to the panel effect state if the movement ends
 *
 * this class overrides the next transitions:
 * - keepsMoving (remains in the moving player state)
 * - playerStops (moving player state to panel effect state)
 * - playerHomePanel (moving player state to panel effect state)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class MovingPlayerState extends AbstractGameState {
  /** transition the game state from the moving player state to itself
   *
   * @param c controller context of the state
   */
  override def keepsMoving(c: GameController): Unit = {}

  /** transitions the game state from moving player state to panel effect state
   *
   * @param c controller context of the state
   */
  override def playerStops(c: GameController): Unit = {
    c.gameState = new PanelEffectState
  }

  /** transitions the game state from moving player state to panel effect state
   *
   * @param c controller context of the state
   */
  override def playerHomePanel(c: GameController): Unit = {
    c.gameState = new PanelEffectState
  }

  /** Method that defines how a Game Unit prints itself
   *
   * @return a string representing the class
   */
  override def toString: String = "Moving Player State"
}
