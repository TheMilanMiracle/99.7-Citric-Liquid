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

  test("a game unit should be able to get their basics stats HP, attack, defense, evasion and its name") {
    assertEquals(seagull.maxHP, seagullMaxHp)
    assertEquals(seagull.attack, seagullAttack)
    assertEquals(seagull.defense, seagullDefense)
    assertEquals(seagull.evasion, seagullEvasion)
    assertEquals(seagull.name, seagullName)
  }

  test("a game unit should be able to get and set their current HP, maintaining the value between 0 and maxHP") {
    seagull.currentHP = 2
    assertEquals(seagull.currentHP, 2)
    seagull.currentHP = 1
    assertEquals(seagull.currentHP, 1)
    seagull.currentHP = 10
    assertEquals(seagull.currentHP, seagullMaxHp)
    seagull.currentHP = -4
    assertEquals(seagull.currentHP, 0)
  }

  test("Any type of game unit should be able to return and vary their current quantity of stars") {
    assertEquals(seagull.stars, 0)
    seagull.stars = (15)
    assertEquals(seagull.stars, 15)
    seagull.stars = (seagull.stars - 5)
    assertEquals(seagull.stars, 10)
  }
}

