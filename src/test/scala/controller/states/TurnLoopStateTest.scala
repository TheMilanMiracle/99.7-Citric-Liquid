package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException
import org.junit.Assert.assertThrows

class TurnLoopStateTest extends munit.FunSuite {
  var state: GameState = new TurnLoopState
  var testController: GameController = GameController.getInstance


  override def beforeEach(context: BeforeEach): Unit = {
    state = new TurnLoopState
    testController = GameController.getInstance
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
    assertThrows(classOf[WrongStateTransitionException], () => state.startGame(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.newChapter(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.diceMiss(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.diceHit(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.startMovement(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.keepsMoving(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerStops(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerHomePanel(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.noCombat(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.combat(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.unitAttacks(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.unitEvades(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.unitDefends(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.combatEnds(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.receiverNotKO(testController))
  }

  test("a state have the toString method redefined") {
    assertEquals(state.toString, "Turn Loop State")
  }
}
