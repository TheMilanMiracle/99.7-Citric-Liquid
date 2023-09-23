package cl.uchile.dcc.citric
package model.norma

/** An Class that represents the level of "Norma" 6
 *
 * This is the level comes after level 5 and is the final level, meaning that if a
 * player has it, he won the game. Therefore this norma level is the only one that will
 * never norma checked
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel6 extends Norma{
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 6
   */
  def getInt: Int = 6

  /** Method that returns true
   *
   * Being the level of norma 6 the last one, this one will never be norma checked
   *
   * @param current   the current quantity of stars/victories for checking
   * @param objective the objective of the player, it could be "stars"/"victories"
   *
   * @return true
   */
  def normaCheck(current: Int, objective: String): Boolean = {true}
}
