package src.programmers.SummerCoding2018.level2;

/**
 * 점프와순간이동
 * https://programmers.co.kr/learn/courses/30/lessons/12980
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-28
 */
public class 점프와순간이동 {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(new Solution().solution(n));
    }

    static class Solution {
        public int solution(int n) {
            int ans = 0;
            int num = n;

            while(num != 0){
                ans = ans + (num % 2);
                num = num / 2;
            }

            return ans;
        }

    }


}
