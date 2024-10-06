package src.programmers.level1.달리기_경주;

import java.time.chrono.MinguoDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        String[] players1 = new String[]{"mumu", "soe", "poe", "kai", "mine"};
        String[] callings1 = new String[]{"kai", "kai", "mine", "mine"};
        String[] answer1 = new String[]{"mumu", "kai", "mine", "soe", "poe"};
        String[] result1 = new Solution().solution(players1, callings1);
        PRINT_RESULT(1, result1, answer1);
    }

    public static void PRINT_RESULT(int index, String[] result, String[] answer) {
        boolean correct = Arrays.equals(result, answer);
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(Arrays.toString(result)).append("\n");
        sb.append("\t- 기댓값: \t").append(Arrays.toString(answer)).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String calling : callings) {
            moving(players, calling, map);
        }
        return players;
    }

    public void moving(String[] players, String calling, Map<String, Integer> indexMap) {
        int myIndex = indexMap.get(calling);
        int frontIndex = myIndex - 1;

        String temp = players[frontIndex];
        players[frontIndex] = calling;
        players[myIndex] = temp;

        indexMap.put(calling, frontIndex);
        indexMap.put(temp, myIndex);
    }
}

