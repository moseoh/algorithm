package src.programmers.Level2.메뉴리뉴얼;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (String order : orders) {
            for (char o : order.toCharArray()) {
                map.put(o, map.getOrDefault(o, 0) + 1);
            }
        }
        System.out.println(map);

        for (String order : orders) {
            StringBuilder sb = new StringBuilder();
            for (char o : order.toCharArray()) {
                if (map.getOrDefault(o, 0) > 0) {
                    sb.append(o);
                }
            }
            for (int c : course) {
                if (c == sb.length()) {
                    answer.add(sb.toString());
                    break;
                }
            }
        }
        answer.sort(Comparator.naturalOrder());
        return answer.toArray(String[]::new);
    }
}
