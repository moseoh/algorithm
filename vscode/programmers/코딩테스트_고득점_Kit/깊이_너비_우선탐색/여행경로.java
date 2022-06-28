package programmers.코딩테스트_고득점_Kit.깊이_너비_우선탐색;

import java.util.*;

public class 여행경로 {
    public static void main(String[] args) {
        // String[][] tickets = {
        // { "ICN", "JFK" },
        // { "HND", "IAD" },
        // { "JFK", "HND" },
        // };
        String[][] tickets = {
                { "ICN", "SFO" },
                { "ICN", "ATL" },
                { "SFO", "ATL" },
                { "ATL", "ICN" },
                { "ATL", "SFO" }
        };
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(tickets)));
    }

    static class Solution {
        List<String> routes;

        public String[] solution(String[][] tickets) {
            routes = new ArrayList<>();
            dfs("ICN", "ICN", tickets, new boolean[tickets.length], 0);
            Collections.sort(routes);
            return routes.get(0).split(" ");
        }

        public void dfs(String start, String route, String[][] tickets, boolean[] visited, int count) {
            if (count == tickets.length) {
                routes.add(route);
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (start.equals(tickets[i][0]) && !visited[i]) {
                    visited[i] = true;
                    dfs(tickets[i][1], route + " " + tickets[i][1], tickets, visited, count + 1);
                    visited[i] = false;
                }
            }
        }
    }
}
