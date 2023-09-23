package cl.uchile.dcc.citric
package model.norma

import model.units.{Chicken, PlayerCharacter}

class NormaLevel2Test extends munit.FunSuite {
  var norma = new NormaLevel2
  var testPlayer = new PlayerCharacter("test player",1,1,1,1,1)

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new NormaLevel2
    testPlayer = new PlayerCharacter("test player",1,1,1,1,1)
  }

  test("Every level of norma should be able to return an int representing its level"){
    assertEquals(norma.getInt, 2)
  }

  test("Every level of norma should be able to return if a player meets the requirements to level up his norma"){
    testPlayer.varyStars(29)
    testPlayer.increaseVictories(testPlayer)
    assertEquals(norma.normaCheck(testPlayer.getStars, "stars"),false)
    assertEquals(norma.normaCheck(testPlayer.getVictories, "victories"), false)
    testPlayer.varyStars(1)
    testPlayer.increaseVictories(new Chicken)
    assertEquals(norma.normaCheck(testPlayer.getStars, "stars"), true)
    assertEquals(norma.normaCheck(testPlayer.getVictories, "victories"), true)
  }
}
