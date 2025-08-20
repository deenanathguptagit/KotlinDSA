package array

/*Given an integer array nums sorted in non-decreasing order,
remove some duplicates in-place such that each unique element appears at most twice.
The relative order of the elements should be kept the same.*/
fun main() {
    val input = intArrayOf(1, 1, 1, 2, 2, 3)
    //output- [0,0,1,1,2,3,3,_,_]
    println(removeDuplicates(input))
}

/**
 * Explanation
 * Initial Check:
 * If the array length is ≤ 2, return it directly since no duplicates need removal.
 * Two-Pointer Technique:
 * i starts at 2 (since the first two elements are always allowed).
 * For each j (from 2 to end):
 * If nums[j] is different from nums[i - 2], it means nums[j] can be part of the result (either a new element or a valid duplicate).
 * Copy nums[j] to nums[i] and increment i.
 * Result:
 * The value of i gives the new length, and the first i elements of nums contain the valid elements.
 * */
fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 2) return nums.size

    var i = 2 // Start from the third element
    for (j in 2 until nums.size) {
        if (nums[j] != nums[i - 2]) {
            nums[i] = nums[j]
            i++
        }
    }
    return i
}