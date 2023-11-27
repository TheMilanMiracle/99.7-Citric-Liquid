package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException
import org.junit.Assert.assertThrows

class StartingStateTest extends munit.FunSuite {
  var state: GameState = new StartingState
  var testController: GameController = new GameController


  override def beforeEach(context: BeforeEach): Unit = {
    state = new StartingState
    testController = new GameController
    testController.gameState = state
  }

  test("the starting state has its valid transitions well defined"){
    state.resetController(testController)
    assertEquals(testController.gameState.getClass.getName, (new NewChapterState).getClass.getName)
  }

  test("the starting state throws a WrongStateTransitionException on invalid transitions"){
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
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitAttacks())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitEvades())
    assertThrows(classOf[WrongStateTransitionException], () => testController.unitDefends())
    assertThrows(classOf[WrongStateTransitionException], () => testController.combatEnds())
    assertThrows(classOf[WrongStateTransitionException], () => testController.receiverNotKO())
  }
}
