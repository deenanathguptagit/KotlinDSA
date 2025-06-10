package slidingwindow

import kotlin.math.max
import kotlin.math.min

fun main() {
//    val result = maximumSubarraySum(intArrayOf(1, 5, 4, 2, 9, 9, 9), 3)
//    println(result)
//    val res1 = minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))
//    println(res1)
//    val res = strings.countGoodSubstrings("xyzzaz")
//    println(res)
//    val res = productExceptSelf1(intArrayOf(1, 2, 3, 4))
//    println(res.joinToString())
    val res = maxProduct(174)
    println(res)
}

fun maxProduct(n: Int): Int {
    if(n < 10) return n

    val digits = n.toString().map { it.toString().toInt() }
    var maxProduct = 0

    for (i in digits.indices) {
        for (j in i + 1..<digits.size) {
            val product = digits[i] * digits[j]
            if (product > maxProduct) {
                maxProduct = product
            }
        }
    }

    return maxProduct
}

fun productExceptSelf(nums: IntArray): IntArray {
    val arr = IntArray(nums.size) { 0 }
    for (i in nums.indices) {
        var mul = 1
        for (j in nums.indices) {
            if (i == j) {
                continue
            }
            mul *= nums[j]
        }
        arr[i] = mul
    }
    return arr
}

//fun isStringPalindrome(str:String): Boolean {
//    str.filter { it.isLetter() }
//    var mid = if(str.length%2==0)
//    return false
//}

fun productExceptSelf1(nums: IntArray): IntArray {
    var mul = 1
    for (i in nums.indices) {
        mul *= nums[i]
    }
    val arr: IntArray = getModifiedArray(nums, mul)
    return arr
}

fun getModifiedArray(nums: IntArray, mul: Int): IntArray {
    val arr = IntArray(nums.size) { 0 }

    for (i in nums.indices) {
        arr[i] = mul / nums[i]
    }

    return arr

}

fun maximumSubarraySum(nums: IntArray, k: Int): Long {
    var maxSum: Long = 0
    val frequency = HashMap<Int, Int>()
    var currentWindSum: Long = 0
    var left = 0

    for (right in nums.indices) {
        currentWindSum += nums[right]
        frequency[nums[right]] = frequency.getOrDefault(nums[right], 0) + 1

        if (right - left + 1 == k) {
            if (frequency.size == k) {
                maxSum = max(maxSum, currentWindSum)
            }
            currentWindSum -= nums[left]
            frequency[nums[left]] = frequency[nums[left]]?.minus(1) ?: 0
            if (frequency[nums[left]] == 0) {
                frequency.remove(nums[left])
            }
            left++
        }

    }

    return maxSum
}

fun countGoodSubstrings(s: String): Int {
    var count = 0
    var left = 0
    for (i in 1..<s.length - 1) {
        if (s[i] != s[i - 1] && s[i] != s[i + 1] && s[i - 1] != s[i + 1]) {
            count++
        }
    }
    return count
}

fun minSubArrayLen(target: Int, nums: IntArray): Int {
    var left = 0
    var minSize = Int.MAX_VALUE
    var sum = 0

    for (right in nums.indices) {
        sum += nums[right]

        while (sum >= target) {
            minSize = min(minSize, right - left + 1)
            sum -= nums[left]
            left++
        }
    }
    return minSize
}