package src.programmers.archive.aceproject.solution3;

public class Solution {
    public static void main(String[] args) {
        int n = 10;
        int maxhp = 10;
//        int[] times = {1, 5, 7, 10, 11};
//        int[] effects = {4, -6, -1, 14, 1};
//        int answer1 = 6;
        int[] times = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] effects = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int answer1 = 6;
        int result1 = new Solution().solution(n, maxhp, times, effects);
        System.out.println("================");
        System.out.println(answer1);
        System.out.println(result1);
    }

    public int solution(int n, int maxhp, int[] times, int[] effects) {
        int answer = times[0] + 1;
        int curEffect = effects[0];
        long curhp = 0;

        for (int i = 1; i < n; i++) {
            long past = times[i] - times[i - 1];
            answer += getCount(past, curEffect, curhp, maxhp);
            curhp = getCurrentHp(past, curEffect, curhp, maxhp);
            curEffect += effects[i];
        }

        return answer;
    }

    public long getCount(long past, int currentEffect, long currentHp, int maxHp) {
        if (currentEffect > 0 && currentHp != maxHp) {
            long needTime = (maxHp - currentHp) / currentEffect;
            if ((maxHp - currentHp) % currentEffect != 0) needTime++;
            return Math.max(0, past - needTime + 1);
        } else if (currentEffect < 0 && currentHp != 0) {
            long needTime = -(currentHp / currentEffect);
            if (currentHp % currentEffect != 0) needTime++;
            return Math.max(0, past - needTime + 1);
        } else if (currentHp == maxHp && currentEffect >= 0) {
            return past;
        } else if (currentHp == 0 && currentEffect <= 0) {
            return past;
        }
        return 0;
    }

    public long getCurrentHp(long past, int currentEffect, long currentHp, int maxHp) {
        long result = currentHp + currentEffect * past;
        if (result > maxHp) return maxHp;
        if (result < 0) return 0;
        return result;
    }
}
