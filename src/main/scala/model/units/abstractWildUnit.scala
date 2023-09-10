package cl.uchile.dcc.citric
package model.units

abstract class abstractWildUnit extends IWildUnit {
  def takeStarsFrom(player:IUnit): Unit = {
    this.stars += player.stars / 2
    player.stars /= 2
  }

  override def dropStarsTo(player: IUnit): Unit = {
    player.stars += this.stars
  }
}