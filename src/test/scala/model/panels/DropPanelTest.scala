package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.controller.states.PanelEffectState
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class DropPanelTest extends munit.FunSuite {
  val p: Int = 1
  var dropPanel = new DropPanel(p)
  var testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  var testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)

  override def beforeEach(context: BeforeEach): Unit = {
    val p: Int = 1
    dropPanel = new DropPanel(p)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined and their getters work correctly") {
    assertEquals(dropPanel.characters, ArrayBuffer[PlayerCharacter]())
    assertEquals(dropPanel.nextPanels, ArrayBuffer[GamePanel]())
    assertEquals(dropPanel.position, p)
  }

  test("any kind of panel should be able to have one or more players in it") {
    dropPanel.addCharacter(testPlayer1)
    assertNotEquals(dropPanel.characters, ArrayBuffer[PlayerCharacter]())
    assertEquals(dropPanel.characters.size, 1)
    assertEquals(dropPanel.characters(0), testPlayer1)
    dropPanel.removeCharacter(testPlayer2)
    assertEquals(dropPanel.characters.size, 1)
    assertEquals(dropPanel.characters(0), testPlayer1)
    dropPanel.addCharacter(testPlayer2)
    assertEquals(dropPanel.characters.size, 2)
    assertEquals(dropPanel.characters(0), testPlayer1)
    assertEquals(dropPanel.characters(1), testPlayer2)
    dropPanel.removeCharacter(testPlayer1)
    assertEquals(dropPanel.characters.size, 1)
    assertEquals(dropPanel.characters(0), testPlayer2)
    dropPanel.removeCharacter(testPlayer2)
    assertEquals(dropPanel.characters.size, 0)
    assertEquals(dropPanel.characters, ArrayBuffer[PlayerCharacter]())
  }

  test("any kind of panel should be able to add and remove panels from their next panels list") {
    val panel1 = new DropPanel(2)
    val panel2 = new DropPanel(3)

    dropPanel.addPanel(panel1)
    assertEquals(dropPanel.nextPanels, ArrayBuffer[GamePanel](panel1))
    dropPanel.removePanel(panel1)
    assertEquals(dropPanel.nextPanels, ArrayBuffer[GamePanel]())
    dropPanel.addPanel(panel1)
    dropPanel.addPanel(panel2)
    assertEquals(dropPanel.nextPanels, ArrayBuffer[GamePanel](panel1, panel2))
  }

  test("this panel will take stars from the player that trigger its effects depending of his norma and roll of the dice"){
    val context: GameController = GameController.getInstance
    context.gameState = new PanelEffectState

    testPlayer1.stars = (50)
    var ref: Int = testPlayer1.stars
    dropPanel.addCharacter(testPlayer1)
    dropPanel.apply(context)
    context.gameState = new PanelEffectState

    assert(testPlayer1.stars < ref)
    assert(testPlayer1.stars <= (ref - testPlayer1.norma.getInt))

    ref = testPlayer1.stars
    dropPanel.apply(context)
    context.gameState = new PanelEffectState

    assert(testPlayer1.stars < ref)
    assert(testPlayer1.stars <= (ref - testPlayer1.norma.getInt))
  }
}
