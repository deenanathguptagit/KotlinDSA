package slidingwindow

import kotlin.math.max

//2461
fun main() {
    val result = maximumSubArraySum(intArrayOf(1, 5, 4, 2, 9, 9, 9), 3)
    println(result)
}

fun maximumSubArraySum(nums: IntArray, k: Int): Long {
    val n = nums.size
    var maxSum = Long.MIN_VALUE
    for (i in 0..<n - k + 1) {
        var start = i
        var sum: Long = 0
        while (start < i + k) {
            sum += nums[start]
            start++
        }
        maxSum = max(sum, maxSum)
    }
    return maxSum
}