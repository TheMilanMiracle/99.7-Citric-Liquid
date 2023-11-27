package cl.uchile.dcc.citric
package controller.states

import controller.GameController

/** Interface that represent a game state
 *
 * The game has multiple states and the controller will act
 * differently on each one
 *
 *
 * this interface shows all the transitions that a state 'can' do
 * which means that it not necessarily will correctly transition
 * states
 *
 * for instance, an game state can:
 * - call resetController (StartingState -> NewChapterState)
 * - call newChapter (NewChapterState -> TurnLoopState)
 * - call chapterEnds (TurnLoopState -> NewChapterState)
 * - call playerKO (TurnLoopState -> RecoveryState)
 * - call diceMiss (RecoveryState -> TurnLoopState)
 * - call diceHit (RecoveryState -> StarsAndDiceState)
 * - call playerNotKO (TurnLoopState -> StarsAndDiceState)
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
trait GameState {
  /** transitions the game state from the starting one to the new chapter state
   *
   * @param c controller context of the state*/
  def resetController(c: GameController): Unit

  /** transitions the game state from the new chapter state to the turn loop state
   *
   * @param c controller context of the state */
  def newChapter(c: GameController): Unit

  /** transitions the game state from the turn loop state to the new chapter state to
   *
   * @param c controller context of the state */
  def chapterEnds(c: GameController): Unit

  /** transitions the game state from the turn loop state to the recovery state
   *
   * @param c controller context of the state
   */
  def playerKO(c: GameController): Unit

  /** transition the game state from the recovery state to the turn loop state
   *
   * @param c controller context of the state
   */
  def diceMiss(c: GameController): Unit

  /** transition the game state from the recovery state to the stars and dice state
   *
   * @param c controller context of the state
   */
  def diceHit(c: GameController): Unit

  /** transition the game state from the turn loop state to the stars and dice state
   *
   * @param c controller context of the state
   */
  def playerNotKO(c: GameController): Unit

  /** transition the game state from the stars and dice state to the moving player state
   *
   * @param c controller context of the state
   */
  def startMovement(c: GameController): Unit

  /** transition the game state from the moving player state to itself
   *
   * @param c controller context of the state
   */
  def keepsMoving(c: GameController): Unit

  /** transitions the game state from moving player state to panel effect state
   *
   * @param c controller context of the state
   */
  def playerStops(c: GameController): Unit

  /** transitions the game state from moving player state to panel effect state
   *
   * @param c controller context of the state
   */
  def playerHomePanel(c: GameController): Unit

  /** transition the game state from the panel effect state to the turn loop state
   *
   * @param c controller context of the state
   * */
  def noCombat(c: GameController): Unit

  /** transition the game state from the turn loop state to the game ends state
   *
   * @param c controller context of the state
   */
  def playerWins(c: GameController): Unit

  /** transitions the game state from the panel effect state to the attack state
   *
   * @param c controller context of the state
   */
  def combat(c: GameController): Unit

  /** transitions the game state from the attack state to the response state
   *
   * @param c controller context of the state
   */
  def unitAttacks(c: GameController): Unit

  /** transitions the game state from the response state to the attack state
   *
   * @param c controller context of the state
   */
  def unitEvades(c: GameController): Unit

  /** transitions the game state from the response state to the attack state
   *
   * @param c controller context of the state
   */
  def unitDefends(c: GameController): Unit

  /** transitions the game state from the attack state to the turn loop state
   *
   * @param c controller context of the state
   */
  def combatEnds(c: GameController): Unit

  /** transitions the game state from the attack state to itself
   *
   * @param c controller context of the state
   */
  def receiverNotKO(c: GameController): Unit


}
