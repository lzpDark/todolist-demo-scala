package com.example
import scala.collection.mutable.ListBuffer
import munit.FunSuite

class listSpec extends munit.FunSuite {
  private val tasks: ListBuffer[Task]= ListBuffer.empty

  test("remove all elements with id 1") {
    tasks.addOne(new Task(1, "test", false))
    tasks.addOne(new Task(1, "test1", false))
    tasks.addOne(new Task(2, "test2", false))
    print(s"size = ${tasks.size}")
    assertEquals(tasks.size, 3)
    tasks --= tasks.filter(_.id == 1)
    assertEquals(tasks.size, 1)
  }
}