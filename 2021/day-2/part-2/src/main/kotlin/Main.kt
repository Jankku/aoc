import java.io.File

fun main() {
    var horizontalPosition = 0
    var depth = 0
    var aim = 0

    File("src/main/kotlin/input.txt")
        .readLines()
        .map {
            val (command, value) = it.split(" ")
            when (command) {
                "forward" -> {
                    horizontalPosition += value.toInt()
                    depth += aim * value.toInt()
                }
                "up" -> aim -= value.toInt()
                "down" -> aim += value.toInt()
            }
        }

    println("Answer: ${horizontalPosition * depth}")
}
