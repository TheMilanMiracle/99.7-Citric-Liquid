package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.controller.states.PanelEffectState
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class NeutralPanelTest extends munit.FunSuite{
  val p: Int = 1
  var neutralPanel = new NeutralPanel(p)
  var testPlayer1: PlayerCharacter = new PlayerCharacter("test player1",1 ,1,1, 1, 1)
  var testPlayer2: PlayerCharacter = new PlayerCharacter("test player2",1 ,1,1, 1, 2)

  override def beforeEach(context: BeforeEach): Unit = {
    val p: Int = 1
    neutralPanel = new NeutralPanel(p)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined and their getters work correctly"){
    assertEquals(neutralPanel.characters, ArrayBuffer[PlayerCharacter]())
    assertEquals(neutralPanel.nextPanels, ArrayBuffer[GamePanel]())
    assertEquals(neutralPanel.position, p)
  }

  test("any kind of panel should be able to have one or more players in it"){
    neutralPanel.addCharacter(testPlayer1)
    assertNotEquals(neutralPanel.characters, ArrayBuffer[PlayerCharacter]())
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
    assertEquals(neutralPanel.characters, ArrayBuffer[PlayerCharacter]())

  }

  test("any kind of panel should be able to add and remove panels from their next panels list") {
    val panel1 = new NeutralPanel(2)
    val panel2 = new NeutralPanel(3)

    neutralPanel.addPanel(panel1)
    assertEquals(neutralPanel.nextPanels, ArrayBuffer[GamePanel](panel1))
    neutralPanel.removePanel(panel1)
    assertEquals(neutralPanel.nextPanels, ArrayBuffer[GamePanel]())
    neutralPanel.addPanel(panel1)
    neutralPanel.addPanel(panel2)
    assertEquals(neutralPanel.nextPanels, ArrayBuffer[GamePanel](panel1, panel2))
  }

  test("the neutral kind of panel shouldn't have any effect on the player landing on it"){
    val context: GameController = GameController.getInstance
    context.gameState = new PanelEffectState

    val starsBefore1 = testPlayer1.stars
    val starsBefore2 = testPlayer2.stars

    neutralPanel.addCharacter(testPlayer1)
    neutralPanel.apply(GameController.getInstance)
    context.gameState = new PanelEffectState

    neutralPanel.addCharacter(testPlayer2)
    neutralPanel.apply(GameController.getInstance)
    context.gameState = new PanelEffectState

    assertEquals(testPlayer1.stars, starsBefore1)
    assertEquals(testPlayer2.stars, starsBefore2)
  }
}
