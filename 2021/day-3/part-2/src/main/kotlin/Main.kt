import java.io.File

fun main() {
    val input = File("src/main/kotlin/input.txt").readLines()
    val o2Input = calculate(input, true)
    val co2Input = calculate(input, false)
    println("Answer: ${o2Input.first().toInt(2) * co2Input.first().toInt(2)}")
}

fun calculate(input: List<String>, isO2: Boolean): MutableList<String> {
    var mutableInput = input.toMutableList()
    for (i in input[0].indices) {
        var zeroCounter = 0
        var oneCounter = 0
        mutableInput.forEach { if (it[i].toString() == "0") zeroCounter++ else oneCounter++ }
        mutableInput = if (isO2) {
            when {
                zeroCounter > oneCounter -> filterNum(mutableInput, i, 0)
                zeroCounter < oneCounter -> filterNum(mutableInput, i, 1)
                oneCounter == zeroCounter -> filterNum(mutableInput, i, 1)
                else -> mutableListOf()
            }
        } else {
            when {
                zeroCounter > oneCounter -> filterNum(mutableInput, i, 1)
                zeroCounter < oneCounter -> filterNum(mutableInput, i, 0)
                oneCounter == zeroCounter -> filterNum(mutableInput, i, 0)
                else -> mutableListOf()
            }
        }
    }
    return mutableInput
}

fun filterNum(input: List<String>, index: Int, num: Int) = input.filter { string ->
    if (input.size == 1) return@filter true
    string[index].toString() == num.toString()
}.toMutableList()
