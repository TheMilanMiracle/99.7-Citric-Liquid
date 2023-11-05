package cl.uchile.dcc.citric
package exceptions

class UnitNameTest extends munit.FunSuite {
  val minimumLength: Int = 3

  test("the 'minLen' requirement returns the name if meets the minimum length"){
    val testName = "generic name"
    assertEquals(Require.GameUnitName(testName) minLen minimumLength, testName)
  }

  test("the 'minLen' requirement throws an exception if the name has a lower length than the minimum"){
    val testName = "a"
    interceptMessage[InvalidUnitNameException](s"An invalid game unit name was found -- Unit's name cannot be too shorter that $minimumLength"){
      Require.GameUnitName(testName) minLen minimumLength
    }
  }

  test("the 'noSpecialChar' requirement returns the name if it doesn't contain any special character"){
    val testName = "generic name"
    assertEquals(Require.GameUnitName(testName).noSpecialChars, testName)
  }

  test("the 'noSpecialChar' requirement throws an exception if the name has any special character"){
    val testName = "!generic name"
    interceptMessage[InvalidUnitNameException]("An invalid game unit name was found -- Unit's name cannot contain special characters, only letters"){
      Require.GameUnitName(testName).noSpecialChars
    }
  }

}
