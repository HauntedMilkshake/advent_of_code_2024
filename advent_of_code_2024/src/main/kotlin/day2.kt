import java.io.File
import kotlin.math.abs

fun List<Int>.isValid(): Boolean {
    val sign = this[this.size - 2] - this[this.size - 1]
    if (sign == 0) return false
    var flag = true

    this.forEachIndexed { index, i ->
        if (index != this.size - 1) {
            if (sign  * (i - this[index + 1]) < 0) {
                flag = false
            }
            if (abs(i - this[index + 1]) !in 1..3) {
                flag = false
            }
        }
    }

    return flag
}

fun main() {
    val input = File("src\\main\\kotlin\\input_2.txt").bufferedReader().readLines()
    println(input.filter { it.split(" ").map { subString -> subString.toInt()  }.isValid() }.size)
}
