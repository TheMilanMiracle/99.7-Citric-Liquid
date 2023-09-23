package cl.uchile.dcc.citric
package model.norma

import scala.collection.mutable.ArrayBuffer

class normaListTest extends munit.FunSuite {
  var normaList: normaList = new normaList()
  var list: ArrayBuffer[Norma] = ArrayBuffer[Norma](new NormaLevel1, new NormaLevel2, new NormaLevel3, new NormaLevel4, new NormaLevel5, new NormaLevel6)

  test("a normaList should correctly have stored the norma levels and be able to return any of them"){
    assertEquals(normaList.getLevel(1).getInt, list(0).getInt)
    assertEquals(normaList.getLevel(2).getInt, list(1).getInt)
    assertEquals(normaList.getLevel(3).getInt, list(2).getInt)
    assertEquals(normaList.getLevel(4).getInt, list(3).getInt)
    assertEquals(normaList.getLevel(5).getInt, list(4).getInt)
    assertEquals(normaList.getLevel(6).getInt, list(5).getInt)
  }

  test("a normaList should be able to return if a norma level is the last one"){
    assertEquals(normaList.isLast(list(0)), false)
    assertEquals(normaList.isLast(list(1)), false)
    assertEquals(normaList.isLast(list(2)), false)
    assertEquals(normaList.isLast(list(3)), false)
    assertEquals(normaList.isLast(list(4)), false)
    assertEquals(normaList.isLast(list(5)), true)
  }

  test("a normaList should be able to return the next norma level form a given one"){
    assertEquals(normaList.next(normaList.getLevel(1)).getInt, list(1).getInt)
    assertEquals(normaList.next(normaList.getLevel(2)).getInt, list(2).getInt)
    assertEquals(normaList.next(normaList.getLevel(3)).getInt, list(3).getInt)
    assertEquals(normaList.next(normaList.getLevel(4)).getInt, list(4).getInt)
    assertEquals(normaList.next(normaList.getLevel(5)).getInt, list(5).getInt)
  }

}
