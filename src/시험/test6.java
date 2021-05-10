package src.시험;

import src.programmers.완전탐색.소수찾기Kt;

/**
 * test6
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-08
 */
public class test6 {
    public static void main(String[] args) {
        int n = 4;
        int start = 1;
        int end = 4;
        int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
        int[] traps = {2, 3};
        System.out.println(new Solution().solution(n, start, end, roads, traps));
    }

    static class Solution {
        boolean[] isActivateTrap;
        boolean[] isVisited;

        public int solution(int n, int start, int end, int[][] roads, int[] traps) {
            int answer = 0;
            isActivateTrap = new boolean[n];
            isVisited = new boolean[n];

            for(int i = 0 ; i < roads.length; i++) {
                if(roads[i][0] == start) start = roads[i][1];
            }



            return answer;
        }
    }
}
