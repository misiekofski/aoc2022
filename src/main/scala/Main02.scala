package co.du.aoc

import scala.io.Source

object Main02 {

  private def getPointsForRound(array: Array[String]): Int = {
    var points: Map[Char, Int] = Map('A' -> 1, 'B' -> 2, 'C' -> 3, 'X' -> 1, 'Y' -> 2, 'Z' -> 3)
    val lost = 0
    val draw = 3
    val won = 6

    var my_points = 0

    val p1_choice = array(0)(0) // convert to char
    val p2_choice = array(1)(0)
    println(p1_choice)
    println(p2_choice)
    my_points += points.getOrElse(p2_choice, 0)

    if ((p1_choice == 'A' && p2_choice == 'X') || (p1_choice == 'B' && p2_choice == 'Y') || (p1_choice == 'C' && p2_choice == 'Z')) {
      my_points += draw
    } else if ((p1_choice == 'A' && p2_choice == 'Y') || (p1_choice == 'B' && p2_choice == 'Z') || (p1_choice == 'C' && p2_choice == 'X')) {
      my_points += won
    } else {
      my_points += lost
    }

    my_points
  }

  def main(args: Array[String]): Unit = {
    val filename = "day2.txt"
    var my_points = 0

    for (line <- Source.fromResource(filename).getLines) {
      my_points += getPointsForRound(line.split(" "))
    }

    println(my_points)
  }
}
