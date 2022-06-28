package programmers.코딩테스트_고득점_Kit.깊이_너비_우선탐색;

public class 단어_변환 {
    public static void main(String[] args) {
        String begin = "hit";
        String target = "cog";
        String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
        // String[] words = { "hot", "dot", "dog", "lot", "log" };
        Solution s = new Solution();
        System.out.println(s.solution(begin, target, words));
    }

    static class Solution {
        int answer = Integer.MAX_VALUE;

        public int solution(String begin, String target, String[] words) {
            boolean[] visited = new boolean[words.length];
            dfs(begin, target, words, visited, 0);

            if (answer == Integer.MAX_VALUE) {
                return 0;
            }

            return answer;
        }

        public void dfs(String begin, String target, String[] words, boolean[] visited, int count) {
            if (begin.equals(target)) {
                answer = Math.min(answer, count);
                return;
            }

            for (int i = 0; i < words.length; i++) {
                if (check(begin, words[i]) && !visited[i]) {
                    visited[i] = true;
                    count++;
                    dfs(words[i], target, words, visited, count);
                    count--;
                    visited[i] = false;
                }

            }
        }

        public boolean check(String word1, String word2) {
            int diffCount = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diffCount++;
                }
                if (diffCount > 1) {
                    return false;
                }
            }
            return true;
        }
    }
}