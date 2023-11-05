package cl.uchile.dcc.citric
package exceptions

/**
 * Custom exception to signal an invalid unit name encountered
 *
 * This exception is designed to provide more specific feedback about
 * invalid unit name
 *
 * @example To throw the exception with specific details:
 * {{{
 * throw new InvalidNameException("Unit's name cannot be too shorter that 1")
 * // => InvalidNameException: An invalid game unit name was found -- Unit's name cannot be too shorter that 1
 * }}}
 * @param details A descriptive message detailing the nature of the invalid name.
 *
 *
 * @author [[https://github.com/TheMilanMiracle/ Luciano Márquez C.]]
 */
class InvalidUnitNameException(details: String) extends Exception(s"An invalid game unit name was found -- $details")
