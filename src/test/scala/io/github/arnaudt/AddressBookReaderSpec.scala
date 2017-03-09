package io.github.arnaudt

import java.time.LocalDate

import org.specs2.mutable.Specification

import scala.util.Try

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
class AddressBookReaderSpec extends Specification {

  val billContact = Contact(
    fullName = Contact.FullName("Bill McKnight"),
    sex = Contact.Sex.Male,
    birthday = Contact.Birthday(LocalDate.of(1977, 3, 16)))

  "splitContactLine" should {
    "split a contact line to an array of contact values with any leading and trailing whitespace removed" in {
      AddressBookReader.splitContactLine("Bill McKnight, Male, 16/03/77") ==== Array("Bill McKnight", "Male", "16/03/77")
    }
  }

  "parseDate" should {
    "parse a date in string to a local date" in {
      AddressBookReader.parseDate("16/03/77") ==== Some(LocalDate.of(1977, 3, 16))
    }

    "return None if it cannot parse a date" in {
      AddressBookReader.parseDate("16-03/77") ==== None
    }
  }

  "createContact" should {
    "create a contact from string values" in {
      AddressBookReader.createContact("Bill McKnight", "Male", "16/03/77") ==== Try(billContact)
    }

    "fail if the birthday is not valid" in {
      AddressBookReader.createContact("Bill McKnight", "Male", "16-03-77").isFailure ==== true
    }

    "create a contact from an Array of string values" in {
      AddressBookReader.createContact(Array("Bill McKnight", "Male", "16/03/77")) ==== Some(billContact)
    }
  }
}
