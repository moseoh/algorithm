package src.programmers.고득점kit.해시.위장

fun main() {
    val clothes1 = arrayOf(
        arrayOf("yellow_hat", "headgear"),
        arrayOf("blue_sunglasses", "eyewear"),
        arrayOf("green_turban", "headgear")
    )
    check(Solution().solution(clothes1) == 5) { "오답" }

    val clothes2 =
        arrayOf(arrayOf("crow_mask", "face"), arrayOf("blue_sunglasses", "face"), arrayOf("smoky_makeup", "face"))
    check(Solution().solution(clothes2) == 3) { "오답" }
}

class Solution {
    fun solution2(clothes: Array<Array<String>>): Int {
        return clothes
            .groupBy { it[1] }.values.map { it.size + 1 }
            .reduce(Int::times)
            .minus(1)
    }

    fun solution3(clothes: Array<Array<String>>): Int {
        return clothes.groupBy { it[1] }.values.fold(1) { acc, v -> acc * (v.size + 1) } - 1
    }


    fun solution(clothes: Array<Array<String>>): Int {
        val map = hashMapOf<String, Int>()

        clothes.forEach { (_, kind) ->
            map[kind] = map.getOrDefault(kind, 0) + 1
        }

        var answer = 1
        map.values.forEach { answer *= it + 1 }
        return answer - 1
    }
}
