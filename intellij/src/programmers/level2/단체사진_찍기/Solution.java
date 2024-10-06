package src.programmers.level2.단체사진_찍기;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        int n1 = 2;
        String[] data1 = new String[]{"N~F=0", "R~T>2"};
        int answer1 = 3648;
        int result1 = new Solution().solution(n1, data1);
        PRINT_RESULT(1, result1, answer1);

        int n2 = 2;
        String[] data2 = new String[]{"M~C<2", "C~M>1"};
        int answer2 = 0;
        int result2 = new Solution().solution(n2, data2);
        PRINT_RESULT(2, result2, answer2);
    }

    public static void PRINT_RESULT(int index, int result, int answer) {
        boolean correct = result == answer;
        StringBuilder sb = new StringBuilder();
        sb.append("\n\n테스트 케이스 ").append(index).append(": ");
        sb.append(correct ? "정답" : "오답").append("\n");
        sb.append("\t- 실행 결과: \t").append(result).append("\n");
        sb.append("\t- 기댓값: \t").append(answer).append("\n");
        if (correct) System.out.println(sb);
        else throw new RuntimeException(sb.toString());
    }

    private static final char[] FRIENDS = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    private static final int NOT_VISITED = -1;
    private static Map<Character, List<Compare>> compareMap;
    private static Map<Character, Integer> visitedMap;
    private static List<Character> place;
    private static int answer;

    public int solution(int n, String[] data) {
        compareMap = new HashMap<>();
        visitedMap = new HashMap<>();
        place = new ArrayList<>();
        answer = 0;

        for (char friend : FRIENDS) {
            visitedMap.put(friend, NOT_VISITED);
        }

        for (String d : data) {
            char me = d.charAt(0);
            char friend = d.charAt(2);
            char operation = d.charAt(3);
            int length = Integer.parseInt(d.split("[=><]")[1]);

            Compare myCompare = new Compare(me, friend, operation, length);
            List<Compare> myCompareList = compareMap.getOrDefault(me, new ArrayList<>());
            myCompareList.add(myCompare);
            compareMap.put(me, myCompareList);

            Compare friendCompare = new Compare(friend, me, operation, length);
            List<Compare> friendCompareList = compareMap.getOrDefault(friend, new ArrayList<>());
            friendCompareList.add(friendCompare);
            compareMap.put(friend, friendCompareList);
        }

        insert();

        return answer;
    }

    public void insert() {
        if (place.size() >= 8) {
            answer++;
            return;
        }

        for (char friend : FRIENDS) {
            if (visitedMap.get(friend) != NOT_VISITED) {
                continue;
            }

            List<Compare> compareList = compareMap.get(friend);
            if (compareList != null && !compareList.isEmpty()) {
                boolean canPlace = true;
                for (Compare compare : compareList) {
                    if (!compare.canPlace(place.size())) {
                        canPlace = false;
                        break;
                    }
                }

                if (!canPlace) {
                    continue;
                }
            }

            place.add(friend);
            visitedMap.put(friend, place.size() - 1);
            insert();
            place.remove(place.size() - 1);
            visitedMap.put(friend, NOT_VISITED);
        }
    }

    static class Compare {
        private final char me;
        private final char friend;
        private final char operation;
        private final int length;

        public Compare(char me, char friend, char operation, int length) {
            this.me = me;
            this.friend = friend;
            this.operation = operation;
            this.length = length;
        }

        public boolean canPlace(int index) {
            if (!compareMap.containsKey(me)) {
                return true;
            }

            if (visitedMap.get(friend) == NOT_VISITED) {
                return true;
            }

            int friendIndex = place.indexOf(friend);
            int diff = Math.abs(friendIndex - index) - 1;
            return switch (operation) {
                case '=' -> diff == length;
                case '<' -> diff < length;
                case '>' -> diff > length;
                default -> false;
            };

        }
    }
}