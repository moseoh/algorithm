package test.dev_matching;

import java.util.*;

public class test2 {

    public static void main(String[] args) {
        int n = 8;
        int k = 4;
        int a = 0;
        int b = 3;
        int[][] edges = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 4, 0 }, { 5, 1 }, { 6, 1 }, { 7, 2 }, { 7, 3 },
                { 4, 5 }, { 5, 6 }, { 6, 7 } };
        new Solution().solution(n, edges, k, a, b);
    }

    static class Solution {
        boolean[] pass;
        Map<Integer, Set<Integer>> way = new HashMap<>();

        public int solution(int n, int[][] edges, int k, int a, int b) {
            pass = new boolean[n];

            for (int i = 0; i < edges.length; i++) {
                if (way.containsKey(edges[i][0])) {
                    way.get(edges[i][0]).add(edges[i][1]);
                } else {
                    Set<Integer> temp = new HashSet<>();
                    temp.add(edges[i][1]);
                    way.put(edges[i][0], temp);
                }

                if (way.containsKey(edges[i][1])) {
                    way.get(edges[i][1]).add(edges[i][0]);
                } else {
                    Set<Integer> temp = new HashSet<>();
                    temp.add(edges[i][0]);
                    way.put(edges[i][1], temp);
                }
            }

            goWay(b, new HashSet<>(), a, k);

            int answer = 0;
            for (int i = 0; i < edges.length; i++) {
                if (pass[edges[i][0]] && pass[edges[i][1]]) {
                    answer++;
                }
            }
            System.out.println(answer);
            System.out.println(Arrays.toString(pass));
            return answer;
        }

        public void goWay(int index, Set<Integer> passedWay, int goal, int limit) {
            if (index == goal && passedWay.size() <= limit) {
                for (int passed : passedWay) {
                    pass[passed] = true;
                }
            }

            passedWay.add(index);
            for (int nextIndex : way.get(index)) {
                if (!passedWay.contains(nextIndex)) {
                    goWay(nextIndex, passedWay, goal, limit);
                }
            }
            return;
        }
    }
}
