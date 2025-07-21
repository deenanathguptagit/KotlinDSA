package array.easy

import kotlin.math.max


fun maxSubArray(nums: IntArray): Int {
    var sum = 0
    var maxSum = Int.MIN_VALUE
    var start = 0
    var end = 0
    for (num in nums) {
        sum += num
        if (sum < 0) {
            sum = 0
        }
        maxSum = max(sum, maxSum)
    }
    return maxSum
}

fun main() {
    val result = maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    println(result)
}