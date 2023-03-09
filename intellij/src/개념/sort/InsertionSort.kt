package src.개념.sort

/**
 * 삽입 정렬
 * 아직 정렬되지 않은 임의의 데이터를 이미 정렬된 부분의 위치에 삽입해 가며 정렬하는 방식
 * 선택 정렬이나 거품 정렬과 같은 O(n2) 알고리즘에 비교하여 빠르며, 안정 정렬이고 in-place 알고리즘이다.
 *
 * 장점
 * - 가장 간단한 방식의 정렬 알고리즘 이다
 * - 대부분 이미 정렬이 된경우 효율적이다
 *
 * 단점
 * - 자료 이동이 많다
 * - 데이터의 길이가 매우 긴 경우 오래걸린다
 */
class InsertionSort : Sort() {

    override fun sort(array: IntArray) {
        for (i in 1 until array.size) {
            var index = i
            val temp = array[i]
            while (index > 0 && array[index - 1] > temp) {
                array[index] = array[index - 1]
                index--
            }
            array[index] = temp
        }
    }
}