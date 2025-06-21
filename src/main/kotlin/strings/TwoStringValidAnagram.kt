package strings

fun main() {
    val result = validAnagram("dormitory", "dirty room")
    println(result)
}

fun validAnagram(str1: String, str2: String): Boolean {
//    val set = mutableListOf<Char>()
//
//    for (c in s1) {
//        set.add(c)
//    }
//    for (c in s2) {
//        if (set.contains(c)) {
//            set.remove(c)
//        }
//    }
//
//
//    return set.isEmpty()
    val s1 = str1.lowercase()
    val s2 = str2.lowercase()
    val bucket = IntArray(26)
    for (c in s1) {
        bucket[c - 'a'] = bucket[c - 'a'] + 1
    }

    for (c in s2) {
        if (c != ' ') {
            bucket[c - 'a'] = bucket[c - 'a'] - 1
        }
    }

    for (i in bucket) {
        if (i != 0) return false
    }
    return true
}