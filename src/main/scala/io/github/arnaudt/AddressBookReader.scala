package io.github.arnaudt

import java.time.LocalDate

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
object AddressBookReader {
  def parseDate(date: String): LocalDate = ???

  def splitContactLine(line: String): Array[String] = {
    line.split(',').map(_.trim)
  }
}