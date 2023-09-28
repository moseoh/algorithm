package src.programmers.level3.순위

fun main() {
    fun printResult(index: Int, result: Int, answer: Int) {
        val correct = result == answer
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result).append("\n")
        sb.append("\t- 기댓값: \t").append(answer).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val n1 = 5
    val results1 = arrayOf(
        intArrayOf(4, 3),
        intArrayOf(4, 2),
        intArrayOf(3, 2),
        intArrayOf(1, 2),
        intArrayOf(2, 5)
    )
    val answer1 = 2
    val result1 = Solution().solution(n1, results1)
    printResult(1, result1, answer1)

    val n2 = 5
    val results2 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(4, 5),
        intArrayOf(3, 4),
        intArrayOf(2, 3),
    )
    val answer2 = 5
    val result2 = Solution().solution(n2, results2)
    printResult(2, result2, answer2)
}

class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        val map = mutableMapOf<Int, Player>()

        for (result in results) {
            val winIndex = result[0]
            val loseIndex = result[1]

            val winPlayer = map.getOrDefault(winIndex, Player(winIndex))
            val losePlayer = map.getOrDefault(loseIndex, Player(loseIndex))
            winPlayer.addWinPlayer(losePlayer)
            losePlayer.addLosePlayer(winPlayer)

            map[winIndex] = winPlayer
            map[loseIndex] = losePlayer
        }

        println(map)

        return map.count { it.value.getCount() == n - 1 }
    }

    class Player(
        val index: Int,
    ) {
        private var winPlayers = mutableSetOf<Player>()
        private var losePlayers = mutableSetOf<Player>()

        fun addWinPlayer(winPlayer: Player) {
            winPlayers.add(winPlayer)
            winPlayer.winPlayers.forEach {
                winPlayers.add(it)
                it.addLosePlayer(this)
            }
        }

        fun addLosePlayer(losePlayer: Player) {
            losePlayers.add(losePlayer)
            losePlayer.losePlayers.forEach {
                losePlayers.add(it)
                it.addWinPlayer(this)
            }
        }

        fun getCount(): Int {
            return winPlayers.size + losePlayers.size
        }

        override fun equals(other: Any?): Boolean {
            if (this === other) return true
            if (javaClass != other?.javaClass) return false

            other as Player

            return index == other.index
        }

        override fun hashCode(): Int {
            return index
        }

        override fun toString(): String {
            val winPlayerIndex = winPlayers.map { it.index }
            val losePlayerIndex = losePlayers.map { it.index }
            return "Player(index=$index, winPlayers=$winPlayerIndex, losePlayers=$losePlayerIndex)"
        }


    }
}