import java.io.File

fun main() {
    val zeroCounter = IntArray(12)
    val oneCounter = IntArray(12)
    var gammaRate = ""
    var epsilonRate = ""
    File("src/main/kotlin/input.txt")
        .readLines()
        .map {
            for (i in it.indices) {
                when (it[i].toString()) {
                    "0" -> zeroCounter[i]++
                    "1" -> oneCounter[i]++
                }
            }
        }
    zeroCounter.zip(oneCounter) { zeroCount, oneCount ->
        when {
            zeroCount > oneCount -> {
                gammaRate += "0"
                epsilonRate += "1"
            }
            oneCount > zeroCount -> {
                gammaRate += "1"
                epsilonRate += "0"
            }
        }
    }
    println("Answer: ${gammaRate.toInt(2) * epsilonRate.toInt(2)}")
}
