package strings

fun main() {
    val input = "([])"
//    val res = isValid(input)
//    println(res)

    val stack = ArrayDeque<Char>()
    for (c in input) {
        if (c == '(') {
            stack.add(')')
        } else if (c == '{') {
            stack.add('}')
        } else if (c == '[') {
            stack.add(']')
        } else {
            val match = c == stack.removeLast()
           println("$c $match")
        }
    }
    println("Valid")
}

//fun isValid(input: String):Boolean {
//
//    val stack = ArrayDeque<Char>()
//    val mapping = mapOf(')' to '(', '}' to '{', ']' to '[')
//    for(c in input) {
//        if(mapping.contains(c)) {
//            val top = if (stack.isNotEmpty()) stack.removeLast() else '#'
//            if (top != mapping[c]) return false
//        } else {
//            stack.add(c)
//        }
//    }
//    return stack.isEmpty()
//}

fun isValid(input: String): Boolean {
    val stack = ArrayDeque<Char>()
    val mapping = mapOf('(' to ')', '{' to '}', '[' to ']')

    for (c in input) {
        if (c in mapping.keys) {
            // It's an opening bracket → push its matching closing bracket
            stack.add(mapping[c]!!)
        } else {
            // It's a closing bracket → check if it matches the expected one
            if (stack.isEmpty() || stack.removeLast() != c) {
                return false
            }
        }
    }

    return stack.isEmpty()
}

fun isVowels(c: Char): Boolean {
    val list = listOf('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')
    return list.contains(c)
}