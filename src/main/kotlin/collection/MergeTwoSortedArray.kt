package collection

fun main() {
    val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
    merge(nums1, 3, intArrayOf(2, 4, 5), 3)
    println(nums1.joinToString())
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
    var i = m - 1 // Pointer for nums1
    var j = n - 1 // Pointer for nums2
    var k = m + n - 1 // Pointer for the end of nums1

    // Merge nums1 and nums2 from the end
    while (i >= 0 && j >= 0) {
        if (nums1[i] > nums2[j]) {
            nums1[k] = nums1[i]
            i--
        } else {
            nums1[k] = nums2[j]
            j--
        }
        k--
    }

    // If there are remaining elements in nums2, copy them
    while (j >= 0) {
        nums1[k] = nums2[j]
        j--
        k--
    }
}