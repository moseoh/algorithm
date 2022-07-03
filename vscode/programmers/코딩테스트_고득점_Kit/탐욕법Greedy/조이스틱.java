package programmers.코딩테스트_고득점_Kit.탐욕법Greedy;

public class 조이스틱 {
    public static void main(String[] args) {
        // String name = "JEROEN";
        String name = "JAN";
        Solution s = new Solution();
        System.out.println(s.solution(name));
    }

    static class Solution {
        public int solution(String name) {
            int answer = 0;
            int move = name.length() - 1;
            for (int i = 0; i < name.length(); i++) {
                answer += changeAlphabetCount(name.charAt(i));
                int index = i + 1;
                while (index < name.length() && name.charAt(index) == 'A') {
                    index++;
                }
                move = Math.min(move, 2 * i + name.length() - index);
                move = Math.min(move, (name.length() - index) * 2 + i);
            }
            return answer + move;
        }

        public int changeAlphabetCount(char ch) {
            return Math.min(ch - 'A', 'Z' - ch + 1);
        }
    }
}
