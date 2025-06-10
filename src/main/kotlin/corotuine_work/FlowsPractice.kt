package corotuine_work

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlin.system.measureTimeMillis

fun containsDuplicate(nums: IntArray): Boolean {
    nums.sort()
    var j = 0
    for (i in 1 until nums.size) {
        if (nums[i] == nums[j]) {
            return true
        }
        j++
    }
    return false
}

fun get95Percent(value: Double): Double {
    require(value in 0.0..1.0) { "Value must be between 0.0 and 1.0" }
    return value * 0.98
}

fun summaryRanges(nums: IntArray): List<String> {
    val list = mutableListOf<String>()
    var index = 0
    while (index < nums.size) {
        var current = index
        var next = if(current < nums.size - 1) current + 1 else current
        println("$current $next")
        while (nums[next]-nums[current] == 1) {
            next++
            current++
        }
        if(next > current) {
            list.add("${nums[index]}->${nums[next-1]}")
            index = next
        } else {
            list.add("${nums[index]}->${nums[index]}")
            index++
        }
    }
    return list
}


fun main() = runBlocking {
    println(summaryRanges(intArrayOf(0,2,3,4,6,8,9)))
}

fun isSubsequence(s: String, t: String): Boolean {
    s.toCharArray().sort()
    t.toCharArray().sort()

    return true
}

suspend fun exprement() {
    CoroutineScope(Dispatchers.IO).launch {
        println(Thread.currentThread().name)
    }
}

private fun getUserData() = flow<String> {
    repeat(5) {
        delay(1000)
        emit(getUser(it))
    }
}

private fun getUser(id: Int): String {
    return "User $id"
}