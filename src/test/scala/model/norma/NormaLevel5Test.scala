package cl.uchile.dcc.citric
package model.norma

import model.units.Chicken
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

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
    val testPlayer2 = new PlayerCharacter("test2",1,1,1,1,1)

    testPlayer.stars = (199)
    testPlayer2.increaseVictoriesTo(testPlayer)
    testPlayer2.increaseVictoriesTo(testPlayer)
    testPlayer2.increaseVictoriesTo(testPlayer)
    testPlayer2.increaseVictoriesTo(testPlayer)
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
    assertEquals(norma.getNext.getInt, (new NormaLevel6).getInt)
  }

  test("Every clonable entity should be able to return a copy of itself") {
    assertEquals(norma.getInt, norma.cloneEntity.getInt)
  }
}