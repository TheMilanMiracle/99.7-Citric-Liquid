package cl.uchile.dcc.citric
package model.units

import model.stance.{DefendingStance, EvadingStance}

class RoboBallTest extends munit.FunSuite {
  val roboBallMaxHp: Int = 3
  val roboBallCurrentHp: Int = roboBallMaxHp
  val roboBallAttack: Int = -1
  val roboBallDefense: Int = 1
  val roboBallEvasion: Int = -1
  val roboBallStars: Int = 0
  val roboBallName: String = "Robo Ball"
  var roboBall: WildUnit = new RoboBall

  var testPlayer: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    val roboBallMaxHp: Int = 3
    val roboBallCurrentHp: Int = roboBallMaxHp
    val roboBallAttack: Int = -1
    val roboBallDefense: Int = 1
    val roboBallEvasion: Int = -1
    val roboBallStars: Int = 0
    val roboBallName: String = "Robo Ball"
    roboBall = new RoboBall

    testPlayer = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  }

  test("Any kind of Unit should have its attributes well defined") {
    assertEquals(roboBall.maxHP, roboBallMaxHp)
    assertEquals(roboBall.currentHP, roboBallCurrentHp)
    assertEquals(roboBall.attack, roboBallAttack)
    assertEquals(roboBall.defense, roboBallDefense)
    assertEquals(roboBall.evasion, roboBallEvasion)
    assertEquals(roboBall.stars, roboBallStars)
    assertEquals(roboBall.name, roboBallName)
  }

  test("a game unit should be able to get their basics stats HP, attack, defense, evasion and its name") {
    assertEquals(roboBall.maxHP, roboBallMaxHp)
    assertEquals(roboBall.attack, roboBallAttack)
    assertEquals(roboBall.defense, roboBallDefense)
    assertEquals(roboBall.evasion, roboBallEvasion)
    assertEquals(roboBall.name, roboBallName)
  }

  test("a game unit should be able to get and set their current HP, maintaining the value between 0 and maxHP") {
    roboBall.currentHP = 2
    assertEquals(roboBall.currentHP, 2)
    roboBall.currentHP = 1
    assertEquals(roboBall.currentHP, 1)
    roboBall.currentHP = 10
    assertEquals(roboBall.currentHP, roboBallMaxHp)
    roboBall.currentHP = -4
    assertEquals(roboBall.currentHP, 0)
  }

  test("Any type of game unit should be able to return and vary their current quantity of stars") {
    assertEquals(roboBall.stars, 0)
    roboBall.stars = (15)
    assertEquals(roboBall.stars, 15)
    roboBall.stars = (roboBall.stars - 5)
    assertEquals(roboBall.stars, 10)
  }

  test("A game unit should be able to roll a dice") {
    var i = 0
    while (i < 5) {
      assert(roboBall.rollDice >= 1 && roboBall.rollDice <= 6)
      i += 1
    }
  }

  test("a game unit should be able to win stars from other game units (a wild unit will never win stars from another wild unit)") {
    val testPlayer = new PlayerCharacter("test name", 1, 1, 1, 1, 1)

    testPlayer.stars = 20
    roboBall.winStars(testPlayer)
    assertEquals(roboBall.stars, 10)
  }

  test("A game unit should be able to drop stars to a player correctly") {
    roboBall.dropStarsTo(testPlayer)
    assertEquals(testPlayer.stars, roboBall.stars + 2)
    roboBall.stars = roboBallStars + 10
    roboBall.dropStarsTo(testPlayer)
    assertEquals(testPlayer.stars, roboBall.stars + 4)
  }

  test("A wild unit should be able to increase a player's victories by 1") {
    roboBall.increaseVictoriesTo(testPlayer)
    assertEquals(testPlayer.victories, 1)
    roboBall.increaseVictoriesTo(testPlayer)
    assertEquals(testPlayer.victories, 2)
  }

  test("A game unit should be able to attack another game unit") {
    val testUnit = new PlayerCharacter("test", 20, 1, 3, 3, 1)
    testUnit.stance = new DefendingStance

    var i = 0
    while (i < 5) {
      roboBall.attackUnit(testUnit)

      assert(testUnit.currentHP == testUnit.maxHP - 1 || testUnit.currentHP >= testUnit.maxHP - (6 + roboBall.attack - (6 + testUnit.defense)))

      testUnit.currentHP = testUnit.currentHP + testUnit.maxHP
      i += 1
    }

    testUnit.stance = new EvadingStance
    i = 0
    while (i < 5) {
      roboBall.attackUnit(testUnit)

      assert(testUnit.currentHP == testUnit.maxHP || testUnit.currentHP >= testUnit.maxHP - (6 + roboBall.attack))

      testUnit.currentHP = testUnit.currentHP + testUnit.maxHP
      i += 1
    }
  }
}