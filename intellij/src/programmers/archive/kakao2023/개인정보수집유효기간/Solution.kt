package src.programmers.archive.kakao2023.개인정보수집유효기간

import java.time.LocalDate
import java.time.format.DateTimeFormatter

fun main(args: Array<String>) {
    val today = "2022.05.19"
    val terms = arrayOf("A 6", "B 12", "C 3")
    val privacies = arrayOf("2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C")
    println(Solution().solution(today, terms, privacies).contentToString())
}

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        val term = getTerms(terms)
        return findExpired(today, term, privacies).toIntArray()
    }

    private fun getTerms(terms: Array<String>): Map<String, Int> {
        val term = mutableMapOf<String, Int>()
        terms.forEach {
            val temp = it.split(" ")
            term[temp[0]] = temp[1].toInt()
        }
        return term
    }

    private fun findExpired(today: String, term: Map<String, Int>, privacies: Array<String>): List<Int> {
        val expired = mutableListOf<Int>()
        val todayDate = parseDate(today)
        privacies.forEachIndexed { index, privacy ->
            val temp = privacy.split(" ")
            val privacyDate = temp[0]
            val privacyTerm = temp[1]
            val privacyPeriod = term[privacyTerm]!!
            if (isExpired(todayDate, privacyDate, privacyPeriod)) {
                expired.add(index + 1)
            }
        }
        return expired
    }

    private fun isExpired(todayDate: LocalDate, privacyDate: String, privacyPeriod: Int): Boolean {
        return !todayDate.isBefore(parseDate(privacyDate).plusMonths(privacyPeriod.toLong()))
    }

    private fun parseDate(date: String): LocalDate {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy.MM.dd"))
    }
}
