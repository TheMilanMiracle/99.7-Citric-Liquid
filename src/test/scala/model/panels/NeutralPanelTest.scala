package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class NeutralPanelTest extends munit.FunSuite{
  val np: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  val c: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  val p: Int = 1
  var neutralPanel = new NeutralPanel(np, p)
  var testPlayer1: PlayerCharacter = new PlayerCharacter("test player1",1 ,1,1, 1, 1)
  var testPlayer2: PlayerCharacter = new PlayerCharacter("test player2",1 ,1,1, 1, 2)

  override def beforeEach(context: BeforeEach): Unit = {
    val np: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val c: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
    val p: Int = 1
    neutralPanel = new NeutralPanel(np, p)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined"){
    assertEquals(neutralPanel.characters, c)
    assertEquals(neutralPanel.nextPanels, np)
    assertEquals(neutralPanel.position, p)
  }

  test("any kind of panel should be able to have one or more players in it"){
    neutralPanel.addCharacter(testPlayer1)
    assertNotEquals(neutralPanel.characters, c)
    assertEquals(neutralPanel.characters.size, 1)
    assertEquals(neutralPanel.characters(0),testPlayer1)
    neutralPanel.removeCharacter(testPlayer2)
    assertEquals(neutralPanel.characters.size, 1)
    assertEquals(neutralPanel.characters(0), testPlayer1)
    neutralPanel.addCharacter(testPlayer2)
    assertEquals(neutralPanel.characters.size, 2)
    assertEquals(neutralPanel.characters(0), testPlayer1)
    assertEquals(neutralPanel.characters(1), testPlayer2)
    neutralPanel.removeCharacter(testPlayer1)
    assertEquals(neutralPanel.characters.size, 1)
    assertEquals(neutralPanel.characters(0), testPlayer2)
    neutralPanel.removeCharacter(testPlayer2)
    assertEquals(neutralPanel.characters.size, 0)
    assertEquals(neutralPanel.characters, c)

  }

  test("the neutral kind of panel shouldn't have any effect on the player landing on it"){
    val starsBefore1 = testPlayer1.getStars
    val starsBefore2 = testPlayer2.getStars

    neutralPanel.addCharacter(testPlayer1)
    neutralPanel.triggerEffect()
    neutralPanel.addCharacter(testPlayer2)
    neutralPanel.triggerEffect()
    assertEquals(testPlayer1.getStars, starsBefore1)
    assertEquals(testPlayer2.getStars, starsBefore2)
  }
}
