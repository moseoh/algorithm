package src.programmers.Level2.시소짝꿍;

public class 시소짝꿍 {
    public static void main(String[] args) {
        int[] weights = {
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
                100, 180, 360, 100,
        };
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            System.out.println(new Solution().solution(weights));
        }
        long endTime = System.currentTimeMillis();
        System.out.println("실행 시간 : " + (endTime - startTime) + "ms");
    }


    static class Solution {
        public long solution(int[] weights) {
            long answer = 0;
            for (int i = 0; i < weights.length - 1; i++) {
                for (int j = i + 1; j < weights.length; j++) {
                    if (isPartner(weights[i], weights[j])) {
                        answer++;
                    }
                }
            }
            return answer;
        }

        public boolean isPartner(int a, int b) {
            if (a == b) return true;
            if (a * 2 == b * 3) return true;
            if (a * 2 == b * 4) return true;
            if (a * 3 == b * 2) return true;
            if (a * 3 == b * 4) return true;
            if (a * 4 == b * 2) return true;
            if (a * 4 == b * 3) return true;
            return false;
        }
    }
}