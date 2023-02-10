package src.programmers.archive.SummerCoding2018.level3;

/**
 * 기지국설치
 * https://programmers.co.kr/learn/courses/30/lessons/12979
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-06
 */
public class 기지국설치 {
    public static void main(String[] args) {
        int n = 16;
        int[] stations = {9};
        int w = 2;

        System.out.println(new Solution().solution(n, stations, w));
    }

    static class Solution {
        public int solution(int n, int[] stations, int w) {
            int answer = 0;
            int stationIdx = 0;
            int apartIdx = 1;

            while (apartIdx <= n) {
                if (stationIdx < stations.length && apartIdx >= stations[stationIdx] - w) {
                    apartIdx = stations[stationIdx] + w + 1;
                    stationIdx++;
                } else {
                    answer++;
                    apartIdx += (w * 2) + 1;
                }
            }

            return answer;
        }
    }
}
