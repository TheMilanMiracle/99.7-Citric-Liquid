package cl.uchile.dcc.citric
package controller.states

import controller.GameController

import cl.uchile.dcc.citric.exceptions.WrongStateTransitionException
import org.junit.Assert.assertThrows

class AttackStateTest extends munit.FunSuite {
  var state: GameState = new AttackState
  var testController: GameController = GameController.getInstance


  override def beforeEach(context: BeforeEach): Unit = {
    state = new AttackState
    testController = GameController.getInstance
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
    assertThrows(classOf[WrongStateTransitionException], () => state.startGame(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.newChapter(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.chapterEnds(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerKO(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.diceMiss(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.diceHit(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerNotKO(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.startMovement(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.keepsMoving(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerStops(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerHomePanel(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.noCombat(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.playerWins(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.combat(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.unitEvades(testController))
    assertThrows(classOf[WrongStateTransitionException], () => state.unitDefends(testController))
  }

  test("a state have the toString method redefined"){
    assertEquals(state.toString, "Attack State")
  }
}
