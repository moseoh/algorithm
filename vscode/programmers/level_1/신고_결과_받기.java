package programmers.level_1;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        String[] id_list = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;

        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(id_list, report, k)));
    }

    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            Map<String, Set<String>> reportMap = new HashMap<>();
            Map<String, Integer> reportedMap = new HashMap<>();

            for (String id : id_list) {
                reportedMap.put(id, 0);
                reportMap.put(id, new HashSet<>());
            }

            for (String r : report) {
                StringTokenizer st = new StringTokenizer(r, " ");
                String reporter = st.nextToken();
                String reported = st.nextToken();

                if (reportMap.get(reporter).add(reported)) {
                    reportedMap.put(reported, reportedMap.get(reported) + 1);
                }
            }

            for (String r : report) {
                StringTokenizer st = new StringTokenizer(r, " ");
                String reporter = st.nextToken();
                String reported = st.nextToken();

                if (reportedMap.get(reported) < k) {
                    reportMap.get(reporter).remove(reported);
                }
            }

            for (int i = 0; i < id_list.length; i++) {
                answer[i] = reportMap.get(id_list[i]).size();
            }

            return answer;
        }
    }
}
