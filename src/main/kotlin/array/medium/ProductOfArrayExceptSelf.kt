package array.medium

/**
* We need to calculate the product of all elements in the array except the current index — but without using division (to handle zeros correctly).
To solve this:
For each index i, the result should be the product of:
All elements before i → store in left[i]
All elements after i → store in right[i]
So, result[i] = left[i] * right[i]
Steps:
Build the left[] array by multiplying elements from the left side.
Build the right[] array by multiplying elements from the right side.
Multiply left[i] * right[i] for each index to get the final result.
**/
fun productExceptSelf(nums: IntArray): IntArray {
    val n = nums.size
    val left = IntArray(nums.size)
    val right = IntArray(nums.size)
    val result = IntArray(nums.size)

    left[0] = 1
    right[n - 1] = 1

    for (i in 1..<n) {
        left[i] = left[i - 1] * nums[i - 1]
    }

    // Nothing to the right of last element, so initialize with 1
    right[n - 1] = 1
    for (i in n - 2 downTo 0) {
        right[i] = right[i + 1] * nums[i + 1]
    }

    for (i in nums.indices) {
        result[i] = left[i] * right[i]
    }
    return result
}

fun main() {
    val result = productExceptSelf(intArrayOf(-1,1,0,-3,3))
//    val result = productExceptSelf(intArrayOf(1, 2, 3, 4))

    println(result.joinToString())
}