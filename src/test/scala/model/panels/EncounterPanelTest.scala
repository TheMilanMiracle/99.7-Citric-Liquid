package cl.uchile.dcc.citric
package model.panels

import cl.uchile.dcc.citric.controller.GameController
import cl.uchile.dcc.citric.controller.states.{AttackState, PanelEffectState}
import cl.uchile.dcc.citric.model.units.WildUnit
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class EncounterPanelTest extends munit.FunSuite {
  val p: Int = 1
  var encounterPanel = new EncounterPanel(p)
  var testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  var testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)

  override def beforeEach(context: BeforeEach): Unit = {
    val p: Int = 1
    encounterPanel = new EncounterPanel(p)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined and their getters work correctly") {
    assertEquals(encounterPanel.characters, ArrayBuffer[PlayerCharacter]())
    assertEquals(encounterPanel.nextPanels, ArrayBuffer[GamePanel]())
    assertEquals(encounterPanel.position, p)
  }

  test("any kind of panel should be able to have one or more players in it") {
    encounterPanel.addCharacter(testPlayer1)
    assertNotEquals(encounterPanel.characters, ArrayBuffer[PlayerCharacter]())
    assertEquals(encounterPanel.characters.size, 1)
    assertEquals(encounterPanel.characters(0), testPlayer1)
    encounterPanel.removeCharacter(testPlayer2)
    assertEquals(encounterPanel.characters.size, 1)
    assertEquals(encounterPanel.characters(0), testPlayer1)
    encounterPanel.addCharacter(testPlayer2)
    assertEquals(encounterPanel.characters.size, 2)
    assertEquals(encounterPanel.characters(0), testPlayer1)
    assertEquals(encounterPanel.characters(1), testPlayer2)
    encounterPanel.removeCharacter(testPlayer1)
    assertEquals(encounterPanel.characters.size, 1)
    assertEquals(encounterPanel.characters(0), testPlayer2)
    encounterPanel.removeCharacter(testPlayer2)
    assertEquals(encounterPanel.characters.size, 0)
    assertEquals(encounterPanel.characters, ArrayBuffer[PlayerCharacter]())

  }

  test("any kind of panel should be able to add and remove panels from their next panels list") {
    val panel1 = new EncounterPanel(2)
    val panel2 = new EncounterPanel(3)

    encounterPanel.addPanel(panel1)
    assertEquals(encounterPanel.nextPanels, ArrayBuffer[GamePanel](panel1))
    encounterPanel.removePanel(panel1)
    assertEquals(encounterPanel.nextPanels, ArrayBuffer[GamePanel]())
    encounterPanel.addPanel(panel1)
    encounterPanel.addPanel(panel2)
    assertEquals(encounterPanel.nextPanels, ArrayBuffer[GamePanel](panel1, panel2))
  }

  test("when landing this panel, the player will engage combat with the wild unit on it"){
    val context: GameController = GameController.getInstance
    context.gameState = new PanelEffectState

    encounterPanel.apply(context)

    assertEquals(context.gameState.getClass.getName, (new AttackState).getClass.getName)
  }

  test("the encounter panel should be able to generate wild units, returns them and deleting them"){
    var i = 0
    while(i < 10){
      val wd: WildUnit = encounterPanel.wildUnit
      assert(wd.name == "Chicken" || wd.name == "Robo Ball" || wd.name == "Seagull")

      encounterPanel.wildUnitDefeated()

      i+=1
    }
  }
}
