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

  test("A game unit should be able to attack another one") {
    val combatTest: GameUnit = new PlayerCharacter("combat test", 10, 3, 3, 3, 1)

    val ret: Int = chicken.attack(combatTest)
    assert(ret >= chicken.attack + 1 && ret <= chicken.attack + 6)
  }

  test("A game unit should be able to defend itself from another one") {
    val combatTest: GameUnit = new PlayerCharacter("combat test", 10, 3, 3, 3, 1)

    val ret: Int = chicken.defend(combatTest)
    assert(ret >= chicken.defense + 1 && ret <= chicken.defense + 6)
  }

  test("A game unit should be able to try to avoid an attack from another one") {
    val combatTest: GameUnit = new PlayerCharacter("combat test", 10, 3, 3, 3, 1)

    val ret: Int = chicken.evade(combatTest)
    assert(ret >= chicken.evasion + 1 && ret <= chicken.evasion + 6)
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

}
