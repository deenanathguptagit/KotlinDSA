package array.medium

/**
 * take a array with same size of nums
 *
 * */
fun findDuplicates(nums: IntArray): List<Int> {
    val arr = IntArray(nums.size + 1) { 0 }
    val result = mutableListOf<Int>()
    for (num in nums) {
        arr[num] = arr[num] + 1
        if (arr[num] > 1) {
            result.add(num)
        }
    }
    return result
}

fun findDuplicates1(nums: IntArray): List<Int> {
    val seen = mutableSetOf<Int>()
    val result = mutableListOf<Int>()
    for (num in nums) {
        if (!seen.add(num)) result.add(num)
    }
    return result
}

fun findDuplicates2(nums: IntArray): List<Int> {
    val result = mutableListOf<Int>()

    // Iterate through the array to mark visited elements
    for (i in nums.indices) {
        // Get the correct index for the value (values are 1-based, indices are 0-based)
        val index = kotlin.math.abs(nums[i]) - 1

        // If the value at this index is already negative, it means we’ve seen this number before
        if (nums[index] < 0) {
            result.add(index + 1) // Add the duplicate number to the result list
        } else {
            // Otherwise, mark the number as seen by flipping the sign to negative
            nums[index] = -nums[index]
        }
    }

    return result
}

fun main() {
    val result = findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1))
    println(result.joinToString())
}