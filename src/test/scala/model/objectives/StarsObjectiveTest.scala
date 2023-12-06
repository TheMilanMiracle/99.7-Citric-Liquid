package cl.uchile.dcc.citric
package model.objectives

import cl.uchile.dcc.citric.model.norma.{NormaLevel1, NormaLevel2}
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

class StarsObjectiveTest extends munit.FunSuite {
  var starsObjective = new StarsObjective
  var testPlayer = new PlayerCharacter("test1", 1, 1, 1 , 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    starsObjective = new StarsObjective
    testPlayer = new PlayerCharacter("test1", 1, 1, 1, 1, 1)
  }

  test("the stars objective can correctly level up the norma level of a player"){
    testPlayer.objective = starsObjective
    testPlayer.normaCheck()
    assertEquals(testPlayer.norma.getInt, (new NormaLevel1).getInt)

    testPlayer.stars = 10

    testPlayer.normaCheck()
    assertEquals(testPlayer.norma.getInt, (new NormaLevel2).getInt)
  }

}
