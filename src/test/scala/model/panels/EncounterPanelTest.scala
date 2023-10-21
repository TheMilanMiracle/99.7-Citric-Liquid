package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

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
    assertEquals(encounterPanel.nextPanels, ArrayBuffer[Panel]())
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
    assertEquals(encounterPanel.nextPanels, ArrayBuffer[Panel](panel1))
    encounterPanel.removePanel(panel1)
    assertEquals(encounterPanel.nextPanels, ArrayBuffer[Panel]())
    encounterPanel.addPanel(panel1)
    encounterPanel.addPanel(panel2)
    assertEquals(encounterPanel.nextPanels, ArrayBuffer[Panel](panel1, panel2))
  }

  test("an encounter panel should be able to initially spawn (and eventually respawn) a new wild unit randomly"){
    assert(encounterPanel.wildUnit.name == "Chicken" ||
      encounterPanel.wildUnit.name == "Robo Ball" ||
      encounterPanel.wildUnit.name == "Seagull"
    )

    var i = 0
    while(i < 5){
      encounterPanel.spawnWildUnit()
      assert(encounterPanel.wildUnit.name == "Chicken" ||
        encounterPanel.wildUnit.name == "Robo Ball" ||
        encounterPanel.wildUnit.name == "Seagull"
      )
      i+=1
    }
  }

  test("when landing this panel, the player will engage combat with the wild unit on it"){
    /**
     * combat is not yet implemented :s
     */
    encounterPanel.apply()
  }
}
