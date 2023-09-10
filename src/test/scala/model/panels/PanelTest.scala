package cl.uchile.dcc.citric
package model.panels

import scala.collection.mutable.ArrayBuffer

class PanelTest extends munit.FunSuite{
  val neutralPanel: Panel = new NeutralPanel(ArrayBuffer[Panel]())
  /**
  val homePanel: Panel = new HomePanel(ArrayBuffer[Panel]())
  val bonusPanel: Panel = new BonusPanel(ArrayBuffer[Panel]())
  val dropPanel: Panel = new DropPanel(ArrayBuffer[Panel]())
  val encounterPanel: Panel = new EncounterPanel(ArrayBuffer[Panel]())
  */

  override def beforeEach(context: BeforeEach): Unit = {
    val neutralPanel: Panel = new NeutralPanel(ArrayBuffer[Panel]())
    /**
    val homePanel: Panel = new HomePanel(ArrayBuffer[Panel]())
    val bonusPanel: Panel = new BonusPanel(ArrayBuffer[Panel]())
    val dropPanel: Panel = new DropPanel(ArrayBuffer[Panel]())
    val encounterPanel: Panel = new EncounterPanel(ArrayBuffer[Panel]())
    */
  }

  test("Each panel has its own type well defined"){
    assertEquals(new NeutralPanel(ArrayBuffer[Panel]()), neutralPanel)
    /**
    assertEquals(new HomePanel(ArrayBuffer[Panel]()), homePanel)
    assertEquals(new BonusPanel(ArrayBuffer[Panel]()), bonusPanel)
    assertEquals(new DropPanel(ArrayBuffer[Panel]()), dropPanel)
    assertEquals(new EncounterPanel(ArrayBuffer[Panel]()), encounterPanel)
    */


  }
}
