package src.programmers.kakao2023.이모티콘할인행사

fun main(args: Array<String>) {
    val users = arrayOf(
        intArrayOf(40, 2900),
        intArrayOf(23, 10000),
        intArrayOf(11, 5200),
        intArrayOf(5, 5900),
        intArrayOf(40, 3100),
        intArrayOf(27, 9200),
        intArrayOf(32, 6900)
    )
    val emoticons = intArrayOf(1300, 1500, 1600, 4900)

//    val users = arrayOf(
//        intArrayOf(40, 10000),
//        intArrayOf(25, 10000),
//    )
//    val emoticons = intArrayOf(7000, 9000)
    println(Solution().solution(users, emoticons).contentToString())
}

class Solution {
    private val discountRate = intArrayOf(10, 20, 30, 40)
    private val cases: MutableList<IntArray> = mutableListOf()

    fun solution(users: Array<IntArray>, emoticons: IntArray): IntArray {
        val answer: IntArray = intArrayOf(0, 0)

        discountDFS(IntArray(emoticons.size), emoticons)

        cases.forEach { case ->
            var emoticonPlusCount = 0
            var paymentAmount = 0;
            users.forEach { user ->
                var userPaymentAmount = 0
                case.forEachIndexed { index, c ->
                    if (user[0] <= c) userPaymentAmount += emoticons[index] / 100 * (100 - c)
                }
                if (userPaymentAmount >= user[1]) emoticonPlusCount++
                else paymentAmount += userPaymentAmount
            }

            if (answer[0] <= emoticonPlusCount && answer[1] < paymentAmount) {
                answer[0] = emoticonPlusCount
                answer[1] = paymentAmount
            } else if (answer[0] < emoticonPlusCount) {
                answer[0] = emoticonPlusCount
                answer[1] = paymentAmount
            }
        }

        return answer
    }

    private fun discountDFS(case: IntArray, emoticons: IntArray, index: Int = 0) {
        if (index == emoticons.size) {
            cases.add(case.copyOf())
            return
        }
        for (i in discountRate.indices) {
            case[index] = discountRate[i]
            discountDFS(case, emoticons, index + 1)
        }
    }
}