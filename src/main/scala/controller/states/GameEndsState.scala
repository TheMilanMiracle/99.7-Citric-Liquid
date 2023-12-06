package cl.uchile.dcc.citric
package controller.states

/** class that represents the ending state of a game
 *
 * when reached, it means that a player won and the game
 * ended
 *
 * this class doesnt overrides any method due to the fact that is the
 * final state of the game. It may be seen as a null State, because
 * it doesnt do anything.
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class GameEndsState extends AbstractGameState {
  /** Method that defines how a Game Unit prints itself
   *
   * @return a string representing the class
   */
  override def toString: String = "Game Ends State"
}
