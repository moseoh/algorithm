package first;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class test1 {
    public static void main(String[] args) {
        int[] cost = { 2, 11, 20, 100, 200, 600 };
        int money = 1999;

        Solution solution = new Solution();

        System.out.println(solution.solution(money, cost));
    }

    static class Solution {
        public int solution(int money, int[] costs) {
            int answer = 0;
            int[] coin = { 1, 5, 10, 50, 100, 500 };
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < costs.length; i++) {
                map.put(i, coin[i] - costs[i]);
            }

            List<Entry<Integer, Integer>> entries = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
            Collections.sort(entries, new Comparator<Entry<Integer, Integer>>() {
                public int compare(Entry<Integer, Integer> obj1, Entry<Integer, Integer> obj2) {
                    double result = ((double) costs[obj1.getKey()] / coin[obj1.getKey()])
                            - ((double) costs[obj2.getKey()] / coin[obj2.getKey()]);
                    if (result > 0) {
                        return 1;
                    } else if (result < 0) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });

            for (int i = 0; i < entries.size(); i++) {
                int quotient = money / coin[entries.get(i).getKey()];
                money = money % coin[entries.get(i).getKey()];
                answer += (quotient * costs[entries.get(i).getKey()]);
            }

            return answer;
        }
    }

}
