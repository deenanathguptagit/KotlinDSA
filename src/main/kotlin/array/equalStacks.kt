package array

fun equalStacks(h1: Array<Int>, h2: Array<Int>, h3: Array<Int>): Int {
    // Write your code here
    var maxHeight = 0
    val stack1 = ArrayDeque<Int>()
    val stack2 = ArrayDeque<Int>()
    val stack3 = ArrayDeque<Int>()

    fillStack(stack1, h1, stack2, h2, stack3, h3)

    while (stack1.isNotEmpty() && stack2.isNotEmpty() && stack3.isNotEmpty()) {
        val s1 = stack1.last()
        val s2 = stack2.last()
        val s3 = stack3.last()

        if (s1 == s2 && s1 == s3) {
            maxHeight = s1
            break
        }

        if (stack1.last() > stack2.last() && stack1.last() > stack3.last()) {
            stack1.removeLast()
        }
        if (stack2.last() > stack1.last() && stack2.last() > stack3.last()) {
            stack2.removeLast()
        }

        if (stack3.last() > stack1.last() && stack3.last() > stack1.last()) {
            stack3.removeLast()
        }

    }

    return maxHeight
}

fun fillStack(
    stack1: ArrayDeque<Int>,
    h1: Array<Int>,
    stack2: ArrayDeque<Int>,
    h2: Array<Int>,
    stack3: ArrayDeque<Int>,
    h3: Array<Int>
) {
    var i = h1.size - 1
    var sum = 0
    while (i >= 0) {
        sum += h1[i]
        stack1.addLast(sum)
        i--
    }
    i = h2.size - 1
    sum = 0
    while (i >= 0) {
        sum += h2[i]
        stack2.addLast(sum)
        i--
    }
    i = h3.size - 1
    sum = 0
    while (i >= 0) {
        sum += h3[i]
        stack3.addLast(sum)
        i--
    }
}

fun main() {
    val h1 = arrayOf(3, 2, 1, 1, 1)
    val h2 = arrayOf(4, 3, 2)
    val h3 = arrayOf(1, 1, 4, 1)

    val result = equalStacks(h1, h2, h3)
    println(result)
}
