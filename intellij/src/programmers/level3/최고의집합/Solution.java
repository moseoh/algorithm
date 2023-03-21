package src.programmers.level3.최고의집합;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        int n1 = 2;
        int s1 = 9;
        assert Arrays.equals(new Solution().solution(n1, s1), new int[]{4, 5}) : "실패";

        int n2 = 2;
        int s2 = 1;
        assert Arrays.equals(new Solution().solution(n2, s2), new int[]{-1}) : "실패";

        int n3 = 2;
        int s3 = 8;
        assert Arrays.equals(new Solution().solution(n3, s3), new int[]{4, 4}) : "실패";
    }

    public int[] solution(int n, int s) {
        int num = s / n;
        if (num == 0) return new int[]{-1};

        int[] answer = new int[n];
        Arrays.fill(answer, num);

        int sum = num * n;
        if (sum == s) return answer;

        int remain = s - num * n;
        int index = answer.length - 1;
        while (remain != 0) {
            answer[index--]++;
            remain--;
        }

        return answer;
    }
}
