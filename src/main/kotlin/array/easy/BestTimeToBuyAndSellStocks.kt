package array.easy

fun maxProfit1(prices: IntArray): Int {
    var minPrice = Int.MAX_VALUE
    var maxProfit = 0

    prices.forEach { price ->
        minPrice = minOf(minPrice, price)
        maxProfit = maxOf(maxProfit, price - minPrice)
    }

    return maxProfit
}

fun maxProfit(prices: IntArray): Int {
    if (prices.size < 2) return 0

    var minPrice = prices[0]
    var maxProfit = 0

    for (i in 1 until prices.size) {
        if (prices[i] < minPrice) {
            minPrice = prices[i]
        } else {
            val currentProfit = prices[i] - minPrice
            if (currentProfit > maxProfit) {
                maxProfit = currentProfit
            }
        }
    }

    return maxProfit
}

fun main() {
    val res = maxProfit(intArrayOf(7, 1, 5, 3, 6, 4))
    println(res)
}