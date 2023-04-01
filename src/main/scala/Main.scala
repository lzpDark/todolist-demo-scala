package com.example

import scala.collection.mutable.ListBuffer
object Main {
  def main(args: Array[String]): Unit = {
    var continue = true
    // construct todolist with parameter of initial tasks from json file
    ToDoList.ToDoList(JsonStorage.readTasks())
    while (continue) {
      println("Options: add | delete | update | list | exit")
      val input = scala.io.StdIn.readLine()
      input match {
        case "add" =>
          println("Enter task description:")
          val description = scala.io.StdIn.readLine()
          ToDoList.addTask(description) match {
            case Left(error) => println(s"Error: $error")
            case Right(task) => println(s"Task added: $task")
          }
        case "delete" =>
          println("Enter task id:")
          val id = scala.io.StdIn.readInt()
          val deleted = ToDoList.deleteTask(id)
          if (deleted) {
            println(s"Task with id $id deleted")
          } else {
            println(s"Task with id $id not found")
          }
        case "update" =>
          println("Enter task id:")
          val id = scala.io.StdIn.readInt()
          println("Enter new description:")
          val description = scala.io.StdIn.readLine()
          println("Enter new completed status (true/false):")
          val completed = scala.io.StdIn.readBoolean()
          val updatedTask = ToDoList.updateTask(id, description, completed)
          if (updatedTask.isDefined) {
            println(s"Task updated: $updatedTask")
          } else {
            println(s"Task with id $id not found")
          }
        case "list" =>
          val tasks = ToDoList.listTasks()
          if (tasks.isEmpty) {
            println("No tasks found")
          } else {
            println("Tasks:")
            tasks.foreach(println)
          }
        case "exit" =>
          continue = false
        case _ =>
          println("Invalid option")
      }
    }
  }
}
