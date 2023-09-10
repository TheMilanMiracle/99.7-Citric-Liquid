package cl.uchile.dcc.citric
package model.units

trait IUnit {
  val maxHP: Int
  var currentHP: Int
  val attack: Int
  val defense: Int
  val evasion: Int
  var stars:Int
  val name: String
}
