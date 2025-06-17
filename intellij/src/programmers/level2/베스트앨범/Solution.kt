package src.programmers.level2.베스트앨범

fun main() {
    fun printResult(index: Int, result: IntArray, answer: IntArray) {
        val correct = result.contentEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val genres1 = arrayOf("classic", "pop", "classic", "classic", "pop", "jazz", "aaa")
    val plays1 = intArrayOf(500, 600, 150, 800, 2500, 1, 1)
    val answer1 = intArrayOf(4, 1, 3, 0, 6, 5)
    val result1 = Solution().solution(genres1, plays1)
    printResult(1, result1, answer1)
}

class Solution {
    companion object {
        const val BEST_ALBUM_MAX_SONG_COUNT = 2
    }

    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        if (genres.size != plays.size) throw IllegalArgumentException()

        val albumMap = mutableMapOf<String, Album>()
        for (i in plays.indices) {
            val album = albumMap.getOrDefault(genres[i], Album(genres[i]))
            albumMap[genres[i]] = album.addSong(Song(i, genres[i], plays[i]));
        }

        val answer = mutableListOf<Int>()
        for (album in albumMap.values.sorted()) {
            for (song in album.songs.sorted().take(BEST_ALBUM_MAX_SONG_COUNT)) {
                answer.add(song.id)
            }
        }

        return answer.toIntArray()
    }

    data class Album(
        val genre: String,
        val songs: MutableList<Song> = mutableListOf(),
        val totalPlay: Int = 0,
    ) : Comparable<Album> {
        override fun compareTo(other: Album): Int {
            return if (this.totalPlay == other.totalPlay) this.genre.compareTo(other.genre)
            else other.totalPlay - this.totalPlay
        }

        fun addSong(song: Song): Album {
            songs.add(song)
            return this.copy(totalPlay = totalPlay + song.play)
        }

    }

    data class Song(
        val id: Int,
        val genre: String,
        val play: Int,
    ) : Comparable<Song> {
        override fun compareTo(other: Song): Int {
            return if (this.play == other.play) this.id.compareTo(other.id)
            else other.play - this.play
        }
    }
}