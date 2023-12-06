package cl.uchile.dcc.citric
package model.stance

import model.units.GameUnit
import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

class DefendingStanceTest extends munit.FunSuite {
  var stance: CombatStance = new DefendingStance
  var defendingPlayer: GameUnit = new PlayerCharacter("def",20,1,3,1,1)
  defendingPlayer.stance = stance
  var attackingPlayer: GameUnit = new PlayerCharacter("atk", 20, 3, 1, 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    stance = new DefendingStance
    defendingPlayer = new PlayerCharacter("def", 20, 1, 3, 1, 1)
    defendingPlayer.stance = stance
    attackingPlayer  = new PlayerCharacter("atk", 20, 5, 1, 1, 2)
  }

  test("a defending stance should be able to correctly make a player defend themself"){
    var i = 0

    val minDmg = 1
    val maxDmg = 6 + attackingPlayer.attack - (1 + defendingPlayer.defense)

    while(i < 10) {
      attackingPlayer.attackUnit(defendingPlayer)

      assert(defendingPlayer.currentHP == defendingPlayer.maxHP - minDmg  || defendingPlayer.currentHP >= defendingPlayer.maxHP - maxDmg)

      defendingPlayer.currentHP = defendingPlayer.maxHP
      i += 1
    }
  }

}
