package cl.uchile.dcc.citric
package model.objectives

import model.units.PlayerCharacter

import cl.uchile.dcc.citric.model.norma.{NormaLevel1, NormaLevel2}

class VictoriesObjectiveTest extends munit.FunSuite {
  var victoriesObjective = new VictoriesObjective
  var testPlayer = new PlayerCharacter("test1", 1, 1, 1 , 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    victoriesObjective = new VictoriesObjective
    testPlayer = new PlayerCharacter("test1", 1, 1, 1, 1, 1)
  }

  test("the victories objective can correctly level up the norma level of a player"){
    testPlayer.objective = victoriesObjective
    testPlayer.normaCheck()
    assertEquals(testPlayer.norma.getInt, (new NormaLevel1).getInt)

    testPlayer.victories = 1

    testPlayer.normaCheck()
    assertEquals(testPlayer.norma.getInt, (new NormaLevel2).getInt)
  }

}
