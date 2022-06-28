package programmers.코딩테스트_고득점_Kit.완전탐색;

public class 카펫 {
    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        Solution s = new Solution();
        System.out.println(s.solution(brown, yellow));
    }

    static class Solution {
        public int[] solution(int brown, int yellow) {
            int round = brown / 2;
            int width = 0, height = 0;
            for (int i = 1; i < round; i++) {
                width = round - i;
                height = i + 2;

                if (width < height) {
                    break;
                }

                if (calc(width, height, yellow)) {
                    break;
                }
            }
            return new int[] { width, height };
        }

        public boolean calc(int width, int height, int yellow) {
            if ((width - 2) * (height - 2) == yellow) {
                return true;
            }
            return false;
        }
    }
}