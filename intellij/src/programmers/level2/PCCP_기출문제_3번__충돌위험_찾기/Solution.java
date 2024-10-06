package src.programmers.level2.PCCP_기출문제_3번__충돌위험_찾기;

import java.util.*;

class Solution {
    public static void main(String[] args) {
        int[][] points1 = new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes1 = new int[][]{{4, 2}, {1, 3}, {2, 4}};
        int answer1 = 1;
        int result1 = new Solution().solution(points1, routes1);
        PRINT_RESULT(1, result1, answer1);

        int[][] points2 = new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes2 = new int[][]{{4, 2}, {1, 3}, {4, 2}, {4, 3}};
        int answer2 = 9;
        int result2 = new Solution().solution(points2, routes2);
        PRINT_RESULT(2, result2, answer2);

        int[][] points3 = new int[][]{{2, 2}, {2, 3}, {2, 7}, {6, 6}, {5, 2}};
        int[][] routes3 = new int[][]{{2, 3, 4, 5}, {1, 3, 4, 5}};
        int answer3 = 0;
        int result3 = new Solution().solution(points3, routes3);
        PRINT_RESULT(3, result3, answer3);

        int[][] points4 = new int[][]{{1, 1}, {3, 3}, {5, 5}, {2, 2}};
        int[][] routes4 = new int[][]{{1, 3}, {2, 4}, {4, 2}, {3, 1}};
        int answer4 = 0;
        int result4 = new Solution().solution(points4, routes4);
        PRINT_RESULT(4, result4, answer4);
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


    public int solution(int[][] points, int[][] routes) {
        int answer = 0;

        List<Point> pointList = new ArrayList<>();
        for (int[] route : routes) {
            Point point = new Point(points[route[0] - 1]);
            for (int i = 1; i < route.length; i++) {
                point.addTarget(points[route[i] - 1]);
            }
            pointList.add(point);
        }

        Map<String, Integer> map = new HashMap<>();
        boolean canNext = true;
        while (canNext) {
            canNext = false;

            for (Point point : pointList) {
                if (!point.exit) {
                    map.merge(point.getKey(), 1, Integer::sum);
                }
            }

            for (Integer v : map.values()) {
                if (v > 1) {
                    answer++;
                }
            }

            map.clear();

            for (Point point : pointList) {
                if (point.isExit()) {
                    continue;
                }

                point.move();
                canNext = true;
            }
        }

        return answer;
    }

    static class Point {
        int r;
        int c;
        boolean exit;
        Queue<int[]> targets;

        public Point(int[] current) {
            this.r = current[0];
            this.c = current[1];
        }

        public void addTarget(int[] target) {
            if (this.targets == null) {
                this.targets = new LinkedList<>();
            }

            this.targets.add(target);
        }

        public void move() {
            if (targets.isEmpty()) {
                this.exit = true;
                return;
            }

            int[] target = targets.peek();
            if (r != target[0]) {
                if (r > target[0]) {
                    r--;
                } else {
                    r++;
                }
            } else if (c != target[1]) {
                if (c > target[1]) {
                    c--;
                } else {
                    c++;
                }
            } else {
                targets.poll();
                this.move();
            }
        }

        public boolean isExit() {
            return this.exit;
        }

        public String getKey() {
            return r + " " + c;
        }
    }
}