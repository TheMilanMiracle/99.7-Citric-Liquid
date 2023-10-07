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
    assertEquals(norma.normaCheck(testPlayer.stars, "stars"), false)
    assertEquals(norma.normaCheck(testPlayer.victories, "victories"), false)
    testPlayer.stars = ( testPlayer.stars + 1)
    (new Chicken).increaseVictoriesTo(testPlayer)
    assertEquals(norma.normaCheck(testPlayer.stars, "stars"), true)
    assertEquals(norma.normaCheck(testPlayer.victories, "victories"), true)
  }
}


