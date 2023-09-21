package cl.uchile.dcc.citric
package model.units

import cl.uchile.dcc.citric.model.norma.{Norma, NormaLevel1}

import scala.util.Random

/** The `PlayerCharacter` class represents a character or avatar in the game, encapsulating
  * several attributes such as health points, attack strength, defense capability,
  * and evasion skills. Each player has a unique name, and throughout the game,
  * players can collect stars, roll dice, and progress in levels known as 'norma'.
  *
  * For instance, players can:
  *
  * - Roll a dice, a common action in many board games.
  * - return and increase their victories
  * - return their own objective
  *
  * Furthermore, the `Player` class has a utility for generating random numbers,
  * which is primarily used for simulating dice rolls. By default, this utility is
  * an instance of the `Random` class but can be replaced if different random
  * generation behaviors are desired.
  *
  * @param name The name of the player. This is an identifier and should be unique.
  * @param maxHP The maximum health points a player can have. It represents the player's endurance.
  * @param attack The player's capability to deal damage to opponents.
  * @param defense The player's capability to resist or mitigate damage from opponents.
  * @param evasion The player's skill to completely avoid certain attacks.
  * @param homePos The player's home panel position on the board
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
                      val homePos: Int,
                      val randomNumberGenerator: Random = new Random()) extends abstractGameUnit {
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
   */
  var homePanel: Int = homePos

  /** Stars that the Unit has
   *
   * Units can holds stars and the number can vary depending on the
   * outcome of combats with other Units, the stars start at 0
   *
   */
  var stars: Int = 0

  /** Victories that the Player has
   *
   * Player can obtain victories when defeating other Units in
   * combat, the quantity starts at 0
   *
   */
  var victories: Int = 0

  /** Norma level of the player
   *
   *  this variable represent how much a player has advanced in the game,
   *  it can be upgraded when the player lands on a home panel and it affects
   *  many situations of the game that depend on the norma level
   *
   *  It starts at level 1
   */
  var norma: Norma = new NormaLevel1

  /** Current Objective of the player
   *
   * a player can choose between "stars" and "victories" as objectives,
   * these are chosen when a player levels up an cannot be changed until
   * the next level up
   *
   * this value is initialized with a meaningless value because the objective is
   * chosen for the first time at norma level 2
   */
   var objective: String = "init"

  /** Rolls a dice and returns a value between 1 to 6. */
  def rollDice(): Int = {
    randomNumberGenerator.nextInt(6) + 1
  }

  /** returns the victories that the Player has */
  def getVictories: Int = this.victories

  /** return the current objective of the player */
  def getObjective: String = this.objective

  /** Increases number of victories after winning a combat against a wild unit
   *
   * In the context of the game, this value should increase in 1 if
   * the player defeated a wilds unit
   */
  def increaseVictories(wildUnit: WildUnit): Unit = {this.victories += 1}

  /** Increases number of victories after winning a combat against a wild unit
   *
   * In the context of the game, this value should increase in 2 if
   * the player defeated another player
   */
  def increaseVictories(playerCharacter: PlayerCharacter): Unit = {this.victories += 2}

}
