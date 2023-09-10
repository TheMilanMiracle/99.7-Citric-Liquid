package cl.uchile.dcc.citric
package model.units

trait IWildUnit extends IUnit{


  def takeStarsFrom(player:IUnit): Unit

  def dropStarsTo(player:IUnit): Unit
}
