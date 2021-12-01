import java.io.File

fun main() {
    val input = File("src/main/kotlin/input.txt")
        .readLines()
        .map(String::toInt)

    var answer = 0
    var prev = input.first()

    input.forEach { i ->
        if (i > prev) answer++
        prev = i
    }

    println("Answer: $answer")
}
