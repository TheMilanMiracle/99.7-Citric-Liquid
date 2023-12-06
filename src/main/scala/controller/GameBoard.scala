package cl.uchile.dcc.citric
package controller

import model.panels.{BonusPanel, DropPanel, EncounterPanel, GamePanel, HomePanel, NeutralPanel}

import scala.collection.mutable.ArrayBuffer

/** Class that represents a game board
 *
 *
 * in the context of the game, a board consist of manu panels connected
 * between them, every panel stores the next(s) one(s)
 *
 * for instance, this class should be able to:
 * - build itself
 * - return any panel by its position
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class GameBoard private {
  /** Every panel on the board is stored in this list
   *
   * the index in the list is the position of the panel
   */
  private val _panels: ArrayBuffer[GamePanel] =  ArrayBuffer()

  /** Method that builds the board */
  private def buildBoard(): Unit = {
    /** shape of the board (just a square for simplicity)
     *  B:bonus, D:drop, E:encounter, H:home, N:neutral
     *
     *  H B B N D H
     *  E         E
     *  N         D
     *  D         B
     *  H E D B N H
     *
     */

    val controller: GameController = GameController.getInstance
    _panels += new HomePanel(_panels.length - 1, controller.getPlayer(0))
    _panels += new BonusPanel(_panels.length - 1)
    _panels += new BonusPanel(_panels.length - 1)
    _panels += new NeutralPanel(_panels.length - 1)
    _panels += new DropPanel(_panels.length - 1)
    _panels += new HomePanel(_panels.length - 1, controller.getPlayer(1))
    _panels += new EncounterPanel(_panels.length - 1)
    _panels += new DropPanel(_panels.length - 1)
    _panels += new BonusPanel(_panels.length - 1)
    _panels += new HomePanel(_panels.length - 1, controller.getPlayer(2))
    _panels += new NeutralPanel(_panels.length - 1)
    _panels += new BonusPanel(_panels.length - 1)
    _panels += new DropPanel(_panels.length - 1)
    _panels += new EncounterPanel(_panels.length - 1)
    _panels += new HomePanel(_panels.length - 1, controller.getPlayer(3))
    _panels += new DropPanel(_panels.length - 1)
    _panels += new NeutralPanel(_panels.length - 1)
    _panels += new EncounterPanel(_panels.length - 1)

    var i = 0
    while(i < _panels.length - 1){
      _panels(i).addPanel(_panels(i+1))
      i+=1
    }
    _panels(_panels.length-1).addPanel(_panels(0))
  }

  /** method that returns a panel in the board by its position
   *
   * @param pos an integer representing the position of the panel
   * @return the panel at the given position
   */
  def getPanel(pos: Int): GamePanel = {
    _panels(pos)
  }

}

/** Object that ensures that the GameBoard class
 * can only have one instance and provide a global access
 * to said instance
 *
 *
 * for instance this object can:
 * - store an instance of the class GameBoard
 * - return the instance, creating it if is not created yet
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
object GameBoard {
  /** only instance of the class GameController */
  private var _intance: Option[GameBoard] = None

  /** gets the GameController instance, creating it if is not created yet
   *
   * @return the one an only instance of the game board
   */
  def getInstance: GameBoard = {
    if (_intance.isEmpty) {
      _intance = Some(new GameBoard)
      _intance.get.buildBoard()
    }
    _intance.get
  }
}
