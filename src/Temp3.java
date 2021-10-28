package src;

import java.util.ArrayList;
import java.util.List;

/**
 * Temp3
 * 주소
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-07-04
 */
public class Temp3 {
    static class Solution {
        public int solution(String s, String t) {
            int result = -1;

            while (s.contains(t)) {
                int index = s.indexOf(t);
                String front = s.substring(0, index);
                String back = s.substring(index + t.length());
                s = front + back;
                System.out.println(s);
                result++;
            }

            return result == -1 ? result : result + 1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "aaabbb";
        String t = "ab";
        System.out.println(solution.solution(s, t));
    }
}
