package cl.uchile.dcc.citric
package model.norma

/** An Class that represents the level of "Norma" 2
 *
 * This is the level comes after level 1
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel2 extends Norma{
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 2
   */
  def getInt: Int = 2

  /** Method that checks if the requirements for leveling from level 2 to 3
   *
   * @param current   the current quantity of stars/victories for checking
   * @param objective the objective of the player, it could be "stars"/"victories"
   *
   * @return whether or not the requirements to level up from level 2 to 3 are met
   */
  def normaCheck(current: Int, objective: String): Boolean = {
    if(objective == "stars") current >= 30
    else current >= 3
  }
}
