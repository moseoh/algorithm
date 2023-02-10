package src.programmers.archive.SummerCoding2019;

/**
 * 지형이동
 * https://programmers.co.kr/learn/courses/30/lessons/62050
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-27
 */
public class 지형이동 {
    public static void main(String[] args) {
        int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}};
        int height = 3;

        System.out.println(new Solution().solution(land, height));
    }


    static class Solution {
        int[][] groupLand;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        public int solution(int[][] land, int height) {
            int answer = 0;
            groupLand = new int[land.length][land.length];

            grouping(new int[2]);

            return answer;
        }

        public void grouping(int[] index) {

        }
    }
}
