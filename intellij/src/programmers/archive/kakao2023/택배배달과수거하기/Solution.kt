package src.programmers.archive.kakao2023.택배배달과수거하기

fun main(args: Array<String>) {
    val cap = 4
    val n = 5
    val deliveries = intArrayOf(1, 0, 3, 1, 2)
    val pickups = intArrayOf(0, 3, 0, 4, 0)
    println(Solution().solution(cap, n, deliveries, pickups))
}

class Solution {
    fun solution(cap: Int, n: Int, deliveries: IntArray, pickups: IntArray): Long {
        var answer: Long = 0
        var deliveryIndex: Int = n
        var pickupIndex: Int = n

        while (true) {
            val deliveryResult = process(cap, deliveries, deliveryIndex)
            val pickResult = process(cap, pickups, pickupIndex)
            deliveryIndex = deliveryResult.second
            pickupIndex = pickResult.second
            val deliveriesLength = deliveryResult.first
            val pickupsLength = pickResult.first

            if (deliveriesLength == 0 && pickupsLength == 0) {
                break
            }
            answer += deliveriesLength.coerceAtLeast(pickupsLength) * 2
        }
        return answer
    }

    private fun process(cap: Int, deliveries: IntArray, index: Int): Pair<Int, Int> {
        var length = 0;
        var nextIndex = index
        var currentCap = 0
        for (i in index downTo 1) {
            if (deliveries[i - 1] == 0) {
                continue
            }

            if (length == 0) {
                length = i
            }

            currentCap += deliveries[i - 1]
            deliveries[i - 1] = 0
            nextIndex = i

            if (currentCap > cap) {
                deliveries[i - 1] = currentCap - cap
                break
            }
        }

        return Pair(length, nextIndex)
    }
}
