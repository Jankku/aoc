import java.io.File

fun main() {
    var horizontalPosition = 0
    var depth = 0

    File("src/main/kotlin/input.txt")
        .readLines()
        .map {
            val (command, value) = it.split(" ")
            when (command) {
                "forward" -> horizontalPosition += value.toInt()
                "up" -> depth -= value.toInt()
                "down" -> depth += value.toInt()
            }
        }

    println("Answer: ${horizontalPosition * depth}")
}
