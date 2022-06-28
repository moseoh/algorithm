package programmers.코딩테스트_고득점_Kit.깊이_너비_우선탐색;

public class 네트워크 {
    public static void main(String[] args) {
        int[][] computers = {
                { 1, 0, 0, 1, 0 },
                { 0, 1, 0, 0, 1 },
                { 0, 0, 1, 1, 1 },
                { 1, 0, 1, 1, 0 },
                { 0, 1, 1, 0, 1 },
        };
        int n = 5;
        Solution s = new Solution();
        System.out.println(s.solution(n, computers));
    }

    static class Solution {

        public int solution(int n, int[][] computers) {
            int answer = 0;
            boolean[] visited = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    checkNetWork(computers, visited, i);
                    answer++;
                }
            }

            return answer;
        }

        public void checkNetWork(int[][] computers, boolean[] visited, int index) {
            for (int i = 0; i < computers[index].length; i++) {
                if (computers[index][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    if (index != i) {
                        checkNetWork(computers, visited, i);
                    }
                }
            }
        }
    }
}