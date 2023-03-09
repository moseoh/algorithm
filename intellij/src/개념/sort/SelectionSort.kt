package src.개념.sort

/**
 * 선택 정렬 O(n2)
 *
 * 장점
 * - 구현이 쉬운 편에 속함
 * - 비교하는 횟수는 많으나 실제로 교환하는 횟수는 적어 교환 횟수가 많은 자료상태에서는 비교적으로 효율적임
 *
 * 단점
 * - 데이터를 하나씩 비교하기 때문에 시간이 오래 골림
 * - 정렬된 상태에서 새로운 데이터가 추가 될 경우에 효율이 좋지 않음
 */
class SelectionSort : Sort() {

    override
    fun sort(array: IntArray) {
        for (i in array.indices) {
            var min = i
            for (j in i + 1 until array.size) {
                if (array[min] > array[j]) {
                    min = j
                }
            }
            swap(array, min, i)
        }
    }
}