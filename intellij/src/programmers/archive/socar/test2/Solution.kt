package src.programmers.archive.socar.test2

fun main(args: Array<String>) {
    val rectangles = arrayOf(
        intArrayOf(0, 2, 1, 3), // A
        intArrayOf(1, 2, 2, 5), // B
        intArrayOf(3, 3, 4, 4), // C
        intArrayOf(4, 1, 6, 3), // D
        intArrayOf(1, 6, 5, 7), // E
        intArrayOf(5, 5, 7, 6), // F
        intArrayOf(5, 8, 6, 10), // G
    )
    println(Solution().solution(rectangles).contentToString())
}

class Solution {
    fun solution(rectangles: Array<IntArray>): Array<String> {
        moveY(rectangles)
        moveX(rectangles)
        return rectangles.map { it.joinToString(" ") }.toTypedArray()
    }

    private fun moveY(rectangles: Array<IntArray>) {
        for (i in rectangles.indices) {
            val blockedList = mutableListOf<IntArray>()
            for (j in rectangles.indices) {
                if (i == j) continue
                if (isYBlock(rectangles[i], rectangles[j]))
                    blockedList.add(rectangles[j])

            }
            val moveY = getMoveToYValue(rectangles[i], blockedList)
            rectangles[i][1] -= moveY
            rectangles[i][3] -= moveY
        }
    }

    private fun getMoveToYValue(currentArray: IntArray, blockedList: List<IntArray>): Int {
        // 막힌 블록이 없다면 Y 축 만큼 이동
        if (blockedList.isEmpty()) return currentArray[1]
        // 막힌 블록중 가장 큰 값까지 이동
        return currentArray[1] - blockedList.maxOf { it[3] }
    }

    // Y 축으로 움직일때 겹치는지 확인
    private fun isYBlock(arr1: IntArray, arr2: IntArray): Boolean {
        // 위에있는건 패스
        if (arr1[3] <= arr2[1]) return false

        if (arr1[0] <= arr2[0] && arr1[2] >= arr2[2]) return true
        if (arr1[0] > arr2[0] && arr1[2] < arr2[2]) return true
        if (arr1[0] > arr2[0] && arr1[0] < arr2[2]) return true
        if (arr1[2] > arr2[0] && arr1[2] < arr2[2]) return true
        return false
    }

    private fun moveX(rectangles: Array<IntArray>) {
        for (i in rectangles.indices) {
            val blockedList = mutableListOf<IntArray>()
            for (j in rectangles.indices) {
                if (i == j) continue
                if (isXBlock(rectangles[i], rectangles[j]))
                    blockedList.add(rectangles[j])

            }
            val moveX = getMoveToXValue(rectangles[i], blockedList)
            rectangles[i][0] -= moveX
            rectangles[i][2] -= moveX
        }
    }

    private fun getMoveToXValue(currentArray: IntArray, blockedList: List<IntArray>): Int {
        // 막힌 블록이 없다면 X 축 만큼 이동
        if (blockedList.isEmpty()) return currentArray[0]
        // 막힌 블록중 가장 큰 값까지 이동
        return currentArray[0] - blockedList.maxOf { it[2] }
    }

    // X 축으로 움직일때 겹치는지 확인
    private fun isXBlock(arr1: IntArray, arr2: IntArray): Boolean {
        // 오른쪽에 있는 건 패스
        if (arr1[2] <= arr2[0]) return false

        if (arr1[1] <= arr2[1] && arr1[3] >= arr2[3]) return true
        if (arr1[1] > arr2[1] && arr1[3] < arr2[3]) return true
        if (arr1[1] > arr2[1] && arr1[1] < arr2[3]) return true
        if (arr1[3] > arr2[1] && arr1[3] < arr2[3]) return true
        return false
    }

}