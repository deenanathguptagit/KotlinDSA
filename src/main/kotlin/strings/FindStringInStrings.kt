package strings

fun main() {
    val strings = "I am Deenanath a Senior Software Engineer, working for Music Tribe"
    val str = "music"
    var status = false
    for (s in strings.split(" ")) {
        status = checkString(str, s)
        if(status) {
            break
        }
    }

    print(status)
}

fun checkString(str: String, s2: String): Boolean {
    if (str.length != s2.length) return false

    for (i in str.indices) {
        if (str[i].lowercase() != s2[i].lowercase()) {
            return false
        }
    }
    return true
}
