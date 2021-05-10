package src.시험2;

/**
 * test3
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-09
 */
public class test3 {
    public static void main(String[] args) {
        int[][] maps = {
                {1, 28, 41, 22, 25, 79, 4},
                {39, 20, 10, 17, 19, 18, 8},
                {21, 4, 13, 12, 9, 29, 19},
                {58, 1, 20, 5, 8, 16, 9},
                {5, 6, 15, 2, 39, 8, 29},
                {39, 7, 17, 5, 4, 49, 5},
                {74, 46, 8, 11, 25, 2, 11}
        };
        int p = 19;
        int r = 6;
        System.out.println(new Solution().solution(maps, p, r));
    }

    static class Solution {
        public int solution(int[][] maps, int p, int r) {
            int answer = -1;
            boolean[][] full = new boolean[maps.length][maps[0].length];
            boolean[][] half = new boolean[maps.length][maps[0].length];

            for(int i = 0 ; i < maps.length; i ++) {
                for(int k = 0 ; k < maps[i].length; k++) {
                    if(maps[i][k] < p) full[i][k] = true;
                    if(maps[i][k] < p/2) half[i][k] = true;
                }
            }

            for(int i = 0 ; i < maps.length; i ++) {
                for(int k = 0 ; k < maps[i].length; k++) {
                    System.out.print(full[i][k] + "\t");
                }
                System.out.println();
            }

            System.out.println();
            System.out.println();

            for(int i = 0 ; i < maps.length; i ++) {
                for(int k = 0 ; k < maps[i].length; k++) {
                    System.out.print(half[i][k] + "\t");
                }
                System.out.println();
            }


            return answer;
        }
    }
}
