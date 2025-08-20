package array.easy

import kotlin.math.abs

fun findDisappearedNumbers(nums: IntArray): List<Int> {
    val countArray = IntArray(nums.size + 1)
    val result = mutableListOf<Int>()

    for (n in nums) {
        countArray[n] = n
    }

    for (c in 1..countArray.size - 1) {
        if (countArray[c] == 0) {
            result.add(c)
        }
    }
    return result

}
/*
* Uses the same inout array and marking by negative values for the particular index, if
* any of index value is marked in negative that means that index value is missing
* */
fun findDisappearedNumbers1(nums: IntArray): List<Int> {
    //approach 2 best approach
    //Uses the input array itself for marking by negating values (space complexity: O(1)).
    val result = mutableListOf<Int>()
    for (index in 0 until nums.size) {
        val idx = abs(nums[index]) - 1
        if (nums[idx] < 0) continue
        nums[idx] *= -1 // Mark as visited by negating
    }

    for (n in 0 until nums.size) {
        if (nums[n] > 0) {
            result.add(n + 1)
        }
    }
    return result

}

fun main() {
    val input = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
    println(findDisappearedNumbers(input))
}