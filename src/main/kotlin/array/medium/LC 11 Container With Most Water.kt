package array.medium

import kotlin.math.max
import kotlin.math.min

fun maxArea(height: IntArray): Int {
    var left = 0
    var right = height.size - 1
    var maxWater = 0

    while(left<right) {
        val area = min(height[left], height[right]) * (right - left)

        maxWater = max(maxWater, area)

        if(height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }
    return maxWater
}
fun main() {
    val result = maxArea(intArrayOf(1,8,6,2,5,4,8,3,7))
    println(result)
}