package src.programmers.sort

//H-Index 는 과학자의 생산성과 영향력을 나타내는 지표입니다. 어느 과학자의 H-Index 를 나타내는 값인 h를 구하려고 합니다. 위키백과1에 따르면, H-Index 는 다음과 같이 구합니다.
//
//어떤 과학자가 발표한 논문 n편 중, h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면 h의 최댓값이 이 과학자의 H-Index 입니다.
//
//어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations 가 매개변수로 주어질 때, 이 과학자의 H-Index 를 return 하도록 solution 함수를 작성해주세요.
//
//제한사항
//과학자가 발표한 논문의 수는 1편 이상 1,000편 이하입니다.
//논문별 인용 횟수는 0회 이상 10,000회 이하입니다.
//입출력 예
//citations	return
//[3, 0, 6, 1, 5]	3
//입출력 예 설명
//이 과학자가 발표한 논문의 수는 5편이고, 그중 3편의 논문은 3회 이상 인용되었습니다. 그리고 나머지 2편의 논문은 3회 이하 인용되었기 때문에 이 과학자의 H-Index 는 3입니다.

fun main() {
    val array1 = intArrayOf(3, 0, 6, 1, 5)
    val array2 = intArrayOf(10,8,5,4,3)
    val array3 = intArrayOf(25,8,5,3,3)
    val array4 = intArrayOf(10,50,100)
    val array5 = intArrayOf(7)

    // Solution1().solution(array2)

    println(Solution1().solution2(array1))
}

private class Solution1 {
    fun solution(citations: IntArray): Int {
        var answer = 0
        citations.sort()
        for(i in citations.size-1 downTo 0){
            var count = 0
            for(j in citations.size-1 downTo 0){
                if(citations[i] <= citations[j]) count++
            }
//            println("${citations[i]} -> $count")
//            if(citations[i] == count) {
//                answer = count
//                break
//            }
            if(citations[i] <= count){
                answer = citations[i]
                break
            }
        }

        return answer
    }

    fun solution2(citations: IntArray): Int {
        var answer = 0
        citations.sortDescending()

        for(i in citations.indices) {
            if(i+1 > citations[i]) break
            answer = i+1
        }

        return answer
    }
}