package second;

import java.util.*;

public class test1 {

    public static void main(String[] args) {
        String[] goods = { "abcdeabcd", "cdabe", "abce", "bcdeab" };
        System.out.println(Arrays.toString(new Solution().solution(goods)));
    }

    static class Solution {
        public String[] solution(String[] goods) {
            String[] answer = new String[goods.length];

            for (int i = 0; i < goods.length; i++)
                answer[i] = cal(1, i, goods);

            return answer;
        }

        public String cal(int n, int index, String[] goods) {
            if (goods[index].length() == n) {
                return "None";
            }

            Set<String> set = new TreeSet<>();
            String str;
            for (int i = 0; i <= goods[index].length() - n; i++) {
                str = goods[index].substring(i, i + n);

                for (int j = 0; j <= goods.length - 1; j++) {
                    if (j != index)
                        if (goods[j].indexOf(str) >= 0)
                            break;

                    if (j == goods.length - 1) {
                        set.add(str);
                        break;
                    }
                }
            }

            if (set.size() == 0)
                return cal(n + 1, index, goods);

            StringBuilder result = new StringBuilder();
            for (String s : set)
                result.append(s).append(" ");

            return result.toString().trim();
        }
    }
}
