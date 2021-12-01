import java.io.File

fun main() {
    val input = File("src/main/kotlin/input.txt")
        .readLines()
        .map(String::toInt)
        .windowed(3)
        .map {
            Measurement(it[0], it[1], it[2])
        }

    var previous = input[0]
    var answer = 0

    input.forEach { current ->
        if (current.sum() > previous.sum()) answer++
        previous = current
    }

    println("Answer: $answer")
}

data class Measurement(val a: Int, val b: Int, val c: Int) {
    fun sum() = a + b + c
}
