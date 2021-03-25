package src.programmers.kakao2021.메뉴리뉴얼;

import java.util.*;

class Solution3 {
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        System.out.println(solution(orders, course));
    }

    static List<Map<String, Integer>> FoodMaps = new ArrayList<>();
    static int[] MaxCnt = new int[11]; // 0-10

    public static void comb(char[] str, int position, StringBuilder candidate) {
        if (position >= str.length) {
            int len = candidate.length();
            if (len >= 2) {
                int cnt = FoodMaps.get(len).getOrDefault(candidate.toString(), 0) + 1;
                FoodMaps.get(len).put(candidate.toString(), cnt);
                MaxCnt[len] = Math.max(MaxCnt[len], cnt);
            }
            return;
        }

        comb(str, position + 1, candidate.append(str[position]));
        candidate.setLength(candidate.length() - 1);
        comb(str, position + 1, candidate);
    }

    public static String[] solution(String[] orders, int[] course) {
        for (int i = 0; i <= 10; i++) {
            FoodMaps.add(new HashMap<>());
        }

        for (String order : orders) {
            char[] arr = order.toCharArray();
            Arrays.sort(arr);
            comb(arr, 0, new StringBuilder());
        }

        List<String> list = new ArrayList<>();
        for (int len : course) {
            for (Map.Entry<String, Integer> entry : FoodMaps.get(len).entrySet()) {
                if (entry.getValue() >= 2 && entry.getValue() == MaxCnt[len]) {
                    list.add(entry.getKey());
                }
            }
        }
        Collections.sort(list);
        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
