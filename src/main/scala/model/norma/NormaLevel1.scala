package cl.uchile.dcc.citric
package model.norma

/** An Class that represents the level of "Norma" 1
 *
 * This is the level that every player will have at start a game
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel1 extends Norma{
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 1
   */
  def getInt: Int = 1

  /** Method that checks if the requirements for leveling from level 1 to 2
   *
   * @param current   the current quantity of stars/victories for checking
   * @param objective the objective of the player, it could be "stars"/"victories"
   *
   * @return whether or not the requirements to level up from level 1 to 2 are met
   */
  def normaCheck(current: Int, objective: String): Boolean = {
    if(objective == "stars") current >= 10
    else current >= 1
  }
}
