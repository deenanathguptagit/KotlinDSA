package array.easy
/**
 *Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 *
 * */
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