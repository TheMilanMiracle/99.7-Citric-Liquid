package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class HomePanelTest extends munit.FunSuite{
  val np1: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  val c1: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  val p1: Int = 1
  var homePanel1 = new HomePanel(np1, p1)
  val np2: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  val c2: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  val p2: Int = 2
  var homePanel2 = new HomePanel(np2, p2)
  var testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  var testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)


  override def beforeEach(context: BeforeEach): Unit = {
    val np1: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val c1: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
    val p1: Int = 1
    homePanel1 = new HomePanel(np1, p1)
    val np2: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val c2: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
    val p2: Int = 2
    homePanel2 = new HomePanel(np2, p2)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined") {
    assertEquals(homePanel1.characters, c1)
    assertEquals(homePanel1.nextPanels, np1)
    assertEquals(homePanel1.position, p1)
  }

  test("any kind of panel should be able to have one or more players in it") {
    homePanel1.addCharacter(testPlayer1)
    assertNotEquals(homePanel1.characters, c1)
    assertEquals(homePanel1.characters.size, 1)
    assertEquals(homePanel1.characters(0), testPlayer1)
    homePanel1.removeCharacter(testPlayer2)
    assertEquals(homePanel1.characters.size, 1)
    assertEquals(homePanel1.characters(0), testPlayer1)
    homePanel1.addCharacter(testPlayer2)
    assertEquals(homePanel1.characters.size, 2)
    assertEquals(homePanel1.characters(0), testPlayer1)
    assertEquals(homePanel1.characters(1), testPlayer2)
    homePanel1.removeCharacter(testPlayer1)
    assertEquals(homePanel1.characters.size, 1)
    assertEquals(homePanel1.characters(0), testPlayer2)
    homePanel1.removeCharacter(testPlayer2)
    assertEquals(homePanel1.characters.size, 0)
    assertEquals(homePanel1.characters, c1)
  }

  test("a home panel can upgrade a player's norma level if the requirements are met"){

  }
}
