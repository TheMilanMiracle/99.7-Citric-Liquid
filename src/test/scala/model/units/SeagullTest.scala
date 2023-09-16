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
  var seagull:IWildUnit = new Seagull

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

  test("Any kind of wild unit should be able to take stars from a player"){
    testPlayer.stars = 50
    seagull.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 25)
    assertEquals(seagull.stars, 25)
    seagull.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 12)
    assertEquals(seagull.stars, 37)
    seagull.takeStarsFrom(testPlayer)
    assertEquals(testPlayer.stars, 6)
    assertEquals(seagull.stars, 43)
  }

  test("Any kind of wild unit should be able to give stars to a player"){
    seagull.stars = 25
    seagull.dropStarsTo(testPlayer)
    assertEquals(testPlayer.stars, 25)
    assertEquals(seagull.stars, 0)
  }


}

