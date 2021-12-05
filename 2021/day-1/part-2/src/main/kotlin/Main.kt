import java.io.File

fun main() {
    var previous = Int.MAX_VALUE
    var answer = 0

    File("src/main/kotlin/input.txt")
        .readLines()
        .map(String::toInt)
        .windowed(3)
        .map { it.sum() }.forEach { current ->
            if (current > previous) answer++
            previous = current
        }

    println("Answer: $answer")
}
