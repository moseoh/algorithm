package src.programmers.archive.etc.Level2.올바른괄호;

public class Solution {
    public static void main(String[] args) {
        String s = "(())()";
        System.out.println(solution(s));
    }

    public static boolean solution(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else {
                count--;
            }

            if (count < 0) {
                break;
            }
        }

        return count == 0;
    }
}
