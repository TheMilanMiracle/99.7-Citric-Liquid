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
  private var randomNumberGenerator = new Random(11)

  private var character: PlayerCharacter = new PlayerCharacter(name, maxHp, attack, defense, evasion, homePos, randomNumberGenerator)

  override def beforeEach(context: BeforeEach): Unit = {
    randomNumberGenerator = new Random(11)
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

  test("Any type of Game Unit should be able to vary their own currentHP"){
    character.varyCurrentHP(-5)
    assertEquals(character.currentHP, 5)
    character.varyCurrentHP(3)
    assertEquals(character.currentHP, 8)
    character.varyCurrentHP(15)
    assertEquals(character.currentHP, maxHp)
    character.varyCurrentHP(-15)
    assertEquals(character.currentHP, 0)
  }

  test("Any type of game unit should be able to return and vary their current quantity of stars"){
    var s = character.getStars
    assertEquals(character.getStars, s)
    character.varyStars(15)
    assertEquals(character.getStars, 15)
    character.varyStars(-5)
    assertEquals(character.getStars, 10)
  }

  test("Any type of game unit should be able to return their own name"){
    assertEquals(character.getName, name)
  }

  test("A character should be able to roll a dice") {
    var i = 0
    while (i < 5) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
      i += 1
    }
  }

  test("A player character should be able to increase their own victories, depending on what kind of game unit they defeated"){
    character.increaseVictories(new Seagull)
    assertEquals(character.victories, 1)
    character.increaseVictories(new RoboBall)
    assertEquals(character.victories, 2)
    character.increaseVictories(new Chicken)
    assertEquals(character.victories, 3)
    character.increaseVictories(new PlayerCharacter("test character",1,1,1,1,1))

  }
}
