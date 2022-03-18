package src.programmers.SummerCoding2018.level2;

/**
 * 배달
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-22
 */
public class 배달 {
    public static void main(String[] args) {
//        int N = 5;
//        int[][] road = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
//        int K = 3;

        int N = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
        int K = 4;

        System.out.println(new Solution().solution(N, road, K));
    }

    static class Solution {
        int[][] length;
        int range;
        boolean[] canVisited;

        public int solution(int N, int[][] roads, int K) {
            length = new int[51][51];
            int answer = 0;
            canVisited = new boolean[51];

            for (int[] road : roads) {
                int num;
                if (road[0] > road[1]) {
                    num = length[road[1]][road[0]];
                    if (num == 0 || num > road[2])
                        length[road[1]][road[0]] = road[2];
                } else {
                    num = length[road[0]][road[1]];
                    if (num == 0 || num > road[2])
                        length[road[0]][road[1]] = road[2];
                }
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < length.length; i++) {
                for (int k = 1; k < length[i].length; k++) {
                    if (length[i][k] != 0)
                        sb.append("[").append(i).append("]")
                                .append("[").append(k).append("]")
                                .append(" = ").append(length[i][k]).append("\n");
                }
            }
            System.out.println(sb);

            checkVisitable(1, K);
            for(boolean b: canVisited) {
                if(b) answer++;
            }

            return answer;
        }

        public void checkVisitable(int index, int K) {
            if (range > K) return;
            canVisited[index] = true;
            for (int i = 1; i < length[index].length; i++) {
                if(length[index][i] != 0) {
                    range += length[index][i];
                    checkVisitable(i, K);
                    range -= length[index][i];
                }
            }
        }
    }
}
