package src.programmers.level1.카드뭉치

fun main(args: Array<String>) {
    val cards1 = arrayOf("i", "drink", "water")
    val cards2 = arrayOf("want", "to")
    val goal = arrayOf("i", "want", "to", "drink", "water")
    println(Solution().solution(cards1, cards2, goal))
}

class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var cardIdx1 = 0
        val cardIdx1Max = cards1.size
        var cardIdx2 = 0
        val cardIdx2Max = cards2.size
        for (i in goal.indices) {
            if (cardIdx1 < cardIdx1Max && goal[i] == cards1[cardIdx1]) cardIdx1++
            else if (cardIdx2 < cardIdx2Max && goal[i] == cards2[cardIdx2]) cardIdx2++
            else return "No"
        }
        return "Yes"
    }
}