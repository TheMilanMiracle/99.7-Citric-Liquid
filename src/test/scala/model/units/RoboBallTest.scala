package cl.uchile.dcc.citric
package model.units

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
}