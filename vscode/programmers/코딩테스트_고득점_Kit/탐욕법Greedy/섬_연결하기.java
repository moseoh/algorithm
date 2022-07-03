package programmers.코딩테스트_고득점_Kit.탐욕법Greedy;

import java.util.Arrays;

public class 섬_연결하기 {
    public static void main(String[] args) {
        int n = 4;
        // int[][] costs = { { 0, 1, 1 }, { 0, 2, 2 }, { 1, 2, 5 }, { 1, 3, 1 }, { 2, 3,
        // 8 } };
        int[][] costs = {
                { 0, 1, 1 },
                { 0, 3, 3 },
                { 0, 4, 2 },
                { 1, 2, 5 },
                { 1, 4, 1 },
                { 2, 3, 1 },
                { 3, 4, 2 },
        };

        Solution s = new Solution();
        System.out.println(s.solution(n, costs));
    }

    static class Solution {

        public int findParent(int[] parent, int node) {
            if (parent[node] == node)
                return node;
            return findParent(parent, parent[node]);
        }

        public void union(int[] parent, int node1, int node2) {
            int p1 = findParent(parent, node1);
            int p2 = findParent(parent, node2);

            if (p1 < p2)
                parent[p2] = p1;
            else
                parent[p1] = p2;
        }

        public int solution(int n, int[][] costs) {
            int answer = 0;
            int[] parent = new int[n];

            for (int i = 0; i < parent.length; i++)
                parent[i] = i;

            Arrays.sort(costs, (a, b) -> (a[2] - b[2]));

            for (int i = 0; i < costs.length; i++) {
                if (findParent(parent, costs[i][0]) != findParent(parent, costs[i][1])) { // 사이클 판단
                    answer += costs[i][2];
                    union(parent, costs[i][0], costs[i][1]);
                }
            }
            return answer;
        }
    }
}
