package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norma.{NormaLevel1, NormaLevel2, NormaLevel3, NormaLevel4, NormaLevel5, NormaList}

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  private val name = "testPlayer"
  private val maxHp = 10
  private val attack = 1
  private val defense = 1
  private val evasion = 1
  private val homePos = 1
  private var randomNumberGenerator = new Random(11)

  private var norma = new NormaLevel1
  private var objective = "init"

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
    assertEquals(character.homePanel, homePos)
    assertEquals(character.getStars, 0)
    assertEquals(character.getVictories, 0)
    assertEquals(character.getNorma.getInt, norma.getInt)
    assertEquals(character.getObjective, objective)
  }

  test("Any type of Game Unit should be able to vary and return their own currentHP"){
    character.varyCurrentHP(-5)
    assertEquals(character.getCurrentHP, 5)
    character.varyCurrentHP(3)
    assertEquals(character.getCurrentHP, 8)
    character.varyCurrentHP(15)
    assertEquals(character.getCurrentHP, maxHp)
    character.varyCurrentHP(-15)
    assertEquals(character.getCurrentHP, 0)
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

  test("A player should be able to return and change their own norma"){
    val normaList = new NormaList()
    assertEquals(character.getNorma.getInt, (new NormaLevel1).getInt)
    character.changeNorma(normaList.next(character.getNorma))
    assertEquals(character.getNorma.getInt, (new NormaLevel2).getInt)
    character.changeNorma(normaList.next(character.getNorma))
    assertEquals(character.getNorma.getInt, (new NormaLevel3).getInt)
    character.changeNorma(normaList.next(character.getNorma))
    assertEquals(character.getNorma.getInt, (new NormaLevel4).getInt)
    character.changeNorma(normaList.next(character.getNorma))
    assertEquals(character.getNorma.getInt, (new NormaLevel5).getInt)
  }

  test("A player character should be able to return and increase their own victories, depending on what kind of game unit they defeated"){
    var v = character.getVictories
    assertEquals(character.getVictories, v)
    character.increaseVictories(new Seagull)
    assertEquals(character.getVictories, 1)
    character.increaseVictories(new RoboBall)
    assertEquals(character.getVictories, 2)
    character.increaseVictories(new Chicken)
    assertEquals(character.getVictories, 3)
    character.increaseVictories(new PlayerCharacter("test character",1,1,1,1,1))
  }

  test("A player should be able to return and change his current objective"){
    assertEquals(character.getObjective, "init")
    character.changeObjective("victories")
    assertEquals(character.getObjective, "victories")
    character.changeObjective("stars")
    assertEquals(character.getObjective, "stars")

  }
}
