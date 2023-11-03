package cl.uchile.dcc.citric
package model.stance

import model.units.PlayerCharacter

class DefendingStanceTest extends munit.FunSuite {
  var stance: CombatStance = new DefendingStance
  var defendingPlayer: PlayerCharacter = new PlayerCharacter("def",20,1,3,1,1)
  defendingPlayer.stance = stance
  var attackingPlayer: PlayerCharacter = new PlayerCharacter("atk", 20, 3, 1, 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    stance = new DefendingStance
    defendingPlayer = new PlayerCharacter("def", 20, 1, 3, 1, 1)
    defendingPlayer.stance = stance
    attackingPlayer  = new PlayerCharacter("atk", 20, 3, 1, 1, 1)
  }

  test("a defending stance should be able to correctly make a player defend themself"){
    var i = 0
    while(i < 5) {
      attackingPlayer.attackUnit(defendingPlayer)

      assert(defendingPlayer.currentHP == defendingPlayer.maxHP - 1 || defendingPlayer.currentHP >= defendingPlayer.maxHP - (6 + attackingPlayer.attack - (6 + defendingPlayer.defense)))

      defendingPlayer.currentHP = defendingPlayer.currentHP + defendingPlayer.maxHP
      i += 1
    }
  }



}
