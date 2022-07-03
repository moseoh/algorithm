package programmers.코딩테스트_고득점_Kit.그래프;

import java.util.*;

public class 가장_먼_노드 {
    public static void main(String[] args) {
        int n = 6;
        int[][] edge = { { 3, 6 }, { 4, 3 }, { 3, 2 }, { 1, 3 }, { 1, 2 }, { 2, 4 }, { 5, 2 } };
        Solution s = new Solution();
        System.out.println(s.solution(n, edge));
    }

    static class Solution {
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        int max = 0;

        public int solution(int n, int[][] edge) {
            boolean[] visited = new boolean[n + 1];
            int[] distance = new int[n + 1];

            for (int[] e : edge) {
                int a = Math.min(e[0], e[1]);
                int b = Math.max(e[0], e[1]);

                Set<Integer> temp = nodes.getOrDefault(a, new HashSet<>());
                temp.add(b);
                nodes.put(a, temp);
            }

            Queue<Integer> bfs = new LinkedList<>();
            bfs.add(1);
            visited[1] = true;
            while (bfs.size() != 0) {
                int node = bfs.poll();
                Set<Integer> nextNodes = nodes.get(node);

                if (nextNodes == null) {
                    continue;
                }

                for (int nextNode : nextNodes) {
                    if (!visited[nextNode]) {
                        bfs.add(nextNode);
                        visited[nextNode] = true;
                        distance[nextNode] = distance[node] + 1;
                        max = Math.max(max, distance[nextNode]);
                    }
                }
            }

            return (int) Arrays.stream(distance).filter(t -> t == max).count();
        }
    }
}
