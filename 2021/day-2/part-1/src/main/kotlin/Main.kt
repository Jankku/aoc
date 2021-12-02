import java.io.File

fun main() {
    var x = 0
    var y = 0

    File("src/main/kotlin/input.txt")
        .readLines()
        .map {
            val (k, v) = it.split(" ")
            val value = v.toInt()
            when (k) {
                "forward" -> x += value
                "up" -> y -= value
                "down" -> y += value
            }
        }

    println("Answer: ${x * y}")
}
