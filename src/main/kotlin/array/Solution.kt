package array

import kotlin.collections.sortedWith

/*
code[i] is non-empty and consists only of alphanumeric characters (a-z, A-Z, 0-9) and underscores (_).
businessLine[i] is one of the following four categories: "electronics", "grocery", "pharmacy", "restaurant".
isActive[i] is true.
*/
fun validateCoupons(code: Array<String>, businessLine: Array<String>, isActive: BooleanArray): List<String> {
    val result = mutableListOf<Triple<String, String, Boolean>>()
    val businessLines = mapOf(
        "electronics" to 0,
        "grocery" to 1,
        "pharmacy" to 2,
        "restaurant" to 3
    )

    if (code.size != businessLine.size || businessLine.size != isActive.size) {
        return emptyList()
    }

    for (i in code.indices) {
        val couponCode = code[i]
        val business = businessLine[i]
        val active = isActive[i]

        if (couponCode.isNotEmpty() && couponCode.matches(Regex("^[A-Za-z0-9_]+$")) && active && businessLines.contains(
                business
            )
        ) {
            result.add(Triple(couponCode, business, active))
        }
    }
    return emptyList()
//        .sortedBy { (businessLines[it.second] to it.first) as Pair<Int, String> }
//        .map { it.first }
}

fun main() {
    val code = arrayOf("SAVE20", "", "PHARMA5", "SAVE@20")
    val businessLine = arrayOf("restaurant", "grocery", "pharmacy", "restaurant")
    val isActive = booleanArrayOf(true, true, true, true)
    val result = validateCoupons(code, businessLine, isActive)
    println(result)
}
