package app

import com.google.gson.Gson

data class Todo(val id: Int, val userId: Int, val title: String, val completed: Boolean)

val gson = Gson()

fun main() {
    printTodos()
    saveTodo()
}

fun printTodos() {
    val response = khttp.get("https://jsonplaceholder.typicode.com/todos")
    val data = gson.fromJson(response.text, Array<Todo>::class.java)
    data.forEach { println(it) }
}

fun saveTodo() {
    val data = gson.toJson(Todo(1, 1, "Zadanie z PO", true))
    val response = khttp.post("https://jsonplaceholder.typicode.com/todos", data = data)
    println(response.statusCode)
}