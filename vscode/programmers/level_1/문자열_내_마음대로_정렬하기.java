package programmers.level_1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class 문자열_내_마음대로_정렬하기 {
    public static void main(String[] args) {
        String[] strings = { "abce", "abcd", "cdx" };
        int n = 2;

        System.out.println(Arrays.toString(new Solution().solution(strings, n)));
    }

    static class Solution {
        public String[] solution(String[] strings, int n) {
            Arrays.sort(strings, new Comparator<String>() {
                public int compare(String o1, String o2) {
                    if (o1.charAt(n) > o2.charAt(n)) {
                        return 1;
                    }

                    if (o1.charAt(n) == o2.charAt(n)) {
                        return o1.compareTo(o2);
                    }

                    return -1;
                };
            });

            return strings;
        }
    }
}
