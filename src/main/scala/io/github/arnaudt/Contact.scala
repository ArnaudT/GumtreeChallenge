package io.github.arnaudt

import java.time.LocalDate

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
case class Contact(fullName: Contact.FullName, sex: Contact.Sex.Value, birthday: Contact.Birthday) {
  override def toString: String = s"$fullName - $sex - $birthday"
}

object Contact {

  object Sex extends Enumeration {
    val Male, Female = Value
  }

  case class FullName(name: String) extends AnyVal {
    override def toString: String = name
  }

  case class Birthday(value: LocalDate) extends AnyVal {
    override def toString: String = value.toString
  }

}