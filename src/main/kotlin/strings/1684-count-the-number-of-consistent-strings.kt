package strings

/**Example 1:

Input: allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
Output: 2
Explanation: Strings "aaab" and "baa" are consistent since they only contain characters 'a' and 'b'.
Example 2:

Input: allowed = "abc", words = ["a","b","c","ab","ac","bc","abc"]
Output: 7
Explanation: All strings are consistent.*/

fun countConsistentStrings(allowed: String, words: Array<String>): Int {
    var count = 0
    val allowedSet = allowed.toSet() // Convert to set for O(1) lookup

    for (word in words) {
        var flag = true
        for(i in 0 until word.length) {
            if(allowedSet.contains(word[i]).not()) {
                flag = false
            }
        }
        if(flag) {
            count++
        }
    }

    return count
}
fun main() {
    val allowed = "abc"
    val words = arrayOf("a","b","c","ab","ac","bc","abc")
    val result = countConsistentStrings(allowed, words)
    print(result)
}