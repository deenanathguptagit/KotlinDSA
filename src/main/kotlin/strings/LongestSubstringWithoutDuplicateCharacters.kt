package strings

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
        maxCount = Math.max(maxCount, right - left + 1)
        right++
    }
    return maxCount
}
