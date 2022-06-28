package programmers.코딩테스트_고득점_Kit.동적계획법DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N으로_표현 {
    public static void main(String[] args) {
        int N = 5;
        int number = 12;

        Solution s = new Solution();
        System.out.println(s.solution(N, number));
    }

    static class Solution {
        List<Set<Integer>> list = new ArrayList<>();

        public int solution(int N, int number) {
            for (int i = 0; i < 9; i++) {
                list.add(new HashSet<>());
            }
            list.get(1).add(N);
            if (number == N) {
                return 1;
            }
            for (int i = 2; i < 9; i++) {
                for (int j = 1; j <= i / 2; j++) {
                    calc(list.get(i), list.get(i - j), list.get(j));
                    calc(list.get(i), list.get(j), list.get(i - j));
                }
                String n = Integer.toString(N);
                list.get(i).add(Integer.parseInt(n.repeat(i)));

                if (list.get(i).contains(number)) {
                    return i;
                }
            }

            return -1;
        }

        public void calc(Set<Integer> set, Set<Integer> arr1, Set<Integer> arr2) {
            for (int a : arr1) {
                for (int b : arr2) {
                    set.add(a + b);
                    set.add(a - b);
                    set.add(a * b);
                    set.add(a / b);
                }
            }
            set.remove(0);
        }
    }
}