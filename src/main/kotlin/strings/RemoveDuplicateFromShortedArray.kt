package strings

fun main() {
//    var intarray = intArrayOf(0, 0, 1, 1, 2, 3, 4, 5, 5, 5)
//    println(removeDuplicates(intarray))
    println(strStr("mississippi", "issip"))
}
fun strStr(haystack: String, needle: String): Int {
    var start1 = 0
    var start2 = 0
    val end1 = haystack.length
    val end2 = needle.length
    while (start1 < end1 && start2 < end2) {
        if(haystack[start1] == needle[start2]) {
            start1++
            start2++
        } else {
            start1++
            start2 = 0
        }
    }
    if(start2 == end2) {
        return start1 - start2
    }
    return  -1
}