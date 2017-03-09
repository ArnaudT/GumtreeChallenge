package io.github.arnaudt

import java.text.SimpleDateFormat
import java.time.{LocalDate, ZoneId}

import io.github.arnaudt.Contact.Birthday

import scala.io.Source
import scala.util.Try

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
object AddressBookReader {

  def splitContactLine(line: String): Array[String] = {
    line.split(',').map(_.trim)
  }

  def parseDate(date: String): Option[LocalDate] = {
    val format = new SimpleDateFormat("dd/MM/yy")
    Try(format.parse(date)
      .toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).toOption
  }

  def createContact(fullName: String, sex: String, birthday: String): Option[Contact] = {
    for {
      birthdayC <- parseDate(birthday).map(Birthday)
      sexC <- Try(Contact.Sex.withName(sex)).toOption
    } yield Contact(Contact.FullName(fullName), sexC, birthdayC)
  }

  def createContactFromArray(values: Array[String]): Option[Contact] = {
    Try(createContact(values(0), values(1), values(2))).toOption.flatten
  }

  def parse(source: Source): List[Contact] = {
    source.getLines()
      .map(splitContactLine)
      .flatMap(createContactFromArray)
      .toList
  }
}