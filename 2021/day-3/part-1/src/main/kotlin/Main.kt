import java.io.File

fun main() {
    val start = System.currentTimeMillis()
    val zeroCounter = IntArray(12)

    val input = File("src/main/kotlin/input.txt")
        .readLines()
        .map {
            for (i in it.indices) {
                if (it[i] == '0') zeroCounter[i]++
            }
        }

    val gammaRate = mutableListOf<Int>()

    for (i in zeroCounter.indices) {
        if (zeroCounter[i] > input.size / 2) gammaRate.add(0) else gammaRate.add(1)
    }

    val epsilonRate = gammaRate.map { 1 - it }

    println("Answer: ${gammaRate.joinToString("").toInt(2) * epsilonRate.joinToString("").toInt(2)}")
    val end = System.currentTimeMillis()
    println("${end - start} ms")
}
