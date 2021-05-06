package src.programmers.DevMatching2021;

import java.util.*;

/**
 * 행렬테두리회전하기
 * https://programmers.co.kr/learn/courses/30/lessons/77485
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-26
 */
public class 행렬테두리회전하기 {
    public static void main(String[] args) {
        int rows = 6;
        int columns = 6;
        int[][] queries = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};

        System.out.println(Arrays.toString(new Solution().solution(rows, columns, queries)));
    }

    static class Solution {
        static int[][] matrix;
        public int[] solution(int rows, int columns, int[][] queries) {
            matrix = makeMatrix(rows, columns);

            print(matrix);

            int[] answer = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                answer[i] = runRotation(queries[i]);

                print(matrix);
            }

            return answer;
        }

        static int runRotation(int[] query) {
            Queue<Integer> que = new LinkedList<>();
            int min = Integer.MAX_VALUE;

            // que 저장, min 저장
            for (int i = query[1]; i < query[3]; i++) {
                min = Math.min(min, matrix[query[0]][i]);
                que.offer(matrix[query[0]][i]);
            }

            for (int i = query[0]; i < query[2]; i++) {
                min = Math.min(min, matrix[i][query[3]]);
                que.offer(matrix[i][query[3]]);
            }

            for (int i = query[3]; i > query[1]; i--) {
                min = Math.min(min, matrix[query[2]][i]);
                que.offer(matrix[query[2]][i]);
            }

            for (int i = query[2]; i > query[0]; i--) {
                min = Math.min(min, matrix[i][query[1]]);
                que.offer(matrix[i][query[1]]);
            }

            // 회전
            for (int i = query[1] + 1; i < query[3]; i++) {
                matrix[query[0]][i] = que.poll();
            }

            for (int i = query[0]; i < query[2]; i++) {
                matrix[i][query[3]] = que.poll();
            }

            for (int i = query[3]; i > query[1]; i--) {
                matrix[query[2]][i] = que.poll();
            }

            for (int i = query[2]; i > query[0]; i--) {
                matrix[i][query[1]] = que.poll();
            }

            matrix[query[0]][query[1]] = que.poll();

            return min;
        }

        static int[][] makeMatrix(int rows, int columns) {
            int[][] matrix = new int[rows + 1][columns + 1];
            int num = 1;
            for (int i = 1; i <= rows; i++) {
                for (int k = 1; k <= columns; k++) {
                    matrix[i][k] = num++;
                }
            }
            return matrix;
        }

        static void print(int[][] matrix) {
            for (int[] a : matrix) {
                for (int b : a)
                    System.out.print(b + "\t");
                System.out.println();
            }
            System.out.println();
        }
    }
}
