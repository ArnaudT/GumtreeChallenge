package io.github.arnaudt

import java.text.SimpleDateFormat
import java.time.{LocalDate, ZoneId}

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
object AddressBookReader {
  val format = new SimpleDateFormat("dd/MM/yy")

  def splitContactLine(line: String): Array[String] = {
    line.split(',').map(_.trim)
  }

  def parseDate(date: String): LocalDate = {
    format.parse(date)
      .toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
  }

}