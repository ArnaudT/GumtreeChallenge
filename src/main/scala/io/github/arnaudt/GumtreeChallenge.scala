package io.github.arnaudt

import java.time.temporal.ChronoUnit

import scala.io.Source

/**
  * Created by arnaudtanguy on 09/03/2017.
  */
object GumtreeChallenge extends App {
  println("Gumtree coding challenge")
  println("------------------------")

  // read the contacts from the file
  val contacts: Seq[Contact] = AddressBookReader.parse(Source.fromResource("AddressBook"))

  println("1. How many males are in the address book?")
  val nbMales: Int = contacts.count(_.sex == Contact.Sex.Male)
  println(s"- There are $nbMales males.\n")


  println("2. Who is the oldest person in the address book?")
  val oldestPerson: Option[Contact] = contacts.sortBy(_.birthday.value.toEpochDay).headOption
  println(s"- The oldest person is ${oldestPerson.map(_.fullName).getOrElse("no one")}.\n")


  println("3. How many days older is Bill than Paul?")
  //search for the users
  val billMaybe: Option[Contact] = contacts.find(_.fullName.name.contains("Bill"))
  val paulMaybe: Option[Contact] = contacts.find(_.fullName.name.contains("Paul"))

  // use java library to calculate the days between 2 date
  val diffDaysMaybe = for {
    bill <- billMaybe
    paul <- paulMaybe
  } yield {
    ChronoUnit.DAYS.between(bill.birthday.value, paul.birthday.value)
  }
  println(s"- Bill is ${diffDaysMaybe.getOrElse("error")} days older than Paul.\n")
}