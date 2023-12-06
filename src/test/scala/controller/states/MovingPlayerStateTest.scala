package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException
import org.junit.Assert
import org.junit.Assert.assertThrows

class MovingPlayerStateTest extends munit.FunSuite {
  var state: GameState = new MovingPlayerState
  var testController: GameController = GameController.getInstance


  override def beforeEach(context: BeforeEach): Unit = {
    state = new MovingPlayerState
    testController = GameController.getInstance
    testController.gameState = state
  }

  test("the moving player state has its valid transitions well defined"){
    state.keepsMoving(testController)
    Assert.assertEquals(testController.gameState.getClass.getName, (new MovingPlayerState).getClass.getName)

    testController.gameState = state
    state.playerStops(testController)
    Assert.assertEquals(testController.gameState.getClass.getName, (new PanelEffectState).getClass.getName)

    testController.gameState = state
    state.playerHomePanel(testController)
    Assert.assertEquals(testController.gameState.getClass.getName, (new PanelEffectState).getClass.getName)
  }

  test("the moving player state throws a WrongStateTransitionException on invalid transitions") {
    assertThrows(classOf[WrongStateTransitionException], () => state.startGame(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.newChapter(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.chapterEnds(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerKO(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.diceMiss(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.diceHit(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerNotKO(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.startMovement(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.noCombat(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerWins(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.combat(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.unitAttacks(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.unitEvades(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.unitDefends(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.combatEnds(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.receiverNotKO(testController))
  }

  test("a state have the toString method redefined") {
    assertEquals(state.toString, "Moving Player State")
  }

}
