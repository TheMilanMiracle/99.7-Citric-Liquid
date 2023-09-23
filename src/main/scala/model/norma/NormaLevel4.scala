package cl.uchile.dcc.citric
package model.norma

/** An Class that represents the level of "Norma" 4
 *
 * This is the level comes after level 3
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel4 extends Norma{
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 4
   */
  def getInt: Int = 4

  /** Method that checks if the requirements for leveling from level 4 to 5
   *
   * @param current   the current quantity of stars/victories for checking
   * @param objective the objective of the player, it could be "stars"/"victories"
   *
   * @return whether or not the requirements to level up from level 4 to 5 are met
   */
  def normaCheck(current: Int, objective: String): Boolean = {
    if(objective == "stars") current >= 120
    else current >= 10
  }
}