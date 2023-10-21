package cl.uchile.dcc.citric
package model.norma

import model.units.{Chicken, PlayerCharacter, WildUnit}

class NormaWonTest extends munit.FunSuite {
  var norma = new NormaWon
  var testPlayer = new PlayerCharacter("test player",1,1,1,1,1)

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new NormaWon
    testPlayer = new PlayerCharacter("test player",1,1,1,1,1)
  }

  test("Every level of norma should be able to return an int representing its level"){
    assertEquals(norma.getInt, -1)
  }

  test("Every level of norma should be able to return if a player meets the requirements to level up his norma") {
    testPlayer.stars = (0)
    assertEquals(norma.normaCheck(testPlayer.stars, "stars"), false)
    assertEquals(norma.normaCheck(testPlayer.victories, "victories"), false)
    testPlayer.stars = ( testPlayer.stars + 1)
    (new Chicken).increaseVictoriesTo(testPlayer)
    assertEquals(norma.normaCheck(testPlayer.stars, "stars"), false)
    assertEquals(norma.normaCheck(testPlayer.victories, "victories"), false)
  }

  test("Every level of norma should be able to return the norma next to the current level") {
    assertEquals(norma.getNext, norma)
  }
}


