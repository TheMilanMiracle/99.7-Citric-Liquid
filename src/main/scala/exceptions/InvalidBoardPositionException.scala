package cl.uchile.dcc.citric
package exceptions

/**
 * Custom exception to signal an invalid board position encountered
 *
 * This exception is designed to provide more specific feedback about
 * invalid board position
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new InvalidBoardPositionException("The board cannot have negative positions")
 * // => InvalidBoardPositionException: An invalid board position was found -- The board cannot have negative positions
 * }}}
 *
 * @param details A descriptive message detailing the nature of the invalid position
 *
 *
 * @author [[https://github.com/TheMilanMiracle/ Luciano Márquez C.]]
 */
class InvalidBoardPositionException(details: String) extends Exception(s"An invalid board position was found -- $details")
