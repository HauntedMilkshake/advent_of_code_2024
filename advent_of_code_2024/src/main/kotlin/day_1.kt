import java.io.File
import kotlin.math.abs

fun calculateTotalDistance(firstList: MutableList<Int>, secondList: MutableList<Int>): Int {
    var sum = 0
    firstList.forEachIndexed { index, i ->
        sum += abs(i - secondList[index])
    }
    return sum;
}
fun main() {
    val input = File("src\\main\\kotlin\\input_1.txt").bufferedReader().readLines()
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()

    var subList: List<String>

    input.forEachIndexed { index, string ->
        subList = string.split("   ")
        firstList.add(index, subList[0].toInt())
        secondList.add(index, subList[1].toInt())

    }

    firstList.sort()
    secondList.sort()

    println(calculateTotalDistance(firstList, secondList))
}