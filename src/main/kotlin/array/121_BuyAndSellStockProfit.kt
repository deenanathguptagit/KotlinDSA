package array

import kotlin.math.max
import kotlin.math.min

fun main() {
//    val input = intArrayOf(5,4,2,1)
//    val input = intArrayOf(7,1,5,3,6,4)
//    println(maxProfit(input))

    val input = removeDuplicates1(intArrayOf(0,0,1,1,1,2,2))
    println(input)
}

fun maxProfit(prices: IntArray): Int {
    if (prices.size < 2) {
        return 0
    }

    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    for (price in prices) {
        minPrice = min(minPrice, price)
        maxProfit = max(maxProfit, price - minPrice)
    }

    return maxProfit
}

fun removeDuplicates1(nums: IntArray): Int {
    if (nums.isEmpty()) return 0

    var i = 1  // Pointer for the next unique position

    for (j in 1 until nums.size) {
        if (nums[j] != nums[j - 1]) {
            nums[i] = nums[j]
            i++
        }
    }

    return i
}