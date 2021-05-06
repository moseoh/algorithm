package src.programmers.DevMatching2021;

/**
 * 로또의최고순위와최저순위
 * https://programmers.co.kr/learn/courses/30/lessons/77484
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-26
 */
public class 로또의최고순위와최저순위 {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};

        System.out.println(new Solution().solution(lottos, win_nums));
    }

    static class Solution {
        public int[] solution(int[] lottos, int[] win_nums) {
            int count = 0;
            int zeroCount = 0;
            for (int i = 0; i < 6; i++) {
                if(lottos[i] == 0) {
                    zeroCount++;
                    continue;
                }
                for (int k = 0; k < 6; k++) {
                    if(win_nums[k] == lottos[i]) count++;
                }
            }

            return new int[]{rank(zeroCount+count), rank(count)};
        }

        public int rank(int score) {
            switch (score){
                case 6:
                    return 1;
                case 5:
                    return 2;
                case 4:
                    return 3;
                case 3:
                    return 4;
                case 2:
                    return 5;
                default:
                    return 6;
            }
        }
    }
}
