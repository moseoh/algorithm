package study.week3.example1;

import java.util.HashMap;
import java.util.Map;

public class Camouflage {
    public static void main(String[] args) {
        String[][] clothes = {
                { "1", "1" },
                { "2", "2" },
                { "3", "3" },
                { "4", "4" },
                { "5", "5" },
                { "6", "6" },
                { "7", "7" },
                { "8", "8" },
                { "9", "9" },
                { "10", "10" },
                { "11", "11" },
                { "12", "12" },
                { "13", "13" },
                { "14", "14" },
                { "15", "15" },
                { "16", "16" },
                { "17", "17" },
                { "18", "18" },
                { "19", "19" },
                { "20", "20" },
                { "21", "21" },
                { "22", "22" },
                { "23", "23" },
                { "24", "24" },
                { "25", "25" },
                { "26", "26" },
                { "27", "27" },
                { "28", "28" },
                { "29", "29" },
                { "30", "30" },
        };
        // String[][] clothes = {
        // { "yellowhat", "headgear" },
        // { "bluesunglasses", "eyewar" },
        // { "blacksunglasses", "eyewar" },
        // { "jeans", "pants" },
        // { "coat", "outer" },
        // { "bluesunglasses", "eyewar" },
        // { "green_turban", "headgear" }
        // };
        // String[][] clothes = { { "crowmask", "face" }, { "bluesunglasses", "face" },
        // { "somky_makeup", "face" } };
        Solution s = new Solution();
        System.out.println(s.solution(clothes));
    }
}

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesMap = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            clothesMap.put(clothes[i][1], clothesMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        return clothesMap.values().stream().reduce(1, (a, b) -> a * (b + 1)) - 1;
    }
}