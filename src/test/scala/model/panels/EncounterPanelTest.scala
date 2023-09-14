package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class EncounterPanelTest extends munit.FunSuite {
  val encounterPanel = new EncounterPanel(ArrayBuffer[Panel](),1)
  val testPlayer = new PlayerCharacter("test player1",1,1,1,1, 1)
  println(encounterPanel.wildUnit)

  override def beforeEach(context: BeforeEach): Unit = {
    val encounterPanel = new EncounterPanel(ArrayBuffer[Panel](),1)
    val testPlayer = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  }

  test("a panel should be able to initially spawn (and eventually respawn) a new wild unit randomly"){
    assert(encounterPanel.wildUnit.name == "Chicken" ||
      encounterPanel.wildUnit.name == "Robo Ball" ||
      encounterPanel.wildUnit.name == "Seagull"
    )

    var i = 0
    while(i != 5){
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
     * combat is not implemented yet :s
     */
  }
}
