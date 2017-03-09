package io.github.arnaudt

import java.time.LocalDate

import org.specs2.mutable.Specification

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
class AddressBookReaderSpec extends Specification {

  "AddressBookReader" should {
    "split a contact line to an array of contact values with any leading and trailing whitespace removed" in {
      AddressBookReader.splitContactLine("Bill McKnight, Male, 16/03/77") === Array("Bill McKnight", "Male", "16/03/77")
    }

    "parse a date in string to a local date" in {
      AddressBookReader.parseDate("16/03/77") === LocalDate.of(1977, 3, 16)
    }
  }
}
