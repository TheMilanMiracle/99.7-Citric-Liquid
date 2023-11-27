package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException
import org.junit.Assert
import org.junit.Assert.assertThrows

class RecoveryStateTest extends munit.FunSuite {
  var state: GameState = new RecoveryState
  var testController: GameController = new GameController


  override def beforeEach(context: BeforeEach): Unit = {
    state = new RecoveryState
    testController = new GameController
    testController.gameState = state
  }

  test("the recovery state has its valid transitions well defined") {
    state.diceHit(testController)
    Assert.assertEquals(testController.gameState.getClass.getName, (new StarsAndDiceState).getClass.getName)

    testController.gameState = state
    state.diceMiss(testController)
    Assert.assertEquals(testController.gameState.getClass.getName, (new TurnLoopState).getClass.getName)
  }

  test("the recovery state throws a WrongStateTransitionException on invalid transitions") {
    assertThrows(classOf[WrongStateTransitionException], () => testController.resetController())
    assertThrows(classOf[WrongStateTransitionException], () => testController.newChapter())
    assertThrows(classOf[WrongStateTransitionException], () => testController.chapterEnds())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerKO())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerNotKO())
    assertThrows(classOf[WrongStateTransitionException], () => testController.startMovement())
    assertThrows(classOf[WrongStateTransitionException], () => testController.keepsMoving())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerStops())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerHomePanel())
    assertThrows(classOf[WrongStateTransitionException], () => testController.noCombat())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerWins())
    assertThrows(classOf[WrongStateTransitionException], () => testController.combat())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitAttacks())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitEvades())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitDefends())
    assertThrows(classOf[WrongStateTransitionException], () => testController.combatEnds())
    assertThrows(classOf[WrongStateTransitionException], () => testController.receiverNotKO())
  }
}
