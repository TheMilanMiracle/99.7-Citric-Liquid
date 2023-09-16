package cl.uchile.dcc.citric
package model.units

class ChickenTest extends munit.FunSuite{
  val chickenMaxHp: Int = 3
  val chickenCurrentHp: Int = chickenMaxHp
  val chickenAttack: Int = -1
  val chickenDefense: Int = -1
  val chickenEvasion: Int = 1
  val chickenStars: Int = 0
  val chickenName: String = "Chicken"
  var chicken:IWildUnit = new Chicken

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

  test("Any kind of wild unit should be able to take stars from a player"){
    testPlayer.stars = 50
    chicken.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 25)
    assertEquals(chicken.stars, 25)
    chicken.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 12)
    assertEquals(chicken.stars, 37)
    chicken.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 6)
    assertEquals(chicken.stars, 43)
  }

  test("Any kind of wild unit should be able to give stars to a player"){
    chicken.stars = 25
    chicken.dropStarsTo(testPlayer)
    assertEquals(testPlayer.stars, 25)
    assertEquals(chicken.stars, 0)
  }


}
