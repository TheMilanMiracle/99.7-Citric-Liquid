package cl.uchile.dcc.citric
package model.units

import scala.util.Random

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  * This class not only maintains the state of a player but also provides methods
  * to modify and interact with these attributes.
  *
  * For instance, players can:
 *
  * - Increase or decrease their star count.
 *
  * - Roll a dice, a common action in many board games.
 *
  * - Advance their norma level.
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHp The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param randomNumberGenerator A utility to generate random numbers. Defaults to a new `Random`
  *                              instance.
  *
  * @author [[https://github.com/danielRamirezL/ Daniel Ramírez L.]]
  * @author [[https://github.com/joelriquelme/ Joel Riquelme P.]]
  * @author [[https://github.com/r8vnhill/ Ignacio Slater M.]]
  * @author [[https://github.com/Seivier/ Vicente González B.]]
  * @author [[https://github.com/TheMilanMiracle/ Luciano Márquez C.]]
  */
class PlayerCharacter(val name: String,
              val maxHP: Int,
              val attack: Int,
              val defense: Int,
              val evasion: Int,
              val randomNumberGenerator: Random = new Random()) extends IUnit {
  /** Current hp of the unit
   *
   * Units health can vary when a combat with another Unit is initiated
   * its value is initiated with the maxHp declared at the constructor of
   * the class
   *
   */
  var currentHP: Int = maxHP

  /** The position of the home panel that this player owns
   *
   * In the context of the game, each player has a home panel of his own
   *
   * This attribute is initialized with an generic panel position to be change when the game starts
   */
  var homePanel: Int = 0

  /** Stars that the Unit has
   *
   *  Units can holds stars and the number can vary depending on the
   *  outcome of combats with other Units, the stars start at 0
   *
   */
  var stars = 0

  /** Victories that the Player has
   *
   * Player can obtain victories when defeating other Units in
   * combat, the quantity starts at 0
   *
   */
  var victories = 0

  /** Norma level of the player
   *
   *  this variable represent how much a player has advanced in the game,
   *  it can be upgraded when the player lands on a home panel and it affects
   *  many situations of the game that depend on the norma level
   *
   *  It starts at 1
   */
  var norma: Int = 1

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }
}
