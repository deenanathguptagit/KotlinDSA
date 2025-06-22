package strings

fun main() {
    println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val frequencyMap = mutableMapOf<String, ArrayList<String>>()
    for (str in strs) {
        val sortedStr = sortString(str)
//        if (frequencyMap.contains(sortedStr)) {
//            frequencyMap[sortedStr]?.add(str)
//        } else {
//            val list = ArrayList<String>()
//            list.add(str)
//            frequencyMap[sortedStr] = list
//        }
        frequencyMap.getOrPut(sortedStr) { ArrayList() }.add(str)
    }
//    val list = mutableListOf<List<String>>()
//    for ((key, value) in frequencyMap) {
//        list.add(value)
//    }
    return frequencyMap.values.toList()
}

fun sortString(str: String): String {
    val charArray = str.toCharArray()
    val size = charArray.size
    for (i in 0 until size - 1) {
        for (j in i + 1 until size) {
            if (charArray[j] < charArray[i]) {
                val temp = charArray[i]
                charArray[i] = charArray[j]
                charArray[j] = temp
            }
        }
    }
    return String(charArray)
}
