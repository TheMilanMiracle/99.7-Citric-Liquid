package cl.uchile.dcc.citric
package model.panels

import model.units.PlayerCharacter

import scala.collection.mutable.ArrayBuffer

class DropPanelTest extends munit.FunSuite {
  val np: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
  val c: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
  val p: Int = 1
  var dropPanel = new DropPanel(np, p)
  var testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
  var testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)

  override def beforeEach(context: BeforeEach): Unit = {
    val np: ArrayBuffer[Panel] = ArrayBuffer[Panel]()
    val c: ArrayBuffer[PlayerCharacter] = ArrayBuffer[PlayerCharacter]()
    val p: Int = 1
    dropPanel = new DropPanel(np, p)
    testPlayer1 = new PlayerCharacter("test player1", 1, 1, 1, 1, 1)
    testPlayer2 = new PlayerCharacter("test player2", 1, 1, 1, 1, 2)
  }

  test("any kind of panel has to have its attributes well defined") {
    assertEquals(dropPanel.characters, c)
    assertEquals(dropPanel.nextPanels, np)
    assertEquals(dropPanel.position, p)
  }

  test("any kind of panel should be able to have one or more players in it") {
    dropPanel.addCharacter(testPlayer1)
    assertNotEquals(dropPanel.characters, c)
    assertEquals(dropPanel.characters.size, 1)
    assertEquals(dropPanel.characters(0), testPlayer1)
    dropPanel.removeCharacter(testPlayer2)
    assertEquals(dropPanel.characters.size, 1)
    assertEquals(dropPanel.characters(0), testPlayer1)
    dropPanel.addCharacter(testPlayer2)
    assertEquals(dropPanel.characters.size, 2)
    assertEquals(dropPanel.characters(0), testPlayer1)
    assertEquals(dropPanel.characters(1), testPlayer2)
    dropPanel.removeCharacter(testPlayer1)
    assertEquals(dropPanel.characters.size, 1)
    assertEquals(dropPanel.characters(0), testPlayer2)
    dropPanel.removeCharacter(testPlayer2)
    assertEquals(dropPanel.characters.size, 0)
    assertEquals(dropPanel.characters, c)
  }

  test("this panel will take stars from the player that trigger its effects depending of his norma and roll of the dice"){
    testPlayer1.varyStars(50)
    var ref: Int = testPlayer1.stars
    dropPanel.addCharacter(testPlayer1)
    dropPanel.triggerEffect()
    assert(testPlayer1.stars < ref)
    assert(testPlayer1.stars <= (ref - testPlayer1.norma.getInt))

    ref = testPlayer1.stars
    dropPanel.triggerEffect()
    assert(testPlayer1.stars < ref)
    assert(testPlayer1.stars <= (ref - testPlayer1.norma.getInt))
  }
}
