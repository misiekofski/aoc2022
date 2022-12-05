package co.du.aoc

import scala.io.Source

object Main01 {
  def main(args: Array[String]): Unit = {
    val filename = "day1.txt"
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

    println("Max", elves.max)
    println(elves.sorted(Ordering.Int.reverse).take(3).sum)
  }
}