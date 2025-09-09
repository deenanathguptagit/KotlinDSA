package strings.easy

fun longestPalindrom(input: String): String {
    var result = String()

    for (i in 0 until input.length) {
        var subString = StringBuilder()
        for (j in i until input.length) {
            subString.append(input[j])
//            val subStr = subString.toString()
            var s = 0
            var e = subString.length - 1
            var isPalindrom = true
            while (s < e) {
                if (subString[s] != subString[e]) {
                    isPalindrom = false
                    break
                }
                s++
                e--
            }

            if (result.length < subString.length && isPalindrom) {
                result = subString.toString()
            }
        }
    }


    return result
}

fun longestPalindrome(str: String): String {
    var lps = ""

    for (i in 1 until str.length) {
        var low = i
        var high = i

        while (str[low] == str[high]) {
            low--
            high++

            if (low <= -1 || high >= str.length) break
        }
        var palindrome = str.substring(low + 1, high)
        if (palindrome.length > lps.length) {
            lps = palindrome
        }

        low = i -1
        high = i

        while (str[low] == str[high]) {
            low--
            high++

            if (low <= -1 || high >= str.length) break
        }
        palindrome = str.substring(low + 1, high)
        if (palindrome.length > lps.length) {
            lps = palindrome
        }
    }

    return lps
}


fun main() {
    val result = longestPalindrome("labab")
    println("result $result")
}