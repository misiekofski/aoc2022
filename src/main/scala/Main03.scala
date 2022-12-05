package co.du.aoc

import scala.io.Source

object Main03 {

  private def getPriorityFromLetter(letter: Char): Int = {
    if (letter.isLower) {
      letter.toInt - 96
    } else {
      letter.toInt - 38
    }
  }

  def main(args: Array[String]): Unit = {
    val filename = "day3.txt"
    var sum = 0
    for (line <- Source.fromResource(filename).getLines) {
      val (left, right) = line.splitAt(line.length / 2)
      val common = left intersect right // this will return common char from both strings :D :D :D
      sum += getPriorityFromLetter(common(0))
    }
    println(sum)

    // part 2
    var badge_sum = 0
    val groups = Source.fromResource(filename).getLines.grouped(3).toList
    for (group <- groups) {
      val common = group(0) intersect group(1) intersect group(2)
      badge_sum += getPriorityFromLetter(common(0))
    }

    println(badge_sum)
  }
}
