package src.programmers.archive.toss._3


fun main() {
    val merchantNames = arrayOf(
        "비바리퍼블리",
        "토스커피사일로 베이커리",
        "비바리퍼블리카 식당",
        "토스커피사일",
        "토스커피사일로 베이커",
        "비바리퍼블리카식",
        "토스커피사일로 베이",
        "토스커피사일로&베이커리"
    )
    println(Solution().solution(merchantNames).contentToString())
}

class Solution {
    fun solution(merchantNames: Array<String>): Array<String> {
        val result = mutableListOf<String>()
        merchantNames.sortBy { it.length }

        merchantNames.forEach {
            if (isContain(result, it)) {
                change(result, it)
            } else {
                result.add(it)
            }
        }

        return result.sortedByDescending { it.length }.toTypedArray()
    }

    private fun isMatch(a: String, b: String): Boolean {
        val regex = Regex("[ &().,-]")
        return a.replace(regex, "").startsWith(b.replace(regex, ""))
    }

    private fun isContain(list: List<String>, name: String): Boolean {
        return list.any { isMatch(name, it) }
    }

    private fun change(list: MutableList<String>, name: String) {
        var index = 0
        for (i in list.indices) {
            if (isMatch(name, list[i])) {
                index = i
                break
            }
        }

        val regex = Regex("[&().,-]")
        if (list[index].length <= name.length) {
            if (!list[index].contains(regex) && name.contains(regex)) {
                list[index] = name
            } else if (list[index].length < name.length) {
                list[index] = name
            }
        }
    }
}