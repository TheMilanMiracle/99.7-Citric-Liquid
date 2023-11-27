package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException
import org.junit.Assert.assertThrows

class TurnLoopStateTest extends munit.FunSuite {
  var state: GameState = new TurnLoopState
  var testController: GameController = new GameController


  override def beforeEach(context: BeforeEach): Unit = {
    state = new TurnLoopState
    testController = new GameController
    testController.gameState = state
  }

  test("the turn loop state has its valid transitions well defined") {
    state.chapterEnds(testController)
    assertEquals(testController.gameState.getClass.getName, (new NewChapterState).getClass.getName)

    testController.gameState = state
    state.playerKO(testController)
    assertEquals(testController.gameState.getClass.getName, (new RecoveryState).getClass.getName)

    testController.gameState = state
    state.playerNotKO(testController)
    assertEquals(testController.gameState.getClass.getName, (new StarsAndDiceState).getClass.getName)

    testController.gameState = state
    state.playerWins(testController)
    assertEquals(testController.gameState.getClass.getName, (new GameEndsState).getClass.getName)

  }

  test("the turn loop state throws a WrongStateTransitionException on invalid transitions") {
    assertThrows(classOf[WrongStateTransitionException], () => testController.resetController())
    assertThrows(classOf[WrongStateTransitionException], () => testController.newChapter())
    assertThrows(classOf[WrongStateTransitionException], () => testController.diceMiss())
    assertThrows(classOf[WrongStateTransitionException], () => testController.diceHit())
    assertThrows(classOf[WrongStateTransitionException], () => testController.startMovement())
    assertThrows(classOf[WrongStateTransitionException], () => testController.keepsMoving())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerStops())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerHomePanel())
    assertThrows(classOf[WrongStateTransitionException], () => testController.noCombat())
    assertThrows(classOf[WrongStateTransitionException], () => testController.combat())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitAttacks())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitEvades())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitDefends())
    assertThrows(classOf[WrongStateTransitionException], () => testController.combatEnds())
    assertThrows(classOf[WrongStateTransitionException], () => testController.receiverNotKO())
  }
}
