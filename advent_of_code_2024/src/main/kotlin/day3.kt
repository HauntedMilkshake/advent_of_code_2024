import java.io.File

fun main() {
    val input = File("src\\main\\kotlin\\input_3.txt").readLines()
    val regex = Regex("""mul\((\d{1,3}),\s*(\d{1,3})\)""")
    val doReg = Regex("""do\(\)""")
    val dontReg = Regex("""don't\(\)""")

    // Combine all lines into a single string
    val combinedString = input.joinToString(" ")
    val beforeDonot = dontReg.find(combinedString)
    // Extract the part after "don't()"
    val afterDont = dontReg.find(combinedString)?.range?.last?.let { combinedString.substring(it + 1) } ?: ""
    // Extract the part after "do()" from the remaining string
    val afterDo = doReg.find(afterDont)?.range?.last?.let { afterDont.substring(it + 1) } ?: afterDont

    // Process all matches for "mul(num1, num2)" in the filtered string
    val sum = regex.findAll(afterDo)
        .mapNotNull { match ->
            val num1 = match.groups[1]?.value?.toIntOrNull()
            val num2 = match.groups[2]?.value?.toIntOrNull()
            if (num1 != null && num2 != null) num1 * num2 else null
        }
        .sum()

    println("Filtered String: $afterDo")
    println("Sum of all multiplications: $sum")
}
