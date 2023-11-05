package cl.uchile.dcc.citric
package exceptions

class BoardPositionTest extends munit.FunSuite {
  val boardSize = 20

  test("a 'validPos' requirement return the position of a panel when is a valid one"){
    val testPosition = 7
    assertEquals(Require.BoardPosition(testPosition) existingPos(boardSize),testPosition)
  }

  test("a 'validPos' requirement throws an exception if a negative position number is found"){
    val testPosition = -7
    interceptMessage[InvalidBoardPositionException]("An invalid board position was found -- There are not negatives positions in the board"){
      Require.BoardPosition(testPosition) existingPos(boardSize)
    }
  }

  test("a 'validPos' requirement throws an exception if an out of bounds position is found"){
    val testPosition = 21
    interceptMessage[InvalidBoardPositionException](s"An invalid board position was found -- Position out of bounds, the last position in the board is $boardSize"){
      Require.BoardPosition(testPosition) existingPos(boardSize)
    }
  }
}
