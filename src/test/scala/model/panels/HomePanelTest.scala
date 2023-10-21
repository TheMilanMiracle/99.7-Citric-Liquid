package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class HomePanelTest extends munit.FunSuite{
  val p1: Int = 1
  var homePanel1 = new HomePanel(p1)
  val p2: Int = 2
  var homePanel2 = new HomePanel(p2)
  var testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  var testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)


  override def beforeEach(context: BeforeEach): Unit = {
    val p1: Int = 1
    homePanel1 = new HomePanel(p1)
    val p2: Int = 2
    homePanel2 = new HomePanel(p2)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined and their getters work correctly") {
    assertEquals(homePanel1.characters, ArrayBuffer[PlayerCharacter]())
    assertEquals(homePanel1.nextPanels, ArrayBuffer[Panel]())
    assertEquals(homePanel1.position, p1)
  }

  test("any kind of panel should be able to have one or more players in it") {
    homePanel1.addCharacter(testPlayer1)
    assertNotEquals(homePanel1.characters, ArrayBuffer[PlayerCharacter]())
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
    assertEquals(homePanel1.characters, ArrayBuffer[PlayerCharacter]())
  }

  test("any kind of panel should be able to add and remove panels from their next panels list") {
    val panel1 = new HomePanel(3)
    val panel2 = new HomePanel(4)

    homePanel1.addPanel(panel1)
    assertEquals(homePanel1.nextPanels, ArrayBuffer[Panel](panel1))
    homePanel1.removePanel(panel1)
    assertEquals(homePanel1.nextPanels, ArrayBuffer[Panel]())
    homePanel1.addPanel(panel1)
    homePanel1.addPanel(panel2)
    assertEquals(homePanel1.nextPanels, ArrayBuffer[Panel](panel1, panel2))
  }

  test("a home panel can upgrade a player's norma level if the requirements are met"){
    testPlayer1.stars = (12)
    testPlayer1.objective_=("stars")
    homePanel1.addCharacter(testPlayer1)
    homePanel1.apply()
    assertEquals(testPlayer1.norma.getInt, 2)
    homePanel1.apply()
    assertEquals(testPlayer1.norma.getInt, 2)
    testPlayer1.objective_=("victories")
    testPlayer2.increaseVictoriesTo(testPlayer1)
    testPlayer2.increaseVictoriesTo(testPlayer1)
    homePanel1.apply()
    assertEquals(testPlayer1.norma.getInt, 3)
    homePanel1.apply()
    assertEquals(testPlayer1.norma.getInt, 3)
  }

  test("a home panel heals one hp to a character after triggering its effect"){
    testPlayer1 = new PlayerCharacter("test player1", 10, 1, 1, 1, 1)
    homePanel1.addCharacter(testPlayer1)
    homePanel1.apply()
    assertEquals(testPlayer1.currentHP, 10)
    testPlayer1.currentHP = (testPlayer1.currentHP  -5)
    homePanel1.apply()
    assertEquals(testPlayer1.currentHP, 6)
    homePanel1.apply()
    assertEquals(testPlayer1.currentHP, 7)
    homePanel1.apply()
    assertEquals(testPlayer1.currentHP, 8)
    homePanel1.apply()
    assertEquals(testPlayer1.currentHP, 9)
    homePanel1.apply()
    assertEquals(testPlayer1.currentHP, 10)
    homePanel1.apply()
    assertEquals(testPlayer1.currentHP, 10)
  }
}
