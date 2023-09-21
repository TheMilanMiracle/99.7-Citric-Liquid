package cl.uchile.dcc.citric
package model.units

class SeagullTest extends munit.FunSuite{
  val seagullMaxHp: Int = 3
  val seagullCurrentHp: Int = seagullMaxHp
  val seagullAttack: Int = 1
  val seagullDefense: Int = -1
  val seagullEvasion: Int = -1
  val seagullStars: Int = 0
  val seagullName: String = "Seagull"
  var seagull: WildUnit = new Seagull

  var testPlayer: PlayerCharacter = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    val seagullMaxHp: Int = 3
    val seagullCurrentHp: Int = seagullMaxHp
    val seagullAttack: Int = -1
    val seagullDefense: Int = -1
    val seagullEvasion: Int = 1
    val seagullStars: Int = 0
    val seagullName: String = "Seagull"
    seagull = new Seagull

    testPlayer = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  }

  test("Any kind of Unit should have its attributes well defined"){
    assertEquals(seagull.maxHP, seagullMaxHp)
    assertEquals(seagull.currentHP, seagullCurrentHp)
    assertEquals(seagull.attack, seagullAttack)
    assertEquals(seagull.defense, seagullDefense)
    assertEquals(seagull.evasion, seagullEvasion)
    assertEquals(seagull.stars, seagullStars)
    assertEquals(seagull.name, seagullName)
  }

  test("Any type of Game Unit should be able to vary their own currentHP") {
    seagull.varyCurrentHP(-2)
    assertEquals(seagull.currentHP, 1)
    seagull.varyCurrentHP(1)
    assertEquals(seagull.currentHP, 2)
    seagull.varyCurrentHP(15)
    assertEquals(seagull.currentHP, seagullMaxHp)
    seagull.varyCurrentHP(-15)
    assertEquals(seagull.currentHP, 0)
  }

  test("Any type of game unit should be able to return and vary their current quantity of stars") {
    var s = seagull.getStars
    assertEquals(seagull.getStars, s)
    seagull.varyStars(15)
    assertEquals(seagull.getStars, 15)
    seagull.varyStars(-5)
    assertEquals(seagull.getStars, 10)
  }

  test("Any type of game unit should be able to return their own name") {
    assertEquals(seagull.getName, seagullName)
  }
}

