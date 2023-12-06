package cl.uchile.dcc.citric
package controller

import cl.uchile.dcc.citric.model.panels.{BonusPanel, DropPanel, EncounterPanel, GamePanel, HomePanel, NeutralPanel}

import scala.collection.mutable.ArrayBuffer

class GameBoardTest extends munit.FunSuite {
  val board: GameBoard = GameBoard.getInstance
  val controller: GameController = GameController.getInstance

  test("the game board should be able to correctly build itself and return any panel by position"){
    controller.setUpController()

    val expected = ArrayBuffer[GamePanel](
      new HomePanel(0, controller.getPlayer(0)), new BonusPanel(1), new BonusPanel(2), new NeutralPanel(3),
      new DropPanel(4), new HomePanel(5, controller.getPlayer(1)), new EncounterPanel(6), new DropPanel(7),
      new BonusPanel(8), new HomePanel(9, controller.getPlayer(2)), new NeutralPanel(10), new BonusPanel(11),
      new DropPanel(13), new EncounterPanel(12), new HomePanel(14, controller.getPlayer(3)), new DropPanel(15),
      new NeutralPanel(3), new EncounterPanel(17)
    )

    for(p <- Range.inclusive(0,16)){
      expected(p).addPanel(expected(p+1))
    }
    expected(17).addPanel(expected(0))

    for(p <- Range.inclusive(0,17)){
      assertEquals(board.getPanel(p).getClass.getName, expected(p).getClass.getName)
      assertEquals(board.getPanel(p).nextPanels(0).getClass.getName, expected(p).nextPanels(0).getClass.getName)
    }

  }

}
