package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException
import org.junit.Assert.assertThrows

class AttackStateTest extends munit.FunSuite {
  var state: GameState = new AttackState
  var testController: GameController = new GameController


  override def beforeEach(context: BeforeEach): Unit = {
    state = new AttackState
    testController = new GameController
    testController.gameState = state
  }

  test("the attack state has its valid transitions well defined") {
    state.unitAttacks(testController)
    assertEquals(testController.gameState.getClass.getName, (new ResponseState).getClass.getName)

    testController.gameState = state
    state.combatEnds(testController)
    assertEquals(testController.gameState.getClass.getName, (new TurnLoopState).getClass.getName)

    testController.gameState = state
    state.receiverNotKO(testController)
    assertEquals(testController.gameState.getClass.getName, (new AttackState).getClass.getName)
  }

  test("the attack state throws a WrongStateTransitionException on invalid transitions") {
    assertThrows(classOf[WrongStateTransitionException], () => testController.resetController())
    assertThrows(classOf[WrongStateTransitionException], () => testController.newChapter())
    assertThrows(classOf[WrongStateTransitionException], () => testController.chapterEnds())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerKO())
    assertThrows(classOf[WrongStateTransitionException], () => testController.diceMiss())
    assertThrows(classOf[WrongStateTransitionException], () => testController.diceHit())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerNotKO())
    assertThrows(classOf[WrongStateTransitionException], () => testController.startMovement())
    assertThrows(classOf[WrongStateTransitionException], () => testController.keepsMoving())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerStops())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerHomePanel())
    assertThrows(classOf[WrongStateTransitionException], () => testController.noCombat())
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerWins())
    assertThrows(classOf[WrongStateTransitionException], () => testController.combat())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitEvades())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitDefends())
  }
}
