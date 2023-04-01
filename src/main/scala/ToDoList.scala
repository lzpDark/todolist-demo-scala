package com.example
import scala.collection.mutable.ListBuffer
import scala.util.{Either, Left, Right}

object ToDoList {
  private val tasks: ListBuffer[Task] = new ListBuffer[Task]

  def ToDoList(initialTasks: ListBuffer[Task]) = {
    tasks ++= initialTasks
  }

  def isIdDuplicated(id: Int): Boolean = {
    // print(s"result=${tasks.exists(_.id == id)}, id=$id, taskSize=${tasks.size}")
    return tasks.exists(_.id == id)
  }

  def addTask(description: String): Either[String, Task] = {
    val newId = if (tasks.isEmpty) 1 else tasks.last.id + 1
    if(isIdDuplicated(newId)) {
        return Left(s"Task with id $newId already exists.")
    }
    val newTask = Task(newId, description, completed = false)
    tasks += newTask
    JsonStorage.writeTasks(tasks)
    Right(newTask)
  }

  def deleteTask(id: Int): Boolean = {
    val originalSize = tasks.size
    tasks --= tasks.filter(_.id == id)
    if (originalSize != tasks.size) {
      JsonStorage.writeTasks(tasks)
      true
    } else {
      false
    }
  }

  def updateTask(id: Int, newDescription: String, newCompleted: Boolean): Option[Task] = {
    tasks.find(_.id == id).map { task =>
      val updatedTask = task.copy(description = newDescription, completed = newCompleted)
      tasks -= task
      tasks += updatedTask
      JsonStorage.writeTasks(tasks)
      updatedTask
    }
  }

  def listTasks(): Seq[Task] = tasks.toSeq.sortBy(_.id)
}
