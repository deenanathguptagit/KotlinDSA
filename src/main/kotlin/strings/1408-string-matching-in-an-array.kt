package strings

fun stringMatching(words: Array<String>): List<String> {
    //brute force
    val result = mutableListOf<String>()
    for(i in 0 until words.size) {
        for(j in 0 until words.size) {
            if(i != j && words[i].contains(words[j])) {
                if(result.contains(words[j]).not()) {
                    result.add(words[j])
                }
            }
        }
    }
    return result
}

fun main() {

}