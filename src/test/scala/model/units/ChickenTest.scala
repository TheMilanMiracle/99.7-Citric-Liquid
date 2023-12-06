package cl.uchile.dcc.citric
package model.units

import model.stance.{DefendingStance, EvadingStance}

import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

class ChickenTest extends munit.FunSuite{
  val chickenMaxHp: Int = 3
  val chickenCurrentHp: Int = chickenMaxHp
  val chickenAttack: Int = -1
  val chickenDefense: Int = -1
  val chickenEvasion: Int = 1
  val chickenStars: Int = 0
  val chickenName: String = "Chicken"
  var chicken: WildUnit = new Chicken

  var testPlayer: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    val chickenMaxHp: Int = 3
    val chickenCurrentHp: Int = chickenMaxHp
    val chickenAttack: Int = -1
    val chickenDefense: Int = -1
    val chickenEvasion: Int = 1
    val chickenStars: Int = 0
    val chickenName: String = "Chicken"
    chicken = new Chicken

    testPlayer = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  }

  test("Any kind of Unit should have its attributes well defined"){
    assertEquals(chicken.maxHP, chickenMaxHp)
    assertEquals(chicken.currentHP, chickenCurrentHp)
    assertEquals(chicken.attack, chickenAttack)
    assertEquals(chicken.defense, chickenDefense)
    assertEquals(chicken.evasion, chickenEvasion)
    assertEquals(chicken.stars, chickenStars)
    assertEquals(chicken.name, chickenName)
  }

  test("a game unit should be able to get their basics stats HP, attack, defense, evasion and its name") {
    assertEquals(chicken.maxHP, chickenMaxHp)
    assertEquals(chicken.attack, chickenAttack)
    assertEquals(chicken.defense, chickenDefense)
    assertEquals(chicken.evasion, chickenEvasion)
    assertEquals(chicken.name, chickenName)
  }

  test("a game unit should be able to get and set their current HP, maintaining the value between 0 and maxHP") {
    chicken.currentHP = 2
    assertEquals(chicken.currentHP, 2)
    chicken.currentHP = 1
    assertEquals(chicken.currentHP, 1)
    chicken.currentHP = 10
    assertEquals(chicken.currentHP, chickenMaxHp)
    chicken.currentHP = -4
    assertEquals(chicken.currentHP, 0)
  }

  test("Any type of game unit should be able to return and vary their current quantity of stars") {
    assertEquals(chicken.stars, 0)
    chicken.stars = (15)
    assertEquals(chicken.stars, 15)
    chicken.stars = (chicken.stars - 5)
    assertEquals(chicken.stars, 10)
  }

  test("A game unit should be able to roll a dice") {
    var i = 0
    while (i < 5) {
      assert(chicken.rollDice >= 1 && chicken.rollDice <= 6)
      i += 1
    }
  }

  test("a game unit should be able to win stars from other game units (a wild unit will never win stars from another wild unit)") {
    val testPlayer = new PlayerCharacter("test name", 1, 1, 1, 1, 1)

    testPlayer.stars = 20
    chicken.winStars(testPlayer)
    assertEquals(chicken.stars, 10)
  }

  test("A game unit should be able to drop stars to a player correctly"){
    chicken.dropStarsTo(testPlayer)
    assertEquals(testPlayer.stars, 3)
    chicken.stars = chickenStars + 10
    chicken.dropStarsTo(testPlayer)
    assertEquals(testPlayer.stars, chicken.stars + 6)
  }

  test("A wild unit should be able to increase a player's victories by 1"){
    chicken.increaseVictoriesTo(testPlayer)
    assertEquals(testPlayer.victories, 1)
    chicken.increaseVictoriesTo(testPlayer)
    assertEquals(testPlayer.victories, 2)
  }

  test("A game unit should be able to attack another game unit") {
    val testUnit = new PlayerCharacter("test", 20, 1, 3, 3, 1)
    testUnit.stance = new DefendingStance

    var i = 0
    while (i < 10) {
      chicken.attackUnit(testUnit)

      assert(testUnit.currentHP == testUnit.maxHP - 1 || testUnit.currentHP >= testUnit.maxHP - (6 + chicken.attack - (1 + testUnit.defense)))

      testUnit.currentHP = testUnit.currentHP + testUnit.maxHP
      i += 1
    }

    testUnit.stance = new EvadingStance
    i = 0
    while (i < 10) {
      chicken.attackUnit(testUnit)

      assert(testUnit.currentHP == testUnit.maxHP || testUnit.currentHP >= testUnit.maxHP - (6 + chicken.attack))

      testUnit.currentHP = testUnit.currentHP + testUnit.maxHP
      i += 1
    }
  }

  test("A Game Unit should be able to return a string representation of itself properly") {
    assertEquals(chicken.toString, "Chicken | (atk:-1, def:-1, eva:1) | stars = 0")

    chicken.stars = 15

    assertEquals(chicken.toString, "Chicken | (atk:-1, def:-1, eva:1) | stars = 15")
  }

}
