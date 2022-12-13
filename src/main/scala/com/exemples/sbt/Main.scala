package com.exemples.sbt

import scala.util.Random

object Main {

  def main(args: Array[String]): Unit = {
    println(s"Start")
    val r = new Random()
    (0 to r.nextInt(1000)).foreach { i =>
      println(s"Iteration number $i")
    }
    println(s"end")
  }

}
