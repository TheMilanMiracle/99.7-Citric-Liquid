package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class HomePanelTest extends munit.FunSuite{
  val np1: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  val c1: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  val p1: Int = 1
  val homePanel1 = new HomePanel(np1, p1)
  val np2: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  val c2: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  val p2: Int = 2
  val homePanel2 = new HomePanel(np2, p2)
  val testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  val testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)


  override def beforeEach(context: BeforeEach): Unit = {
    val np1: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val c1: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
    val p1: Int = 1
    val homePanel1 = new HomePanel(np1, p1)
    val np2: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val c2: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
    val p2: Int = 2
    val homePanel2 = new HomePanel(np2, p2)
    val testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    val testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
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
    testPlayer1.stars = 12
    homePanel1.addCharacter(testPlayer1)
    homePanel1.triggerEffect()
    assertEquals(testPlayer1.norma, 2)
    testPlayer1.victories = 4
    homePanel1.triggerEffect()
    assertEquals(testPlayer1.norma, 3)
    homePanel1.triggerEffect()
    assertEquals(testPlayer1.norma, 3)

    homePanel2.addCharacter(testPlayer2)
    homePanel2.triggerEffect()
    assertEquals(testPlayer2.norma, 1)
    testPlayer2.stars = 9
    homePanel2.triggerEffect()
    assertEquals(testPlayer2.norma, 1)
  }
}
