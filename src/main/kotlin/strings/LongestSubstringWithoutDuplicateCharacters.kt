package strings

import kotlin.math.max

fun main() {
    val str = "abcdecbeadfg"
    val result = longestSubString(str)
    println(result)
}

fun longestSubString(str: String): Int {
    val seen = mutableSetOf<Char>()
    var left = 0
    var right = 0
    var maxCount = 0
    while (right < str.length) {
        while (str[right] in seen) {
            seen.remove(str[left])
            left++
        }
        seen.add(str[right])
        maxCount = max(maxCount, seen.size)
        right++
    }
    return maxCount
}
