package slidingwindow

class Solution {
    val list = listOf('a','e','i','o','u','A','I','O','U','E')

    fun reverseWords1(s: String): String {
        val charArr = s.toCharArray()
        var start = 0
        var end = charArr.size - 1
        while(start <  end) {
            val temp = charArr[start]
            charArr[start] = charArr[end]
            charArr[end] = temp
            start++
            end--
        }

        start = 0
        //the sky is blue
        for(i in charArr.indices) {
            if(charArr[i] == ' '|| i==charArr.size-1) {
                end = if(charArr[i] == ' ' ) {
                    i - 1
                } else {
                    charArr.size - 1
                }
                while(start<end) {
                    val temp = charArr[start]
                    charArr[start] = charArr[end]
                    charArr[end] = temp
                    start++
                    end--
                }
                start = i + 1
            }
        }
        return String(charArr)
    }


    fun reverseWords(s: String): String {
        val list = s.split(" ").toMutableList()
        var left = 0
        var right = list.size - 1
        while(left < right) {
            val t = list[left]
            list[left] = list[right]
            list[right] = t
            left++
            right--
        }
        val strBuilder = StringBuilder()
        for(i in list.indices) {
            strBuilder.append(list[i])
            if (i < list.size - 1) {
                strBuilder.append(" ")
            }
    }
    return strBuilder.toString()
}
    fun reverseVowels(s: String): String {
        val str = s.toCharArray()
        var left = 0
        var right = str.size - 1
        while(left<right) {
            if (isVowel(str[left]).not()) {
                left++
                continue
            }
            if (isVowel(str[right]).not()) {
                right--
                continue
            }

            val temp = str[left]
            str[left] = s[right]
            str[right] = temp
            left++
            right--
        }

        return String(str)
    }

    fun isVowel(ch:Char):Boolean {
        return list.contains(ch)
    }
}

fun main() {
    val s = Solution()
    println(s.reverseWords1("the sky is blue"))
}