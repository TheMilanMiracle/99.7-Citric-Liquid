package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the stars and dice state
 *
 * when in this state, the player will receive a predefined
 * amount of stars and will roll the dice transitioning to
 * the moving player state
 *
 * this class overrides the next transition:
 * -startMovement (StarsAndDiceState -> MovingPlayerState)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class StarsAndDiceState extends AbstractGameState {
  /** transition the game state from the stars and dice state to the moving player state
   *
   * @param c controller context of the state
   */
  override def startMovement(c: GameController): Unit = {
    c.gameState = new MovingPlayerState
  }

  /** Method that defines how a Game Unit prints itself */
  override def toString: String = "Stars & Dice State"
}
