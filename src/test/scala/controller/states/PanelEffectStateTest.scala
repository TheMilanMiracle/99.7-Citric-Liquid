package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException
import org.junit.Assert.assertThrows

class PanelEffectStateTest extends munit.FunSuite {
  var state: GameState = new PanelEffectState
  var testController: GameController = new GameController


  override def beforeEach(context: BeforeEach): Unit = {
    state = new PanelEffectState
    testController = new GameController
    testController.gameState = state
  }

  test("the panel effect has its valid transitions well defined") {
    state.combat(testController)
    assertEquals(testController.gameState.getClass.getName, (new AttackState).getClass.getName)

    testController.gameState = state
    testController.noCombat()
    assertEquals(testController.gameState.getClass.getName, (new TurnLoopState).getClass.getName)

  }

  test("the panel effect state throws a WrongStateTransitionException on invalid transitions") {
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
    assertThrows(classOf[WrongStateTransitionException], () => testController.playerWins())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitAttacks())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitEvades())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitDefends())
    assertThrows(classOf[WrongStateTransitionException], () => testController.combatEnds())
    assertThrows(classOf[WrongStateTransitionException], () => testController.receiverNotKO())
  }
}
