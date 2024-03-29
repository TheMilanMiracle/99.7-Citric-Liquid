package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** class that represents the turn loop state
 *
 * when having this state, the controller will check which player
 * is playing (1st, 2nd, 3rd, 4th)
 * it will make the controller transition to the NewChapterState if the 4th
 * player just ended its turn
 * otherwise it will make the controller transition to the Recovery or
 * StarsAndDice state depending on the current player HP
 *
 * this class overrides the next transitions:
 * -chapterEnds (turn loop state to new chapter state)
 * -playerKO (turn loop state to recovery state)
 * -playerNotKO (turn loop state to stars and dice state)
 * -playerWinds (turn loop state to game ends state)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class TurnLoopState extends AbstractGameState {
  /** transitions the game state from the turn loop state to the new chapter state to
   *
   * @param c controller context of the state */
  override def chapterEnds(c: GameController): Unit = {
    c.gameState = new NewChapterState
  }

  /** transitions the game state from the turn loop state to the recovery state
   *
   * @param c controller context of the state
   */
  override def playerKO(c: GameController): Unit = {
    c.gameState = new RecoveryState
  }

  /** transition the game state from the turn loop state to the stars and dice state
   *
   * @param c controller context of the state
   */
  override def playerNotKO(c: GameController): Unit = {
    c.gameState = new StarsAndDiceState
  }

  /** transition the game state from the turn loop state to the game ends state
   *
   * @param c controller context of the state
   */
  override def playerWins(c: GameController): Unit = {
    c.gameState = new GameEndsState
  }

  /** Method that defines how a Game Unit prints itself
   *
   * @return a string representing the class
   */
  override def toString: String = "Turn Loop State"
}
