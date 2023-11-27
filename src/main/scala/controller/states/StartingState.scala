package cl.uchile.dcc.citric
package controller.states

import exceptions.WrongStateTransitionException

import cl.uchile.dcc.citric.controller.GameController

/** class that represents the starting state of the game
 *
 * when having this state, the controller will set up all initial values
 * necessary for a game, then transition to the 'NewChapterState' state
 *
 * this class overrides the next transition:
 * -resetController (StartingState -> NewChapterState)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class StartingState extends abstractGameState {
  /** transitions the game state from the starting one to the new chapter state
   *
   * @param c controller context of the state */
  override def resetController(c: GameController): Unit = {
    c.gameState = new NewChapterState
  }

}
