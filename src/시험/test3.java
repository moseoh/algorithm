package src.시험;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * test3
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-08
 */
public class test3 {
    public static void main(String[] args) {
        String s = "one4seveneight";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public int solution(String s) {
            s = s.replace("zero", "0");
            s = s.replace("one", "1");
            s = s.replace("two", "2");
            s = s.replace("three", "3");
            s = s.replace("four", "4");
            s = s.replace("five", "5");
            s = s.replace("six", "6");
            s = s.replace("seven", "7");
            s = s.replace("eight", "8");
            s = s.replace("nine", "9");
            System.out.println(s);

            return Integer.parseInt(s);
        }
    }
}
