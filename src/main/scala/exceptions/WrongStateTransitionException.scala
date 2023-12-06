package cl.uchile.dcc.citric
package exceptions

/** Custom exception to signal an invalid game state transition
 *
 * This exception is meant to be used when the game controller tries to
 * make an invalid transition, an invalid transition is an impossible jump from
 * one state to another in the game.
 *
 * @example Example of an invalid transition
 * {{{
 * controller = GameController.getInstance
 * controller.gameState = new StartingState
 * controller.gameState.playerWins(controller)
 * // => WrongStateTransitionException: "Tried to do an invalid Transition".
 * }}}
 *
 * @author [[https://github.com/TheMilanMiracle/ Luciano Márquez C.]]
 */
class WrongStateTransitionException extends Exception("Tried to do an invalid Transition"){}
