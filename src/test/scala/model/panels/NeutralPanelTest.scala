package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class NeutralPanelTest extends munit.FunSuite{
  val neutralPanel = new NeutralPanel(ArrayBuffer[Panel]())
  val testPlayer1: PlayerCharacter = new PlayerCharacter("test player1",1 ,1,1, 1)
  val testPlayer2: PlayerCharacter = new PlayerCharacter("test player2",1 ,1,1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    val neutralPanel = new NeutralPanel(ArrayBuffer[Panel]())
    val testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1)
    val testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1)
  }
  test("the neutral kind of panel doesnt have any effect on the player landing on it"){
    val testPlayerBefore1 = testPlayer1
    val testPlayerBefore2 = testPlayer2

    neutralPanel.addCharacter(testPlayer1)
    neutralPanel.triggerEffect()
    neutralPanel.addCharacter(testPlayer2)
    assertEquals(testPlayer1, testPlayerBefore1)
    assertEquals(testPlayer2, testPlayerBefore2)
  }
}
