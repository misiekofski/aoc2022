package co.du.aoc

import scala.io.Source

object Main {
  def main(args: Array[String]): Unit = {
    val filename = "day1-1.txt"
    var max = 0
    var elves = Array[Int]()
    for (line <- Source.fromResource(filename).getLines) {
      if (line.nonEmpty) {
        max = max + line.toInt
      } else {
        elves = elves :+ max
        max = 0
      }
    }

    println(elves.reduceLeft(_ max _))
  }
}