import java.io.File

fun main() {
    val input = File("src/main/kotlin/input.txt").readLines()
    val o2Input = calculate(input, true)
    val co2Input = calculate(input, false)
    println("Answer: ${o2Input.first().toInt(2) * co2Input.first().toInt(2)}")
}

fun calculate(input: List<String>, isO2: Boolean): List<String> {
    var mutableInput = input.toList()

    for (i in mutableInput[0].indices) {
        var zeroCounter = 0
        var oneCounter = 0

        mutableInput.forEach { str -> if (str[i] == '0') zeroCounter++ else oneCounter++ }

        mutableInput = if (isO2) {
            val filter = if (zeroCounter > oneCounter) 0 else 1
            mutableInput.filterNum(i, filter)
        } else {
            val filter = if (zeroCounter > oneCounter) 1 else 0
            mutableInput.filterNum(i, filter)
        }
    }

    return mutableInput
}

fun List<String>.filterNum(index: Int, filter: Int) = this.filter { string ->
    if (this.size == 1) return@filter true
    string[index].toString() == filter.toString()
}
