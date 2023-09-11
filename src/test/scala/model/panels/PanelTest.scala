package cl.uchile.dcc.citric
package model.panels

import model.units.{IUnit, PlayerCharacter}

import scala.collection.mutable.ArrayBuffer

class PanelTest extends munit.FunSuite{
  val neutralPanel: Panel = new NeutralPanel(ArrayBuffer[Panel]())
  neutralPanel.position = 1
  val homePanel: Panel = new HomePanel(ArrayBuffer[Panel]())
  homePanel.position = 2
  val bonusPanel: Panel = new BonusPanel(ArrayBuffer[Panel]())
  bonusPanel.position = 3
  val dropPanel: Panel = new DropPanel(ArrayBuffer[Panel]())
  dropPanel.position = 4
  val encounterPanel: Panel = new EncounterPanel(ArrayBuffer[Panel]())
  encounterPanel.position = 5

  override def beforeEach(context: BeforeEach): Unit = {
    val neutralPanel: Panel = new NeutralPanel(ArrayBuffer[Panel]())
    val homePanel: Panel = new HomePanel(ArrayBuffer[Panel]())
    val bonusPanel: Panel = new BonusPanel(ArrayBuffer[Panel]())
    val dropPanel: Panel = new DropPanel(ArrayBuffer[Panel]())
    val encounterPanel: Panel = new EncounterPanel(ArrayBuffer[Panel]())
  }

  test("Each new created panel has its own type well defined compared with older ones"){
    assertEquals(new NeutralPanel(ArrayBuffer[Panel]()).getClass.getName, neutralPanel.getClass.getName)
    assertEquals(new HomePanel(ArrayBuffer[Panel]()).getClass.getName, homePanel.getClass.getName)
    assertEquals(new BonusPanel(ArrayBuffer[Panel]()).getClass.getName, bonusPanel.getClass.getName)
    assertEquals(new DropPanel(ArrayBuffer[Panel]()).getClass.getName, dropPanel.getClass.getName)
    assertEquals(new EncounterPanel(ArrayBuffer[Panel]()).getClass.getName, encounterPanel.getClass.getName)

    assertNotEquals(neutralPanel.getClass.getName, homePanel.getClass.getName)
    assertNotEquals(bonusPanel.getClass.getName, encounterPanel.getClass.getName)
    assertNotEquals(dropPanel.getClass.getName, bonusPanel.getClass.getName)
  }

  test("A panel could have one or more player, and they should be able to get in and out of the character list of the panel"){
    val testPlayer1: PlayerCharacter = new PlayerCharacter("test player1",1 ,1,1, 1)
    val testPlayer2: PlayerCharacter = new PlayerCharacter("test player2",1 ,1,1, 1)
    val testPlayer3: PlayerCharacter = new PlayerCharacter("test player3",1 ,1,1, 1)

    {neutralPanel.addCharacter(testPlayer1)}
    assertEquals(neutralPanel.characters.size,1)
    neutralPanel.addCharacter(testPlayer2)
    assertEquals(neutralPanel.characters.size,2)
    neutralPanel.addCharacter(testPlayer3)
    assertEquals(neutralPanel.characters.size, 3)
    neutralPanel.removeCharacter(testPlayer2)
    assertEquals(neutralPanel.characters.size, 2)
    neutralPanel.removeCharacter(testPlayer2)
    assertNotEquals(neutralPanel.characters.size, 1)
    neutralPanel.removeCharacter(testPlayer1)
    assertEquals(neutralPanel.characters.size, 1)

  }

  test("A panel could have one or more next panels"){
    val p1: Panel = new NeutralPanel(ArrayBuffer[Panel]())
    val p2: Panel = new DropPanel(ArrayBuffer[Panel]())
    val p3: Panel = new BonusPanel(ArrayBuffer[Panel]())

    neutralPanel.nextPanels = ArrayBuffer[Panel](p1)
    assertEquals(neutralPanel.nextPanels.size, 1)
    neutralPanel.nextPanels = ArrayBuffer[Panel](p1, p3)
    assertEquals(neutralPanel.nextPanels.size, 2)
    neutralPanel.nextPanels = ArrayBuffer[Panel](p1, p2, p3)
    assertEquals(neutralPanel.nextPanels.size, 3)
    assertNotEquals(neutralPanel.nextPanels.size, 2)
  }

  test("each panel should have a valid position and different from one another"){
    assertNotEquals(encounterPanel.position,homePanel.position)
    assertNotEquals(homePanel.position,bonusPanel.position)
    assertNotEquals(bonusPanel.position, dropPanel.position)
    assertNotEquals(dropPanel.position, encounterPanel.position)
  }
}
