package cl.uchile.dcc.citric
package model.units

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val homePos = 1
  private val randomNumberGenerator = new Random(11)

  private var character: PlayerCharacter = new PlayerCharacter(name, maxHp, attack, defense, evasion, homePos, randomNumberGenerator)

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      homePos,
      randomNumberGenerator
    )
  }

  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name)
    assertEquals(character.maxHP, maxHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
  }

  test("A character should be able to roll a dice") {
    var i = 0
    while(i < 5) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
      i += 1
    }
  }
}
