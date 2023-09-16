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
  var roboBall: IWildUnit = new RoboBall

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

  test("Any kind of wild unit should be able to take stars from a player") {
    testPlayer.stars = 50
    roboBall.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 25)
    assertEquals(roboBall.stars, 25)
    roboBall.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 12)
    assertEquals(roboBall.stars, 37)
    roboBall.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 6)
    assertEquals(roboBall.stars, 43)
  }

  test("Any kind of wild unit should be able to give stars to a player") {
    roboBall.stars = 25
    roboBall.dropStarsTo(testPlayer)
    assertEquals(testPlayer.stars, 25)
    assertEquals(roboBall.stars, 0)
  }
}