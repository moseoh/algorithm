package src.programmers.archive.kakao2021.순위검색;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    static Map<String, Integer> WordMap = new HashMap<>();
    static List<List<Integer>> ScoreList = new ArrayList<>();

    public static void main(String[] args) {
        String[] info = {"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"};

        solution(info, query);
    }

    static Map<String, List<Integer>> infoMap = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        for (String in : info) {
            String[] split = in.split(" ");
            StringBuilder sb = new StringBuilder();
            sb.append(split[0]).append(split[1]).append(split[2]).append(split[3]);
            int score = Integer.parseInt(split[4]);
            infoMap.getOrDefault(sb.toString(), new ArrayList<>()).add(score);
        }

        for (String qu : query) {
            String[] split = qu.split(" and | ");
            StringBuilder sb = new StringBuilder();
            sb.append(split[0]).append(split[1]).append(split[2]).append(split[3]);
            int score = Integer.parseInt(split[4]);
        }


        int[] answer = {};
        return answer;
    }
}
