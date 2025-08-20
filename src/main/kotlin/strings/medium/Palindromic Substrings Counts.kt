package strings.medium

fun main() {
    val result = countSubstrings("abc")
    println(result
    )
}

fun countSubstrings(s: String): Int {
    var count = 0

    for (i in s.indices) {
        // Odd length palindromes
        count += expandAroundCenter(s, i, i)
        // Even length palindromes
        count += expandAroundCenter(s, i, i + 1)
    }

    return count
}

private fun expandAroundCenter(s: String, left: Int, right: Int): Int {
    var l = left
    var r = right
    var count = 0

    while (l >= 0 && r < s.length && s[l] == s[r]) {
        count++
        l--
        r++
    }

    return count
}
