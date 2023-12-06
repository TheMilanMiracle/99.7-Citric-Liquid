package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the new chapter game state
 *
 * when having this state, the controller will increase the chapter counter and
 * start the turn loop for the players
 *
 * this class overrides the next transitions:
 * -newChapter (NewChapterState -> TurnLoopState)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NewChapterState extends AbstractGameState {
  /** transitions the game state from the new chapter state to the turn loop state
   *
   * @param c controller context of the state */
  override def newChapter(c: GameController): Unit = {
    c.gameState = new TurnLoopState
  }

  /** Method that defines how a Game Unit prints itself */
  override def toString: String = "New Chapter State"
}
