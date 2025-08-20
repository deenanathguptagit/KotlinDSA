package corotuine_work

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.flow
import kotlin.system.measureTimeMillis

//fun main() = runBlocking {
//    println(summaryRanges(intArrayOf(0,2,3,4,6,8,9)))
//}


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

suspend fun doWork(name: String) {
    for (i in 1..5) {
        println("Coroutine $name is working on iteration $i")
        yield() // Give other coroutines a chance to run
    }
}

fun main() = runBlocking {
    val job1 = launch { doWork("A") }
    val job2 = launch { doWork("B") }

    val xx: Job = async {
        10
    }

    job1.join()
    job2.join()
}