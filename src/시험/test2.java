package src.시험;

/**
 * test2
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-08
 */
public class test2 {
    public static void main(String[] args) {
//        int leave = 4;
//        String day = "FRI";
//        int[] holidays = {6, 21, 23, 27, 28};

//        int leave = 3;
//        String day = "SUN";
//        int[] holidays = {2, 6, 17, 29};

        int leave = 30;
        String day = "MON";
        int[] holidays = {2, 3, 4, 28, 29, 30};

        System.out.println(new Solution().solution(leave, day, holidays));
    }

    static class Solution {
        public int solution(int leave, String day, int[] holidays) {
            int answer = 0;
            boolean[] days = new boolean[31];
            int start = -1;
            if (day.equals("MON")) start = 6;
            if (day.equals("TUE")) start = 5;
            if (day.equals("WED")) start = 4;
            if (day.equals("THU")) start = 3;
            if (day.equals("FRI")) start = 2;
            if (day.equals("SAT")) start = 1;
            if (day.equals("SUN")) start = 0;


            for (int i = 0; i < 31; i += 7) {
                if (start + i < 31)
                    days[start + i] = true;
                if (start + 1 + i < 31)
                    days[start + 1 + i] = true;
            }

            for (int i = 0; i < holidays.length; i++) {
                days[holidays[i]] = true;
            }

            for (int i = 1; i < 31; i++) {
                if (days[i]) {
                    int leaveCount = leave;
                    int count = 0;

                    for (int k = i; k < 31; k++) {
                        if (days[k]) {
                            count++;
                            continue;
                        }
                        if (leaveCount == 0) break;
                        if (!days[k]) {
                            count++;
                            leaveCount--;
                        }
                    }
                    answer = Math.max(answer, count);
                }
            }


            return answer;
        }
    }
}
