package array

fun main() {
    val input = intArrayOf(2,4,1)
    println(maxProfit(input))
}

fun maxProfit(prices: IntArray): Int {
    //first select lowest number index to buy the stock
    var buy = Integer.MAX_VALUE
    var index = 0
    for (i in prices.indices) {
        buy = Math.min(buy, prices[i])
    }
    var selling = 0

    for (i in prices.indices) {
        if (prices[i] == buy) {
            index = i
        }
    }

    for (i in index..<prices.size) {
        selling = maxOf(selling, prices[i])
    }
    return selling - buy
}