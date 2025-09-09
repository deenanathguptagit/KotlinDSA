package strings.easy

fun firstNonRepeatingCharOnePass(s: String): Char? {
    val freq = mutableMapOf<Char, Int>()

    // Single pass to build frequencies (order preserved)
    for (c in s) {
        freq[c] = (freq[c] ?: 0) + 1
    }

    // Iterate in insertion order to find first non-repeating
    for ((ch, count) in freq) {
        if (count == 1) return ch
    }

    return null
}

fun firstNonRepeatingCharArray(s: String): Char? {
    val freq = IntArray(26)
    for (c in s) {
        freq[c - 'a']++
    }
    for (c in s) {
        if (freq[c - 'a'] == 1) return c
    }
    return null
}

fun main() {
    val inout = "aabxcc"
    println(firstNonRepeatingCharOnePass(inout))
}