package cl.uchile.dcc.citric
package exceptions

/** Custom exception to signal an invalid game state transition
 *
 * @author [[https://github.com/TheMilanMiracle/ Luciano Márquez C.]]
 */
class WrongStateTransitionException extends Exception("Tried to do an invalid Transition"){}
