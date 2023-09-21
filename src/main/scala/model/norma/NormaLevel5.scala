package cl.uchile.dcc.citric
package model.norma

/** An Class that represents the level of "Norma"' 5
 *
 * This is the level comes after level 4
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel5 extends Norma{
  /** Method that returns an int of the norma level that is represented by the instance */
  def getInt: Int = 5

  /** Method that checks if the requirements for leveling from level 5 to 6
   *
   * @param current   the current quantity of stars/victories for checking
   * @param objective the objective of the player, it could be "stars"/"victories"
   */
  def normaCheck(current: Int, objective: String): Boolean = {
    if(objective == "stars") current >= 200
    else current >= 14
  }
}