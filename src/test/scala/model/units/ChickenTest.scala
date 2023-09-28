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

  test("Any type of Game Unit should be able to correctly return their ATK, DEF and EVA") {
    assertEquals(chicken.attack, chickenAttack)
    assertEquals(chicken.defense, chickenDefense)
    assertEquals(chicken.evasion, chickenEvasion)
  }

  test("Any type of Game Unit should be able to vary and return their own currentHP") {
    chicken.varyCurrentHP(-2)
    assertEquals(chicken.currentHP, 1)
    chicken.varyCurrentHP(1)
    assertEquals(chicken.currentHP, 2)
    chicken.varyCurrentHP(15)
    assertEquals(chicken.currentHP, chickenMaxHp)
    chicken.varyCurrentHP(-15)
    assertEquals(chicken.currentHP, 0)
  }

  test("Any type of game unit should be able to return and vary their current quantity of stars") {
    var s = chicken.stars
    assertEquals(chicken.stars, s)
    chicken.varyStars(15)
    assertEquals(chicken.stars, 15)
    chicken.varyStars(-5)
    assertEquals(chicken.stars, 10)
  }

  test("Any type of game unit should be able to return their own name") {
    assertEquals(chicken.name, chickenName)
  }
}
