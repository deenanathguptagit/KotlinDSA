package strings.medium

fun main() {
    val result = findAnagrams("cbaebabacd", "abc")
    println(result.joinToString())
}

/*
* Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
Example 1:
Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".
* */
fun findAnagrams(s: String, p: String): List<Int> {
    val result = mutableListOf<Int>()
    val sLength = s.length
    val pLength = p.length
    if (pLength > sLength) return result

    val pFreq = IntArray(26)
    val sFreq = IntArray(26)

    for (i in 0 until pLength) {
        pFreq[p[i] - 'a']++
        sFreq[s[i] - 'a']++
    }

    if (pFreq.contentEquals(sFreq)) {
        result.add(0)
    }

    for (i in pLength until sLength) {
        sFreq[s[i] - 'a']++

        sFreq[s[i - pLength] - 'a']--

        if (pFreq.contentEquals(sFreq)) {
            result.add(i - pLength + 1)
        }
    }

    return result
}