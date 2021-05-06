package src.programmers.SummerCoding2018;

/**
 * 소수만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-22
 */
public class 소수만들기 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 7, 6, 4};
        System.out.println(new Solution().solution(nums));
    }

    static class Solution {
        public int solution(int[] nums) {
            int answer = 0;

            for (int i = 0; i < nums.length - 2; i++) {
                for (int j = i + 1; j < nums.length- 1; j++) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (isPrime(nums[i] + nums[j] + nums[k])) answer++;
                    }
                }
            }
            return answer;
        }

        private boolean isPrime ( int num){
            if(num < 2) return false;
            for (int i = 2; i*i <= num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
