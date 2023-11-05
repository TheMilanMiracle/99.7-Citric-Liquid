package cl.uchile.dcc.citric
package exceptions

/** The `Require` object provides utilities for validating specific constraints or requirements.
 *
 * This object includes the `Stat` class, designed to validate a statistic's value against
 * constraints like a specified range or a minimum threshold.
 *
 * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
 * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
 * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
 * @author [[https://github.com/Seivier/ Vicente González B.]]
 * @author [[https://github.com/TheMilanMiracle/ Luciano Márquez C.]]
 */
object Require {

  /**
   * Represents and validates a game statistic with an associated name.
   *
   * This class facilitates the validation of a statistic's value against specified constraints.
   * An [[InvalidStatException]] is thrown if the validation fails.
   *
   *
   * @param value The numeric value of the statistic.
   * @param name The identifier or label for the statistic, primarily used in error messages.
   */
  final case class Stat(value: Int, name: String) {

    /**
     * Validates if the statistic's value lies within a provided range.
     *
     * @example
     * {{{
     *   val health = Require.Stat(100, "health") in (0 to 100)
     *   // => health: Int = 100
     * }}}
     * @example
     * {{{
     *   val health = Require.Stat(200, "health") in (0 to 100)
     *   // => throws InvalidStatException
     * }}}
     *
     * @param range The permissible range for the statistic's value.
     * @return The statistic's value if within the range.
     * @throws InvalidStatException for values outside the range.
     */
    def in(range: Range): Int =
      if (range contains value) value
      else throw new InvalidStatException(s"$name should be in $range but was $value")

    /**
     * Validates if the statistic's value is greater than or equal to a specified limit.
     *
     * @example
     * {{{
     *   val health = Require.Stat(100, "health") atLeast 0
     *   // => health: Int = 100
     * }}}
     * @example
     * {{{
     *   val health = Require.Stat(-10, "health") atLeast 0
     *   // => throws InvalidStatException
     * }}}
     *
     * @param lo The minimum accepted value for the statistic.
     * @return The statistic's value if it meets or exceeds the threshold.
     * @throws InvalidStatException for values below the threshold.
     */
    def atLeast(lo: Int): Int =
      if (value >= lo) value
      else throw new InvalidStatException(s"$name should be at least $lo but was $value")
  }

  /** Represents and validates a game unit name
   *
   * This class facilitates the validation of a game unit name against specified constraints.
   * An [[InvalidUnitNameException]] is thrown if the validation fails.
   *
   *
   * @param name the name that needs to be validated
   */
  final case class GameUnitName(name: String){
    /**
     * Validates if the unit name length is larger or equals than the minimum admitted
     *
     * @example
     * {{{
     *   val name = Require.GameUnitName("name") minLen 1
     *   // => name: "name"
     * }}}
     * @example
     * {{{
     *   val name = Require.GameUnitName("") minLen 1
     *   // => throws InvalidUnitNameException
     * }}}
     * @param min The minimum accepted value for the length of a unit name
     * @return The name, if its length is longer or equal to the max
     * @throws InvalidUnitNameException for values below the threshold.
     */
    def minLen(min: Int): String = {
      if (name.length >= min) name
      else throw new InvalidUnitNameException(s"Unit's name cannot be too shorter that $min")
    }

    /**
     * Validates if the unit name has any character that is not a letter
     *
     * @example
     * {{{
     *   val name = Require.GameUnitName("name") noSpecialChars
     *   // => name = "name"
     * }}}
     * @example
     * {{{
     *   val name = Require.GameUnitName("name_") noSpecialChars
     *   // => throws InvalidUnitNameException
     * }}}
     *
     * @return the name if it doesn't contains special characters
     * @throws InvalidUnitNameException when the name has any special character
     */
    def noSpecialChars: String = {
        var i = 0
        while(i < name.length){
          var c = name.charAt(i)
          if(!c.isLetter && c != ' '){throw new InvalidUnitNameException(s"Unit's name cannot contain special characters, only letters")}
          i+=1
        }
      name
    }
  }

  /** Represents and validates a board position
   *
   * This class facilitates the validation of a board position against specified constraints.
   * An [[InvalidBoardPositionException]] is thrown if the validation fails.
   *
   *
   * @param pos the position that needs to be validated
   */
  final case class BoardPosition(pos: Int){
    /**
     * Validates if the position is an existing one
     *
     * @example
     * {{{
     *   val position = Require.BoardPosition(1) existingPos 20
     *   // => position = 1
     * }}}
     * @example
     * {{{
     *   val position = Require.BoardPosition("50") existingPos 20
     *   // => throws InvalidBoardPositionException
     * }}}
     * @return the board position if it exist within the board
     * @throws InvalidBoardPositionException when the name has any special character
     */
    def existingPos(boardSize: Int): Int = {
      if(pos < 0){throw new InvalidBoardPositionException("There are not negatives positions in the board")}
      if(pos > boardSize){throw new InvalidBoardPositionException(s"Position out of bounds, the last position in the board is $boardSize")}
      pos
    }

  }
}
