package array.easy

import kotlin.math.max


fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currSum = nums[0]

    for (i in 1 until nums.size) {
        currSum = max(nums[i], nums[i] + currSum)
        maxSum = max(currSum, maxSum)
    }
    return maxSum
}

fun main() {
    val result = maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    println(result)
}