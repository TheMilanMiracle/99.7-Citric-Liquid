package cl.uchile.dcc.citric
package model.norma

import model.units.PlayerCharacter

class NormaLevel6Test extends munit.FunSuite {
  var norma = new NormaLevel6
  var testPlayer = new PlayerCharacter("test player",1,1,1,1,1)

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new NormaLevel6
    testPlayer = new PlayerCharacter("test player",1,1,1,1,1)
  }

  test("Every level of norma should be able to return an int representing its level"){
    assertEquals(norma.getInt, 6)
  }

  test("Every level of norma should be able to return if a player meets the requirements to level up his norma"){
    assertEquals(norma.normaCheck(testPlayer.getStars, "stars"), true)
    assertEquals(norma.normaCheck(testPlayer.getVictories, "victories"), true)
  }
}
