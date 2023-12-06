package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the starting state of the game
 *
 * when having this state, the controller will set up all initial values
 * necessary for a game, then transition to the 'NewChapterState' state
 *
 * this class overrides the next transition:
 * -startGame (starting state to new chapter state)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class StartingState extends AbstractGameState {
  /** transitions the game state from the starting one to the new chapter state
   *
   * @param c controller context of the state */
  override def startGame(c: GameController): Unit = {
    c.gameState = new NewChapterState
  }

  /** Method that defines how a Game Unit prints itself
   *
   * @return a string representing the class
   */
  override def toString: String = "Starting State"

}
