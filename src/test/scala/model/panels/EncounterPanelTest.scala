package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class EncounterPanelTest extends munit.FunSuite {
  val np: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  val c: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  val p: Int = 1
  var encounterPanel = new EncounterPanel(np, p)
  var testPlayer1: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  var testPlayer2: PlayerCharacter = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)

  override def beforeEach(context: BeforeEach): Unit = {
    val np: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val c: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
    val p: Int = 1
    encounterPanel = new EncounterPanel(np, p)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined") {
    assertEquals(encounterPanel.characters, c)
    assertEquals(encounterPanel.nextPanels, np)
    assertEquals(encounterPanel.position, p)
  }

  test("any kind of panel should be able to have one or more players in it") {
    encounterPanel.addCharacter(testPlayer1)
    assertNotEquals(encounterPanel.characters, c)
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
    assertEquals(encounterPanel.characters, c)

  }

  test("a panel should be able to initially spawn (and eventually respawn) a new wild unit randomly"){
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
    encounterPanel.triggerEffect()
  }
}
