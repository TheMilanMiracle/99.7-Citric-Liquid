package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class DropPanelTest extends munit.FunSuite {
  val dropPanel = new DropPanel(ArrayBuffer[Panel]())
  val testPlayer = new PlayerCharacter("test player1", 1, 1, 1, 1)

  override def beforeEach(context: BeforeEach): Unit = {
    val dropPanel = new DropPanel(ArrayBuffer[Panel]())
    val testPlayer = new PlayerCharacter("test player1", 1, 1, 1, 1)
  }

  test("this panel will take stars from the player that trigger its effects depending of his norma and roll of the dice"){
    testPlayer.stars = 50
    var ref: Int = testPlayer.stars
    dropPanel.addCharacter(testPlayer)
    dropPanel.triggerEffect()
    assert(testPlayer.stars < ref)
    assert(testPlayer.stars <= (ref - testPlayer.norma))

    ref = testPlayer.stars
    dropPanel.triggerEffect()
    assert(testPlayer.stars < ref)
    assert(testPlayer.stars <= (ref - testPlayer.norma))
  }
}
