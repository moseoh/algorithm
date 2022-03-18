package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Temp2
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-27
 */
public class Temp2 {

    static class Solution {
        public String[] solution(String s) {
            List<String> list = new ArrayList<>();

            int n = 0;
            while (s.length() != 0) {
                char first = s.charAt(0);
                int index = -1;
                for (int i = s.length() - 1; i >= 0; i--) {
                    if (first == s.charAt(i)) {
                        index = i;
                        break;
                    }
                }

                int length = s.length() - index;
                if (s.substring(0, length).equals(s.substring(index))) {
                    list.add(s.substring(index));
                    s = s.substring(0, index);
                    n++;

                    if (s.length() == 0) break;

                    s = s.substring(length);
                    n++;
                }
            }
            String[] answer = new String[n];
            for (int i = 0; i < (n + 1) / 2; i++) {
                String temp = list.get(i);
                answer[i] = temp;
                answer[n - i - 1] = temp;
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "abcxyqwertyxyabc";
        System.out.println(solution.solution(s));
    }
}
