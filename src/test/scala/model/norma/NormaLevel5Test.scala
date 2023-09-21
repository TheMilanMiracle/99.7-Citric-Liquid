package cl.uchile.dcc.citric
package model.norma

import model.units.PlayerCharacter

class NormaLevel5Test extends munit.FunSuite {
  var norma = new NormaLevel5
  var testPlayer = new PlayerCharacter("test player",1,1,1,1,1)

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new NormaLevel5
    testPlayer = new PlayerCharacter("test player",1,1,1,1,1)
  }

  test("Every level of norma should be able to return an int representing its level"){
    assertEquals(norma.getInt, 5)
  }

  test("Every level of norma should be able to return if a player meets the requirements to level up his norma"){
    testPlayer.stars = 199
    testPlayer.victories = 13
    assertEquals(norma.normaCheck(testPlayer.getStars, "stars"),false)
    assertEquals(norma.normaCheck(testPlayer.getVictories, "victories"), false)
    testPlayer.stars += 1
    testPlayer.victories += 1
    assertEquals(norma.normaCheck(testPlayer.getStars, "stars"), true)
    assertEquals(norma.normaCheck(testPlayer.getVictories, "victories"), true)
  }
}