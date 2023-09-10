package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class BonusPanelTest extends munit.FunSuite{
  val bonusPanel = new BonusPanel(ArrayBuffer[Panel]())
  val testPlayer = new PlayerCharacter("test player1",1, 1, 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    val bonusPanel = new BonusPanel(ArrayBuffer[Panel]())
    val testPlayer = new PlayerCharacter("test player1", 1, 1, 1, 1)
  }

  test("the panel will give to a player a quantity of stars depending on his norma and roll of the dice"){
    bonusPanel.addCharacter(testPlayer)
    bonusPanel.triggerEffect()

    assert(0 < testPlayer.stars)
    assert(testPlayer.stars <= 6*testPlayer.norma || testPlayer.stars <= 6 * 3)

    var ref: Int = testPlayer.stars
    bonusPanel.triggerEffect()

    assert(ref < testPlayer.stars)
    assert(testPlayer.stars <= ((6 * testPlayer.norma) + ref) || testPlayer.stars <= ((6 * 3) + ref))

    ref = testPlayer.stars
    testPlayer.norma = 3
    bonusPanel.triggerEffect()

    assert(ref < testPlayer.stars)
    assert(testPlayer.stars <= ((6 * testPlayer.norma) + ref) || testPlayer.stars <= ((6 * 3) + ref))

  }

}
