package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class BonusPanelTest extends munit.FunSuite{
  val np: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  val c: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  val p: Int = 1
  var bonusPanel = new BonusPanel(np, p)
  var testPlayer1 = new PlayerCharacter("test player1",1, 1, 1, 1, 1)
  var testPlayer2 = new PlayerCharacter("test player2",1, 1, 1, 1, 2)

  override def beforeEach(context: BeforeEach): Unit = {
    val np: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val c: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
    val p: Int = 1
    bonusPanel = new BonusPanel(np, p)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined") {
    assertEquals(bonusPanel.characters, c)
    assertEquals(bonusPanel.nextPanels, np)
    assertEquals(bonusPanel.position, p)
  }

  test("any kind of panel should be able to have one or more players in it") {
    bonusPanel.addCharacter(testPlayer1)
    assertNotEquals(bonusPanel.characters, c)
    assertEquals(bonusPanel.characters.size, 1)
    assertEquals(bonusPanel.characters(0), testPlayer1)
    bonusPanel.removeCharacter(testPlayer2)
    assertEquals(bonusPanel.characters.size, 1)
    assertEquals(bonusPanel.characters(0), testPlayer1)
    bonusPanel.addCharacter(testPlayer2)
    assertEquals(bonusPanel.characters.size, 2)
    assertEquals(bonusPanel.characters(0), testPlayer1)
    assertEquals(bonusPanel.characters(1), testPlayer2)
    bonusPanel.removeCharacter(testPlayer1)
    assertEquals(bonusPanel.characters.size, 1)
    assertEquals(bonusPanel.characters(0), testPlayer2)
    bonusPanel.removeCharacter(testPlayer2)
    assertEquals(bonusPanel.characters.size, 0)
    assertEquals(bonusPanel.characters, c)
  }

  test("the bonus panel will give to a player a quantity of stars depending on his norma and roll of the dice"){


  }

}
