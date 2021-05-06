package src.programmers.SummerCoding2018.level2;

/**
 * 방문길이
 * https://programmers.co.kr/learn/courses/30/lessons/49994
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-22
 */
public class 방문길이 {
    // -5 ~ 5
    public static void main(String[] args) {
        String dirs = "ULURRDLLU";
//        String dirs = "LULLLLLLU";
        System.out.println(new Solution().solution(dirs));
    }

    static class Solution {
        boolean[][] isVisited;
        String dirs;

        public int solution(String dirs) {
            int answer = 0;
            this.dirs = dirs;
            // +5
            isVisited = new boolean[11][11];

            move(0, 0, 0);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < isVisited.length; i++) {
                for (int k = 0; k < isVisited[i].length; k++) {
                    sb.append(isVisited[i][k]).append("\t");
                }
                sb.append("\n");
            }
            System.out.println(sb);

            return answer;
        }

        public void move(int y, int x, int pos) {
            if (pos == dirs.length()) return;
            isVisited[y + 5][x + 5] = true;

            switch (dirs.charAt(pos)) {
                case 'U':
                    if (y + 1 > 5) move(y, x, pos + 1);
                    else move(y + 1, x, pos + 1);
                    break;
                case 'D':
                    if (y - 1 < -5) move(y, x, pos + 1);
                    else move(y - 1, x, pos + 1);
                    break;
                case 'R':
                    if (x + 1 > 5) move(y, x, pos + 1);
                    else move(y, x + 1, pos + 1);
                    break;
                case 'L':
                    if (x - 1 < -5) move(x, y, pos + 1);
                    else move(y, x - 1, pos + 1);
                    break;
            }
        }
    }
}
