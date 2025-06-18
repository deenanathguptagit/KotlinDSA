package slidingwindow

import kotlin.math.max

/*
* Example:

Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum. */
fun main() {
    val arr = intArrayOf(100, 200, 300, 400)
    val n = 4
    val k = 2

    var sum = 0
    var maxSum: Int

    for (i in 0 until k) {
        sum += arr[i]
    }
    maxSum = sum

    // Slide the window to the right and find the max sum
    for (i in k until n) {
        sum = sum - arr[i - k] + arr[i] 
        maxSum = max(maxSum, sum)
    }

    println(maxSum)
}