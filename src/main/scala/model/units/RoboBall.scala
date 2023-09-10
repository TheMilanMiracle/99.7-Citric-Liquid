package cl.uchile.dcc.citric
package model.units

class RoboBall extends abstractWildUnit {
  val maxHP: Int = 3
  var currentHP: Int = maxHP
  val attack: Int = -1
  val defense: Int = 1
  val evasion: Int = -1
  var stars: Int = 0
  val name: String = "Robo Ball"
}
