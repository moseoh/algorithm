package src.programmers.Level2.오픈채팅방;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }

    public static String[] solution(String[] record) {
        List<String> recordList = new ArrayList<>();
        Map<String, String> nameMap = new HashMap<>();
        for (String s : record) {
            if (!s.startsWith("Leave")) {
                String[] split = s.split(" ");
                nameMap.put(split[1], split[2]);
            }

            if (!s.startsWith("Change")) {
                recordList.add(s);
            }
        }

        int length = recordList.size();
        String[] answer = new String[length];
        for (int i = 0; i < length; i++) {
            String[] split = recordList.get(i).split(" ");
            answer[i] = nameMap.get(split[1]);
            if ("Enter".equals(split[0])) {
                answer[i] += "님이 들어왔습니다.";
            } else {
                answer[i] += "님이 나갔습니다.";
            }
        }

        return answer;
    }
}
