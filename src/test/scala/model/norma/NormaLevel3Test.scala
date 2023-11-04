package cl.uchile.dcc.citric
package model.norma

import model.units.{Chicken, PlayerCharacter}

class NormaLevel3Test extends munit.FunSuite {
  var norma = new NormaLevel3
  var testPlayer = new PlayerCharacter("test player",1,1,1,1,1)

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new NormaLevel3
    testPlayer = new PlayerCharacter("test player",1,1,1,1,1)
  }

  test("Every level of norma should be able to return an int representing its level"){
    assertEquals(norma.getInt, 3)
  }

  test("Every level of norma should be able to return if a player meets the requirements to level up his norma"){
    val testPlayer2 = new PlayerCharacter("test2",1,1,1,1,1)

    testPlayer.stars = (69)
    testPlayer2.increaseVictoriesTo(testPlayer)
    testPlayer2.increaseVictoriesTo(testPlayer)
    (new Chicken).increaseVictoriesTo(testPlayer)
    assertEquals(norma.normaCheckStars(testPlayer.stars),false)
    assertEquals(norma.normaCheckVictories(testPlayer.victories), false)
    testPlayer.stars = (testPlayer.stars + 1)
    (new Chicken).increaseVictoriesTo(testPlayer)
    assertEquals(norma.normaCheckStars(testPlayer.stars), true)
    assertEquals(norma.normaCheckVictories(testPlayer.victories), true)
  }

  test("Every level of norma should be able to return the norma next to the current level") {
    assertEquals(norma.getNext.getInt, (new NormaLevel4).getInt)
  }

  test("Every clonable entity should be able to return a copy of itself") {
    assertEquals(norma.getInt, norma.cloneEntity.getInt)
  }
}