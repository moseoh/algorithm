package programmers.level_1;

public class 서울에서_김서방_찾기 {
    public static void main(String[] args) {
        String[] seoul = { "jane", "Kim" };
        System.out.println(new Solution().solution(seoul));
    }

    static class Solution {
        public String solution(String[] seoul) {
            StringBuilder sb = new StringBuilder();
            sb.append("김서방은 ");
            for (int i = 0; i < seoul.length; i++) {
                if ("Kim".equals(seoul[i])) {
                    sb.append(i);
                    sb.append("에 있다");
                    return sb.toString();
                }
            }
            return null;
        }
    }
}
