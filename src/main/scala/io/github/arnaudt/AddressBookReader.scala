package io.github.arnaudt

import java.text.SimpleDateFormat
import java.time.{LocalDate, ZoneId}

import scala.util.Try

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
object AddressBookReader {

  val format = new SimpleDateFormat("dd/MM/yy")

  def splitContactLine(line: String): Array[String] = {
    line.split(',').map(_.trim)
  }

  def parseDate(date: String): Option[LocalDate] = {
    Try(format.parse(date)
      .toInstant().atZone(ZoneId.systemDefault()).toLocalDate()).toOption
  }

  def createContact(fullName: String, sex: String, birthday: String): Try[Contact] = ???

  def createContact(values: Array[String]): Option[Contact] = ???

}