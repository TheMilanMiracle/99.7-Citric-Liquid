package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class HomePanelTest extends munit.FunSuite{
  val homePanelPlayer1 = new HomePanel(ArrayBuffer[Panel]())
  val homePanelPlayer2 = new HomePanel(ArrayBuffer[Panel]())
  homePanelPlayer1.position = 1
  homePanelPlayer2.position = 2
  val testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1)
  val testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1)
  testPlayer1.homePanel = 1
  testPlayer2.homePanel = 2

  override def beforeEach(context: BeforeEach): Unit = {
    val homePanelPlayer1 = new HomePanel(ArrayBuffer[Panel]())
    val homePanelPlayer2 = new HomePanel(ArrayBuffer[Panel]())
    homePanelPlayer1.position = 1
    homePanelPlayer2.position = 2
    val testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1)
    val testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1)
    testPlayer1.homePanel = 1
    testPlayer2.homePanel = 2
  }

  test("each player has its own home panel") {
    assertEquals(homePanelPlayer1.position, testPlayer1.homePanel)
    assertEquals(homePanelPlayer2.position, testPlayer2.homePanel)
  }

  test("a home panel can upgrade a player's norma level if the requirements are met"){
    testPlayer1.stars = 12
    homePanelPlayer1.addCharacter(testPlayer1)
    homePanelPlayer1.triggerEffect()
    assertEquals(testPlayer1.norma, 2)
    testPlayer1.victories = 4
    homePanelPlayer1.triggerEffect()
    assertEquals(testPlayer1.norma, 3)
    homePanelPlayer1.triggerEffect()
    assertEquals(testPlayer1.norma, 3)

    homePanelPlayer2.addCharacter(testPlayer2)
    homePanelPlayer2.triggerEffect()
    assertEquals(testPlayer2.norma, 1)
    testPlayer2.stars = 9
    homePanelPlayer2.triggerEffect()
    assertEquals(testPlayer2.norma, 1)
  }
}
