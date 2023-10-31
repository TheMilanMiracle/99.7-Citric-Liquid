package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norma.{NormaLevel1, NormaLevel2, NormaLevel3, NormaLevel4, NormaLevel5}
import cl.uchile.dcc.citric.model.objectives.{StarsObjective, VictoriesObjective}

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  private val name = "character"
  private val maxHp = 10
  private val attack = 1
  private val defense = 2
  private val evasion = 3
  private val homePos = 4

  private var norma = new NormaLevel1
  private var objective = None

  private var character: PlayerCharacter = new PlayerCharacter(name, maxHp, attack, defense, evasion, homePos)

  override def beforeEach(context: BeforeEach): Unit = {
    character = new PlayerCharacter(
      name,
      maxHp,
      attack,
      defense,
      evasion,
      homePos
    )
  }


  /** Game Unit tests */
  test("A character should have correctly set their attributes") {
    assertEquals(character.name, name)
    assertEquals(character.maxHP, maxHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
    assertEquals(character.homePanel, homePos)
    assertEquals(character.stars, 0)
    assertEquals(character.victories, 0)
    assertEquals(character.norma.getInt, norma.getInt)
    assertEquals(character.objective, objective)
  }

  test("a game unit should be able to get their basics stats HP, attack, defense, evasion and its name"){
    assertEquals(character.maxHP, maxHp)
    assertEquals(character.attack, attack)
    assertEquals(character.defense, defense)
    assertEquals(character.evasion, evasion)
    assertEquals(character.name, name)
  }

  test("a game unit should be able to get and set their current HP, maintaining the value between 0 and maxHP"){
    character.currentHP = 5
    assertEquals(character.currentHP, 5)
    character.currentHP = 6
    assertEquals(character.currentHP, 6)
    character.currentHP = 12
    assertEquals(character.currentHP, 10)
    character.currentHP = -4
    assertEquals(character.currentHP, 0)
  }

  test("Any type of game unit should be able to return and vary their current quantity of stars"){
    assertEquals(character.stars, 0)
    character.stars = (15)
    assertEquals(character.stars, 15)
    character.stars = (character.stars -5)
    assertEquals(character.stars, 10)
  }

  test("A game unit should be able to roll a dice") {
    var i = 0
    while (i < 5) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
      i += 1
    }
  }

  test("A game unit should be able to attack another one") {
    val combatTest: GameUnit = new PlayerCharacter("combat test", 10, 3, 3, 3, 1)

    val ret: Int = character.attack(combatTest)
    assert(ret >= character.attack + 1 && ret <= character.attack + 6)
  }

  test("A game unit should be able to defend itself from another one") {
    val combatTest: GameUnit = new PlayerCharacter("combat test", 10, 3, 3, 3, 1)

    val ret: Int = character.defend(combatTest)
    assert(ret >= character.defense + 1 && ret <= character.defense + 6)
  }

  test("A game unit should be able to try to avoid an attack from another one") {
    val combatTest: GameUnit = new PlayerCharacter("combat test", 10, 3, 3, 3, 1)

    val ret: Int = character.evade(combatTest)
    assert(ret >= character.evasion + 1 && ret <= character.evasion + 6)
  }

  /**Player Character Tests*/
  test("A player character should be able to return his home panel position"){
    assertEquals(character.homePanel, homePos)
  }

  test("A player character should be able to get and set their own victories"){
    var v = character.victories

    assertEquals(character.victories, v)
    character.victories = 1
    assertEquals(character.victories, v + 1)
    character.victories = 3
    assertEquals(character.victories, v + 3)
  }

  test("A player character should be able to correctly drop half of his stars to another player") {
    val testPlayer1 = new PlayerCharacter("test char1", 1, 1, 1, 1, 1)
    character.dropStarsTo(testPlayer1)
    assertEquals(testPlayer1.stars, 0)
    character.stars = 20
    character.dropStarsTo(testPlayer1)
    assertEquals(testPlayer1.stars, 10)
  }

  test("A player character should be able to increase another player's victories by 2") {
    val testPlayer1 = new PlayerCharacter("test char1", 1, 1, 1, 1, 1)
    character.increaseVictoriesTo(testPlayer1)
    assertEquals(testPlayer1.victories, 2)
    character.increaseVictoriesTo(testPlayer1)
    assertEquals(testPlayer1.victories, 4)
  }

  test("A player should be able to return and change their own norma") {
    assertEquals(character.norma.getInt, (new NormaLevel1).getInt)
    character.norma_=(character.norma.getNext)
    assertEquals(character.norma.getInt, (new NormaLevel2).getInt)
    character.norma_=(character.norma.getNext)
    assertEquals(character.norma.getInt, (new NormaLevel3).getInt)
    character.norma_=(character.norma.getNext)
    assertEquals(character.norma.getInt, (new NormaLevel4).getInt)
    character.norma_=(character.norma.getNext)
    assertEquals(character.norma.getInt, (new NormaLevel5).getInt)
  }

  test("A player should be able to return and change his current objective"){
    assertEquals(character.objective, None)
    val vo = new VictoriesObjective
    character.objective = vo
    assertEquals(character.objective.get, vo)

    val so = new StarsObjective
    character.objective = so
    assertEquals(character.objective.get, so)

  }

  test("a player should be able to correctly perform a norma check") {
    character.normaCheck()
    assertEquals(character.norma.getInt, 1)

    character.objective = new VictoriesObjective
    character.norma
    assertEquals(character.norma.getInt, 1)
    character.objective = new StarsObjective
    character.norma
    assertEquals(character.norma.getInt, 1)

    character.stars = 10
    character.normaCheck()
    assertEquals(character.norma.getInt, 2)

    character.objective = new VictoriesObjective
    character.victories = 3
    character.normaCheck()
    assertEquals(character.norma.getInt, 3)
  }
}
