package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.norma.NormaLevel3

import scala.collection.mutable.ArrayBuffer

class BonusPanelTest extends munit.FunSuite{
  val p: Int = 1
  var bonusPanel = new BonusPanel(p)
  var testPlayer1 = new PlayerCharacter("test player1",1, 1, 1, 1, 1)
  var testPlayer2 = new PlayerCharacter("test player2",1, 1, 1, 1, 2)

  override def beforeEach(context: BeforeEach): Unit = {
    val p: Int = 1
    bonusPanel = new BonusPanel(p)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined and their getters work correctly") {
    assertEquals(bonusPanel.characters, ArrayBuffer[PlayerCharacter]())
    assertEquals(bonusPanel.nextPanels, ArrayBuffer[Panel]())
    assertEquals(bonusPanel.position, p)
  }

  test("any kind of panel should be able to have one or more players in it") {
    bonusPanel.addCharacter(testPlayer1)
    assertNotEquals(bonusPanel.characters, ArrayBuffer[PlayerCharacter]())
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
    assertEquals(bonusPanel.characters, ArrayBuffer[PlayerCharacter]())
  }

  test("any kind of panel should be able to add and remove panels from their next panels list"){
    val panel1 = new BonusPanel(2)
    val panel2 = new BonusPanel(3)

    bonusPanel.addPanel(panel1)
    assertEquals(bonusPanel.nextPanels, ArrayBuffer[Panel](panel1))
    bonusPanel.removePanel(panel1)
    assertEquals(bonusPanel.nextPanels, ArrayBuffer[Panel]())
    bonusPanel.addPanel(panel1)
    bonusPanel.addPanel(panel2)
    assertEquals(bonusPanel.nextPanels, ArrayBuffer[Panel](panel1,panel2))
  }

  test("the bonus panel will give to a player a quantity of stars depending on his norma and roll of the dice"){
    bonusPanel.addCharacter(testPlayer1)
    bonusPanel.apply()

    assert(0 < testPlayer1.stars)
    assert(testPlayer1.stars <= 6 * testPlayer1.norma.getInt || testPlayer1.stars <= 6 * 3)

    var ref: Int = testPlayer1.stars
    bonusPanel.apply()

    assert(ref < testPlayer1.stars)
    assert(testPlayer1.stars <= ((6 * testPlayer1.norma.getInt) + ref) || testPlayer1.stars <= ((6 * 3) + ref))

    ref = testPlayer1.stars
    testPlayer1.norma_=(new NormaLevel3)
    bonusPanel.apply()

    assert(ref < testPlayer1.stars)
    assert(testPlayer1.stars <= ((6 * testPlayer1.norma.getInt) + ref) || testPlayer1.stars <= ((6 * 3) + ref))
  }

}
