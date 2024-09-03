package src.programmers.level2.PCCP_기출문제_2번__석유_시추;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] land1 = new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}};
        int answer1 = 9;
        int result1 = new Solution().solution(land1);
        PRINT_RESULT(1, result1, answer1);

        int[][] land2 = new int[][]{{1, 0, 1, 0, 1, 1}, {1, 0, 1, 0, 0, 0}, {1, 0, 1, 0, 0, 1}, {1, 0, 0, 1, 0, 0}, {1, 0, 0, 1, 0, 1}, {1, 0, 0, 0, 0, 0}, {1, 1, 1, 1, 1, 1}};
        int answer2 = 16;
        int result2 = new Solution().solution(land2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public final int[] DX = {0, 1, 0, -1};
    public final int[] DY = {1, 0, -1, 0};

    public int solution(int[][] land) {
        int[] sumAreas = new int[land[0].length];
        int max = 0;

        for (int i = 0; i < land.length; i++) {
            for (int k = 0; k < land[i].length; k++) {
                if (land[i][k] == 0) {
                    continue;
                }

                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, k});
                Set<Integer> nums = new HashSet<>();
                int area = 0;
                while (!queue.isEmpty()) {
                    int[] point = queue.poll();
                    if (land[point[0]][point[1]] == 0) {
                        continue;
                    }

                    area++;
                    nums.add(point[1]);
                    land[point[0]][point[1]] = 0;

                    for (int z = 0; z < 4; z++) {
                        int nextX = point[0] + DX[z];
                        int nextY = point[1] + DY[z];
                        if (nextX < 0 || nextX >= land.length || nextY < 0 || nextY >= land[0].length) {
                            continue;
                        }
                        if (land[nextX][nextY] == 0) {
                            continue;
                        }

                        queue.add(new int[]{nextX, nextY});
                    }
                }

                for (int num : nums) {
                    sumAreas[num] += area;
                    if (sumAreas[num] > max) {
                        max = sumAreas[num];
                    }
                }
            }
        }

        return max;
    }
}