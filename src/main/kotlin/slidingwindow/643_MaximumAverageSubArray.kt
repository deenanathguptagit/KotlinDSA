package slidingwindow

fun main() {
    val arr = intArrayOf(1, 12, -5, -6, 50, 3, 4, 10)
    val result = findMaxAverage(arr, 4)
    println(result)
}

fun findMaxAverage(nums: IntArray, k: Int): Double {
    var sum = 0
    for(i in 0..<k) {
        sum+=nums[i]
    }
    var maxSum = sum

    var startIndex=0
    var endIndex=k

    while(endIndex<nums.size) {
        sum-=nums[startIndex]
        startIndex++
        sum+=nums[endIndex]
        endIndex++
        maxSum = Math.max(maxSum, sum)
    }
    return (maxSum/4).toDouble()
}