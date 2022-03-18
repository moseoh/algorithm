package src.programmers.스킬체크2;
// 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다.
// 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다.
// n개의 숫자를 담은 배열 arr 이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution 을 완성해 주세요.
//
//        제한 사항
//        arr 은 길이 1이상, 15이하인 배열입니다.
//        arr 의 원소는 100 이하인 자연수입니다.
//        입출력 예
//        arr	result
//        [2,6,8,14]	168
//        [1,2,3]	6

public class First {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(new Solution21().solution(arr));
    }
}

class Solution21 {
    public int solution(int[] arr) {
        int answer = 1;

        for(int i: arr){
            System.out.println(i);
        }

        for (int i = 0; i < arr.length; i++) {
            for(int j =0; j< arr.length; j++){
                if(i==j) continue;
                if(i!=1 && arr[j] % arr[i] == 0){
                    arr[j] = arr[j] / arr[i];
                }
            }
        }

        for(int i : arr){
            answer *= i;
        }

        for(int i: arr){
            System.out.println(i);
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}