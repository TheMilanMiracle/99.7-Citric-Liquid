package cl.uchile.dcc.citric
package model.norma

import model.units.{Chicken, PlayerCharacter, WildUnit}

class NormaLevel1Test extends munit.FunSuite {
  var norma = new NormaLevel1
  var testPlayer = new PlayerCharacter("test player",1,1,1,1,1)

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new NormaLevel1
    testPlayer = new PlayerCharacter("test player",1,1,1,1,1)
  }

  test("Every level of norma should be able to return an int representing its level"){
    assertEquals(norma.getInt, 1)
  }

  test("Every level of norma should be able to return if a player meets the requirements to level up his norma") {
    testPlayer.stars = (9)
    assertEquals(norma.normaCheckStars(testPlayer.stars), false)
    assertEquals(norma.normaCheckVictories(testPlayer.victories), false)
    testPlayer.stars = ( testPlayer.stars + 1)
    (new Chicken).increaseVictoriesTo(testPlayer)
    assertEquals(norma.normaCheckStars(testPlayer.stars), true)
    assertEquals(norma.normaCheckVictories(testPlayer.victories), true)
  }

  test("Every level of norma should be able to return the norma next to the current level"){
    assertEquals(norma.getNext.getInt, (new NormaLevel2).getInt)
  }
}


