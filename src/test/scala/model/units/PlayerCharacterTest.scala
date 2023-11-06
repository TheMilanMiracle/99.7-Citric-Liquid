package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norma.{NormaLevel1, NormaLevel2, NormaLevel3, NormaLevel4, NormaLevel5}
import cl.uchile.dcc.citric.model.objectives.{StarsObjective, VictoriesObjective}
import cl.uchile.dcc.citric.model.stance.{DefendingStance, EvadingStance}

import scala.util.Random

class PlayerCharacterTest extends munit.FunSuite {
  private val name = "character"
  private val maxHp = 10
  private val attack = 4
  private val defense = 2
  private val evasion = 3
  private val homePos = 4
  private val stance = None

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
    assertEquals(character.stance, stance)
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

  test("Any type of game unit should be able to return and change their own combat stance"){
    val defending = new EvadingStance
    val evading = new EvadingStance

    assertEquals(character.stance, stance)
    character.stance = defending
    assertEquals(character.stance.get, defending)
    character.stance = evading
    assertEquals(character.stance.get, evading)
  }

  test("A game unit should be able to roll a dice") {
    var i = 0
    while (i < 5) {
      assert(character.rollDice >= 1 && character.rollDice <= 6)
      i += 1
    }
  }

  test("a game unit should be able to win stars from other game units"){
    val testPlayer = new PlayerCharacter("test name",1,1,1,1,1)
    val testChicken = new Chicken
    val testRoboBall = new RoboBall
    val testSeagull = new Seagull

    testPlayer.stars = 20
    character.winStars(testPlayer)
    assertEquals(character.stars, 10)

    testChicken.stars = 7
    character.winStars(testChicken)
    assertEquals(character.stars, expected = 20)

    testRoboBall.stars = 8
    character.winStars(testRoboBall)
    assertEquals(character.stars, 30)

    testSeagull.stars = 8
    character.winStars(testSeagull)
    assertEquals(character.stars, 40)
  }

  test("A game unit should be able to attack another game unit"){
    val testUnit = new PlayerCharacter("test", 20, 1, 3, 3, 1)
    testUnit.stance = new DefendingStance

    var i = 0
    while(i < 5){
      character.attackUnit(testUnit)

      assert(testUnit.currentHP == testUnit.maxHP - 1 || testUnit.currentHP >= testUnit.maxHP - (6 + character.attack - (6 + testUnit.defense)))

      testUnit.currentHP = testUnit.currentHP + testUnit.maxHP
      i += 1
    }

    testUnit.stance = new EvadingStance
    i = 0
    while(i < 5){
      character.attackUnit(testUnit)

      assert(testUnit.currentHP == testUnit.maxHP || testUnit.currentHP >= testUnit.maxHP - (6 + character.attack))

      testUnit.currentHP = testUnit.currentHP + testUnit.maxHP
      i += 1
    }
  }

  /**Player Character Tests*/
  test("A player character should be able to return his home panel position"){
    assertEquals(character.homePanel, homePos)
  }

  test("A player character should be able to get and set their own victories") {
    var v = character.victories

    assertEquals(character.victories, v)
    character.victories = 1
    assertEquals(character.victories, v + 1)
    character.victories = 3
    assertEquals(character.victories, v + 3)
  }

  test("A player character should be able to correctly drop half of his stars to another game unit") {
    val testPlayer1 = new PlayerCharacter("test char1", 1, 1, 1, 1, 1)
    character.dropStarsTo(testPlayer1)
    assertEquals(testPlayer1.stars, 0)
    character.stars = 20
    character.dropStarsTo(testPlayer1)
    assertEquals(testPlayer1.stars, 10)
  }

  test("a player should be able to correctly win victories"){
    val testPlayer = new PlayerCharacter("test name",1,1,1,1,1)
    character.winVictories(new Chicken)
    assertEquals(character.victories, 1)
    character.winVictories(testPlayer)
    assertEquals(character.victories, 3)
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
