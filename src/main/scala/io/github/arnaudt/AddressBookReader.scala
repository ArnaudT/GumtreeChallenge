package io.github.arnaudt

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
object AddressBookReader {

  def splitContactLine(line: String): Array[String] = {
    line.split(',').map(_.trim)
  }
}