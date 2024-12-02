import java.io.File
import kotlin.math.abs

fun calculateTotalDistance(firstList: MutableList<Int>, secondList: MutableList<Int>): Int {
    var sum = 0
    firstList.forEachIndexed { index, i ->
        sum += abs(i - secondList[index])
    }
    return sum;
}

fun calculateSimilarityScore(map: MutableMap<Int, Int>, firstList: List<Int>): Int {
   var sum = 0
    firstList.toSet().forEach {
        if(map.containsKey(it)) {
            sum += it * (map[it] ?: 0)
        }
    }
    return sum
}
fun main() {
    val input = File("src\\main\\kotlin\\input_1.txt").bufferedReader().readLines()
    val firstList = mutableListOf<Int>()
    val secondList = mutableListOf<Int>()
    //key - number from first list
    //value - times of occurrences
    val map = mutableMapOf<Int, Int>()

    var subList: List<String>

    input.forEachIndexed { index, string ->
        subList = string.split("   ")
        firstList.add(index, subList[0].toInt())

        if(map.containsKey(subList[1].toInt())) {
            map[subList[1].toInt()] = (map[subList[1].toInt()] ?: 0) * subList[1].toInt()
        } else {
            map[subList[1].toInt()] = 1
        }

        secondList.add(index, subList[1].toInt())

    }
    println(map)
    firstList.sort()
    secondList.sort()

    println(calculateTotalDistance(firstList, secondList))
    println(calculateSimilarityScore(map, firstList))
}