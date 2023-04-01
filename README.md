# ToDoList Demo in Scala

  This is a really simple project only used to practice [Scala](https://www.scala-lang.org/).

## 1. prepare enviroment

  - install jdk

  - install [scala](https://docs.scala-lang.org/getting-started/index.html), checked by `scala -version`

  - open project folder with vscode
  
  - install vscode plugins "Scala Syntax(official)" & "Scala (Metals)"
  

## 2. run it

### 2.1 directly run

  go to project's root directory
  
  ```shell
   sbt run
  ```

### 2.2 package into jar to run

  ``` shell
   sbt assembly
   scala -jar target/scala-xx/{jar-filename}.jar
  ```

## 3. usage

  ``` txt
  # Options: add | delete | update | list | exit
  add
  # Enter task description:
  description of record
  # Task added: Task(1,description of record,false)
  # Options: add | delete | update | list | exit
  update
  # Enter task id:
  1
  # Enter new description:
  changed description
  # Enter new completed status (true/false):
  true
  # Task updated: Some(Task(1,changed description,true))
  # Options: add | delete | update | list | exit
  delete
  # Enter task id:
  1
  # Task with id 1 deleted
  # Options: add | delete | update | list | exit
  list
  # No tasks found
  # Options: add | delete | update | list | exit
  exit
  ```



