import java.io.File

fun main() {
    var answer = 0
    var prev = Int.MAX_VALUE

    File("src/main/kotlin/input.txt")
        .readLines()
        .map(String::toInt)
        .forEach { depth ->
            if (depth > prev) answer++
            prev = depth
        }

    println("Answer: $answer")
}
