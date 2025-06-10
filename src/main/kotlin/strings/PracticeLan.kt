package strings

import kotlin.math.max
import kotlin.math.min

fun isPalindrome(input: String): Boolean {
    val str = input.lowercase()
    var result = StringBuilder()

    var start = 0
    var end = str.length
    var index= 0

    while(start<end) {
        if(str[start] !in 'a'..'z') {
            start++
            continue
        }
        result.append(str[start])
        index++
        start++
    }
    start = 0
    end = result.length -1
    while(start<=end) {
        if(result[start] != result[end]) {
            return false
        }
        start++
        end--
    }
    return true
}
fun main() {
//    val result = maximumSubarraySum(intArrayOf(1, 5, 4, 2, 9, 9, 9), 3)
//    println(result)
//    val res = minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))
//    println(res)
//    val res = countGoodSubstrings("xyzzaz")
//    println(res)

    println( isPalindrome("A man, a plan, a canal: Panama"))

}

fun reverseWords(s: String): String {
    val words = mutableListOf<String>()
    var i = 0
    val n = s.length

    while (i < n) {
        while (i < n && s[i] == ' ') {
            i++
        } // Skip spaces
        if (i == n) break

        val sb = StringBuilder()
        sb.substring(1)
        while (i < n && s[i] != ' ') {
            sb.append(s[i++])
        }
        words.add(sb.toString())
    }
    var start = 0
    var end = words.size - 1
    while (start < end) {
        val temp = words[start]
        words[start] = words[end]
        words[end] = temp
        start++
        end--
    }
    return words.joinToString(" ")
}

fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    var maxSum: Long = 0
    val frequency = HashMap<Int, Int>()
    var currentWindSum: Long = 0
    var left = 0

    for (right in nums.indices) {
        currentWindSum += nums[right]
        frequency[nums[right]] = frequency.getOrDefault(nums[right], 0) + 1

        if (right - left + 1 == k) {
            if (frequency.size == k) {
                maxSum = max(maxSum, currentWindSum)
            }
            currentWindSum -= nums[left]
            frequency[nums[left]] = frequency[nums[left]]?.minus(1) ?: 0
            if (frequency[nums[left]] == 0) {
                frequency.remove(nums[left])
            }
            left++
        }

    }

    return maxSum
}

fun countGoodSubstrings(s: String): Int {
    var count = 0
    var left = 0
    for (i in 1..<s.length - 1) {
        if (s[i] != s[i - 1] && s[i] != s[i + 1] && s[i - 1] != s[i + 1]) {
            count++
        }
    }
    return count
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var minSize = Int.MAX_VALUE
    var sum = 0

    for (right in nums.indices) {
        sum += nums[right]

        while (sum >= target) {
            minSize = min(minSize, right - left + 1)
            sum -= nums[left]
            left++
        }
    }
    return minSize
}

fun longestPalindrome1(s: String): String {

    return ""
}