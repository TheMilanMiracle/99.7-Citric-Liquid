package cl.uchile.dcc.citric
package model.norma

/** A Class that represents the level of "Norma" 1
 *
 * This is the level that every player will have at start a game
 *
 * @author [[https://github.com/TheMilanMiracle Luciano Márquez C.]]
 */
class NormaLevel1 extends AbstractNorma(10, 1, Some(new NormaLevel2)){
  /** Method that returns an int of the norma level that is represented by the instance
   *
   * @return 1
   */
  def getInt: Int = 1

  /** Method that makes a copy of the game entity
   *
   * @return a new instance of a norma level 1
   */
  def cloneEntity: Norma = new NormaLevel1
}
