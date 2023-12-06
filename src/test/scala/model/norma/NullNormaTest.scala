package cl.uchile.dcc.citric
package model.norma

import model.norma.factory.NullNormaFactory
import model.units.player.PlayerCharacter

class NullNormaTest extends munit.FunSuite {
  var norma = new NullNorma
  var testPlayer = new PlayerCharacter("test player",1,1,1,1,1)

  override def beforeEach(context: BeforeEach): Unit = {
    norma = new NullNorma
    testPlayer = new PlayerCharacter("test player",1,1,1,1,1)
  }

  test("Every level of norma should be able to return an int representing its level"){
    assertEquals(norma.getInt, -1)
  }

  test("Every level of norma should be able to return if a player meets the requirements to level up his norma"){
    assertEquals(norma.normaCheckStars(testPlayer.stars), true)
    assertEquals(norma.normaCheckVictories(testPlayer.victories), true)
  }

  test("Every level of norma should be able to return the norma next to the current level") {
    assertEquals(norma.getNext, NullNormaFactory)
  }
}
