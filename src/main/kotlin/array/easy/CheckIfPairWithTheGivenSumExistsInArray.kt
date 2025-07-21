package array.easy

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        val complement = target - nums[i]

        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)
        }

        map[nums[i]] = i
    }

    return intArrayOf() // No valid pair found
}

fun main() {
    val res = twoSum(intArrayOf(2, 7, 11, 15), 9)
    res.forEach {
        print("$it \t")
    }
}