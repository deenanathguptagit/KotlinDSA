package strings

fun main() {
    val str = "deenanath"
    println(removeVowelFromString(str))
}

fun removeVowelFromString(str:String):String {
    val arr = str.toCharArray()
    var start = 0
    var end = str.length-1
    while(start<end) {
        if(isVowel(arr[start])) {
            var counter = start
            for(i in counter..<end){
               arr[counter] = arr[counter+1]
                ++counter
            }
            start++
        } else {
            start++
        }
    }
    return String(arr)
}

//fun totalSteps(nums: IntArray): Int {
//    val stack = ArrayDeque<Pair<Int, Int>>() // Pair(value, steps)
//    var maxSteps = 0
//    stack.addLast(Pair(num[0], 0))
//
//    for (num in nums.size-2..0) {
//        var steps = 0
//        while (stack.isNotEmpty() && num > stack.last().first) {
//            steps = maxOf(steps + 1, stack.removeLast().second)
//        }
//
//        maxSteps = maxOf(maxSteps, steps)
//        stack.addLast(Pair(num, steps))
//    }
//
//    return maxSteps
//}




fun isVowel(char: Char): Boolean {
    return (char == 'a' || char =='A' || char =='e' || char =='E'
            ||char =='o'||char =='O'||char =='u'||char =='U'||char =='i'||char =='I')
}