package src.programmers.archive.springstartup2023.num2

fun main(args: Array<String>) {
    val grid = arrayOf(".....####", "..#...###", ".#.##..##", "..#..#...", "..#...#..", "...###...")
    println(Solution2().solution(grid))
}


class Solution2 {
    fun solution(grid: Array<String>): Int {
        val gridArray = grid.map { it.toCharArray() }.toTypedArray()
        val renewGrid = gridArray.mapIndexed { indexY, chars ->
            chars.mapIndexed { indexX, char ->
                if (isBlock(gridArray, indexX, indexY)) '#' else '-'
            }.joinToString(separator = "")
        }.toTypedArray()
        println()


//        grid.forEach {
//            println(it)
//        }
//        println()
//        renewGrid.forEach {
//            println(it)
//        }

        return 0
    }

    private fun isBlock(grid: Array<CharArray>, indexX: Int, indexY: Int): Boolean {
        if (indexY == 3) {
            println()
            grid.forEach {
                println(it)
            }
        }
        if (grid[indexY][indexX] == '#') return true
        // 오른쪽
        for (i in indexX until grid[indexY].size) {
            if (grid[indexY][i] == '#') break
            if (grid[indexY][i] == '-') {
                grid[indexY][i] = '-'
                return false
            }
            if (i == grid[indexY].size - 1) return false
        }

        // 왼쪽
        for (i in indexX downTo 0) {
            if (grid[indexY][i] == '#') break
            if (grid[indexY][i] == '-') {
                grid[indexY][i] = '-'
                return false
            }
            if (i == 0) return false
        }

        // 위
        for (i in indexY until grid.size) {
            if (grid[i][indexX] == '#') break
            if (grid[i][indexX] == '-') {
                grid[i][indexX] = '-'
                return false
            }
            if (i == grid.size - 1) return false
        }

        // 아래
        for (i in indexY downTo 0) {
            if (grid[indexY][i] == '#') break
            if (grid[indexY][i] == '-') {
                grid[indexY][i] = '-'
                return false
            }
            if (i == 0) return false
        }

        return true
    }
}