package strings.medium

import kotlin.math.max
/**
* Input: s = "abcabcbb"
* Output: 3
* Explanation: The answer is "abc", with the length of 3.
* */
fun main() {
    val result = lengthOfLongestSubstring("Deenanathgupta")
    println(result)
}

//Approach 1
fun lengthOfLongestSubstring1(s: String): Int {
    var count = 0
    val size = s.length
    for (i in 0 until s.length) {
        val seen = mutableListOf<Char>()
        var index = i
        while (index < size) {
            if (seen.contains(s[index]).not()) {
                seen.add(s[index])
            } else {
                count = max(count, seen.size)
                break
            }
            index++
        }

    }
    return count
}

//Approach 2: optimized solution
fun lengthOfLongestSubstring(str: String): Int {
    val seen = mutableSetOf<Char>()
    var left = 0
    var right = 0
    var maxCount = 0
    while (right < str.length) {
        while (seen.contains(str[right])) {
            seen.remove(str[left])
            left++
        }
        seen.add(str[right])
        maxCount = max(maxCount, seen.size)
        right++
    }
    return maxCount
}
