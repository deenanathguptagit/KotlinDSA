package strings

import java.util.LinkedHashSet

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val set = LinkedHashSet<Char>() // Stores unique characters
        var left = 0
        var maxLength = 0

        for (right in s.indices) {
            while (s[right] in set) { // If duplicate found
                set.remove(s[left])  // Remove from left
                left++  // Move left pointer forward
            }
            set.add(s[right])  // Add current character
            maxLength = maxOf(maxLength, set.size)  // Update max length
        }

        return maxLength
    }
}

fun main() {
    val s = Solution()
    println(s.lengthOfLongestSubstring("abcabcbb"))
    println(s.lengthOfLongestSubstring("bbbbb"))
    println(s.lengthOfLongestSubstring("pwwkew"))
}