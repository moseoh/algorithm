package src.programmers.고득점kit.해시.베스트앨범

fun main() {
    val genres1 = arrayOf("classic", "pop", "classic", "classic", "pop")
    val plays1 = intArrayOf(500, 600, 150, 800, 2500)
    check(Solution().solution(genres1, plays1).contentEquals(intArrayOf(4, 1, 3, 0))) { "오답" }
}

class Solution {
    fun solution2(genres: Array<String>, plays: IntArray): IntArray {
        return genres
            // index를 genres별 그룹으로 묶는다. classic=(0, 2, 3), pop=(1, 4)
            .indices.groupBy { genres[it] }.toList()
            // 결과를 내림차순으로 정렬하는데 index를 가져와(it.second) plays의 합으로 정렬한다.
            .sortedByDescending { it.second.sumOf { plays[it] } }
            // 각 장르내에서도 plays 순으로 정렬하고 2개만 가져온다.(take)
            .map { it.second.sortedByDescending { plays[it] }.take(2) }
            // 각각의 정렬된 리스트를 합친다. (flatten)
            .flatten().toList()
            .toIntArray()
    }

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        val musics = genres.indices.map { Music(it, genres[it], plays[it]) }.toTypedArray()
        return musics.groupBy { it.genres }.toList()
            .sortedByDescending { it.second.sumOf { music -> music.plays } }
            .map { it.second.sortedByDescending { music -> music.plays }.take(2) }
            .flatten()
            .map { it.index }
            .toIntArray()
    }

    data class Music(
        val index: Int,
        val genres: String,
        val plays: Int
    )
}
