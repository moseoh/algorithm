package study.week1.example1;

import java.util.LinkedList;
import java.util.Queue;

public class StationInstallation {
    public static void main(String[] args) {
        // int n = 11;
        // int[] stations = { 4, 11 };
        // int w = 1;

        int n = 100;
        int[] stations = { 100 };
        int w = 98;

        SolutionS st = new SolutionS();
        System.out.println(st.solution(n, stations, w));
    }
}

class SolutionS {

    public int solution(int n, int[] stations, int w) {
        int lRange = 0;
        int rRange = 1;
        int stationRange = w * 2 + 1;

        int answer = 0;

        for (int i = 0; i < stations.length; i++) {

            lRange = stations[i] - (w + 1);
            if (i != 0) {
                rRange = stations[i - 1] + w + 1;
            }

            if (lRange >= rRange) {
                answer += getStationCount(lRange - rRange + 1, stationRange);
            }

        }

        rRange = stations[stations.length - 1] + w + 1;
        if (rRange <= n) {
            answer += getStationCount(n - rRange + 1, stationRange);
        }

        return answer;
    }

    public int getStationCount(int range, int stationRange) {
        return range % stationRange == 0 ? range / stationRange : range / stationRange + 1;
    }
}

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int stationIndex = 0;
        int apartIndex = 1;

        while (apartIndex <= n) {
            if (stationIndex < stations.length && apartIndex >= stations[stationIndex] - w) {
                apartIndex = stations[stationIndex] + w + 1;
                stationIndex++;
            } else {
                answer++;
                apartIndex += (w * 2) + 1;
            }
        }
        return answer;
    }
}

// 큐를 이용한 풀이
// 시간 초과가 나옴
class SolutionT1 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int position = 1;
        Queue<Integer> sq = new LinkedList<>();
        for (int s : stations)
            sq.offer(s);

        while (position <= n) {
            if (!sq.isEmpty() && sq.peek() - w <= position) {
                position = sq.poll() + w + 1;
            } else {
                answer++;
                position += w * 2 + 1;
            }
        }
        return answer;
    }
}

// 큐를 사용하기에 시간이 늘어남을 인지하고, 큐를 제거한다.
class SolutionT2 {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int si = 0;
        int position = 1;

        while (position <= n) {
            if (si < stations.length && stations[si] - w <= position) {
                position = stations[si] + w + 1;
                si++;
            } else {
                answer++;
                position += w * 2 + 1;
            }
        }
        return answer;
    }
}