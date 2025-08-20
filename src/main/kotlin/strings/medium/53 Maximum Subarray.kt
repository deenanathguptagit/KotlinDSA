package strings.medium

import kotlin.math.max

/*
* Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
* */
fun main() {
    val result = maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
    println(result)
}

fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currSum = nums[0]

    for (i in 1 until nums.size) {
        currSum = max(nums[i], nums[i] + currSum)
        maxSum = max(currSum, maxSum)
    }
    return maxSum
}