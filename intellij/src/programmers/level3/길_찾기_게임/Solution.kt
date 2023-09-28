package src.programmers.level3.길_찾기_게임


fun main() {
    fun printResult(index: Int, result: Array<IntArray>, answer: Array<IntArray>) {
        val correct = result.contentDeepEquals(answer)
        val sb = StringBuilder()
        sb.append("\n\n테스트 케이스 ").append(index).append(": ")
        sb.append(if (correct) "정답" else "오답").append("\n")
        sb.append("\t- 실행 결과: \t").append(result.contentDeepToString()).append("\n")
        sb.append("\t- 기댓값: \t").append(answer.contentDeepToString()).append("\n")
        if (correct) println(sb) else throw RuntimeException(sb.toString())
    }

    val nodeinfo1 = arrayOf(
        intArrayOf(5, 3),
        intArrayOf(11, 5),
        intArrayOf(13, 3),
        intArrayOf(3, 5),
        intArrayOf(6, 1),
        intArrayOf(1, 3),
        intArrayOf(8, 6),
        intArrayOf(7, 2),
        intArrayOf(2, 2)
    )
    val answer1 =
        arrayOf(intArrayOf(7, 4, 6, 9, 1, 8, 5, 2, 3), intArrayOf(9, 6, 5, 8, 1, 4, 3, 2, 7))
    val result1 = Solution().solution(nodeinfo1)
    printResult(1, result1, answer1)
}

class Solution {
    lateinit var result: Array<IntArray>
    var idx = 0

    fun solution(nodeinfo: Array<IntArray>): Array<IntArray> {
        val node = nodeinfo.mapIndexed { index, info ->
            Node(info[0], info[1], index + 1)
        }.sortedWith(compareByDescending<Node> { it.y }.thenBy { it.x })

        println(node)

        val root = node[0]
        for (i in 1 until node.size) {
            insertNode(root, node[i])
        }
        result = Array(2) { IntArray(nodeinfo.size) }
        idx = 0
        preorder(root)
        idx = 0
        postorder(root)
        return result
    }

    private fun insertNode(parent: Node, child: Node) {
        if (parent.x > child.x) {
            if (parent.left == null) parent.left = child
            else insertNode(parent.left!!, child)
        } else {
            if (parent.right == null) parent.right = child
            else insertNode(parent.right!!, child)
        }
    }

    private fun preorder(root: Node?) {
        if (root != null) {
            result[0][idx++] = root.value
            preorder(root.left)
            preorder(root.right)
        }
    }

    private fun postorder(root: Node?) {
        if (root != null) {
            postorder(root.left)
            postorder(root.right)
            result[1][idx++] = root.value
        }
    }


    class Node(
        val x: Int,
        val y: Int,
        val value: Int,
        var left: Node? = null,
        var right: Node? = null
    ) {
        override fun toString(): String {
            return "Node(x=$x, y=$y, value=$value)"
        }
    }

}