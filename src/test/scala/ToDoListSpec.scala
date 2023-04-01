
package com.example
import scala.collection.mutable.ListBuffer
import munit.FunSuite

class ToDoListSpec extends munit.FunSuite {
    test("check isIdDuplicated") {
        val tasks = ListBuffer[Task]()
        val task1 = Task(1, "task1", completed = false)
        val task2 = Task(2, "task2", completed = false)
        tasks += task1
        tasks += task2
        ToDoList.ToDoList(tasks)
        assertEquals(ToDoList.isIdDuplicated(1), true)
        assertEquals(ToDoList.isIdDuplicated(2), true)
        assertEquals(ToDoList.isIdDuplicated(3), false)
    }
}