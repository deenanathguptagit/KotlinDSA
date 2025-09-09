package array.medium

import kotlin.math.max

fun main() {
//    val result = maxProduct(intArrayOf(2,3,-2,4))
    val result = maxProduct(intArrayOf(-2, 3, -4))
    println(result)
}

/**
 * Given an integer array nums, find a subarray that has the largest product, and return the product.
 *
 * The test cases are generated so that the answer will fit in a 32-bit integer.
 * Example 1:
 *
 * Input: nums = [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * */
fun maxProduct(nums: IntArray): Int {
    val n: Int = nums.size
    var leftProduct = 1
    var rightProduct = 1
    var ans = nums[0]

    for (i in 0..<n) {
        leftProduct *= nums[i]
        rightProduct *= nums[n - 1 - i]

        ans = max(ans, max(leftProduct, rightProduct))

        // reset if product becomes 0
        if (leftProduct == 0) leftProduct = 1
        if (rightProduct == 0) rightProduct = 1
    }
    return ans
}