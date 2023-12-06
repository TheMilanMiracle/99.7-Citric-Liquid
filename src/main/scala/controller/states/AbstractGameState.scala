package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException

/** abstract class that implements all the transitions between states
 *
 * by default all the transitions will throw a WrongStateTransitionException and
 * this behaviour will be common between all states, the actual
 * transitions are meant to be defined at the state classes itself
 *
 * for instance, the transitions that are defined are:
 * -resetController
 * -newChapter
 * -chapterEnds
 * -playerKO
 * -diceMiss
 * -diceHit
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class AbstractGameState extends GameState {
  /** transitions the game state from the starting one to the new chapter state
   *
   * @param c controller context of the state
   * @throws WrongStateTransitionException exception for a tried wrong state transition*/
  def startGame(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the new chapter state to the turn loop state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state */
  def newChapter(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the turn loop state to the new chapter state to
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state */
  def chapterEnds(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the turn loop state to the recovery state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def playerKO(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transition the game state from the recovery state to the turn loop state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def diceMiss(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transition the game state from the recovery state to the stars and dice state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def diceHit(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transition the game state from the turn loop state to the stars and dice state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def playerNotKO(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transition the game state from the stars and dice state to the moving player state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def startMovement(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transition the game state from the moving player state to itself
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def keepsMoving(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from moving player state to panel effect state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def playerStops(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from moving player state to panel effect state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def playerHomePanel(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transition the game state from the panel effect state to the turn loop state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   * */
  def noCombat(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transition the game state from the turn loop state to the game ends state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def playerWins(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the panel effect state to the attack state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def combat(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the attack state to the response state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def unitAttacks(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the response state to the attack state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def unitEvades(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the response state to the attack state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def unitDefends(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the attack state to the turn loop state
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def combatEnds(c: GameController): Unit = {throw new WrongStateTransitionException}

  /** transitions the game state from the attack state to itself
   *
   * @throws WrongStateTransitionException exception for a tried wrong state transition
   * @param c controller context of the state
   */
  def receiverNotKO(c: GameController): Unit = {throw new WrongStateTransitionException}
}
