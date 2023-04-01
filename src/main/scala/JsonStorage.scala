package com.example
import io.circe.generic.auto._
import io.circe.parser._
import io.circe.syntax._
import java.nio.file.{Files, Paths}
import scala.collection.mutable.ListBuffer
import scala.io.Source
import java.io.File

object JsonStorage {
  val tasksFile = "tasks.json"

  def createFileIfNotExists(): Unit = {
    var file = new File(tasksFile)
    if(!file.exists()) {
        file.createNewFile()
        writeTasks(ListBuffer.empty)
    }
  }

  def readTasks(): ListBuffer[Task] = {
    createFileIfNotExists()
    val fileContent = Source.fromFile(tasksFile).mkString
    decode[ListBuffer[Task]](fileContent).getOrElse(ListBuffer.empty)
  }

  def writeTasks(tasks: ListBuffer[Task]): Unit = {
    val sortedTasks = tasks.sortBy(_.id)
    val jsonString = sortedTasks.asJson.toString()
    Files.write(Paths.get(tasksFile), jsonString.getBytes)
  }
}
