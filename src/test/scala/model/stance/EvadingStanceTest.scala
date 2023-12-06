package cl.uchile.dcc.citric
package model.stance

import cl.uchile.dcc.citric.model.units.player.PlayerCharacter

class EvadingStanceTest extends munit.FunSuite {
  var stance: CombatStance = new EvadingStance
  var evadingPlayer: PlayerCharacter = new PlayerCharacter("def", 20, 1, 1, 3, 1)
  evadingPlayer.stance = stance
  var attackingPlayer: PlayerCharacter = new PlayerCharacter("atk", 20, 3, 1, 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    stance = new EvadingStance
    evadingPlayer = new PlayerCharacter("def", 20, 1, 1, 3, 1)
    evadingPlayer.stance = stance
    attackingPlayer = new PlayerCharacter("atk", 20, 3, 1, 1, 1)
  }

  test("a evading stance should be able to correctly make a player defend themself") {
    var i = 0
    while (i < 5) {
      attackingPlayer.attackUnit(evadingPlayer)

      assert(evadingPlayer.currentHP == evadingPlayer.maxHP || evadingPlayer.currentHP >= evadingPlayer.maxHP - (6 + attackingPlayer.attack))

      evadingPlayer.currentHP = evadingPlayer.maxHP
      i += 1
    }
  }
}
