package src;

import src.baekjun.기본수학1.큰수AB;

import java.util.*;

class Temp {
    static class Solution {
        static boolean[] check;

        public int solution(int n, int[] v1, int[] v2, int[] num, int[] amount) {
            check = new boolean[v1.length];

            for (int i = 0; i < v1.length; i++) {
                if (check[i]) continue;
                check[i] = true;

                Set<Integer> set = new TreeSet<>();
                set.add(v1[i]);
                set.add(v2[i]);

                int find = v1[i];
                System.out.println("find : " + find);
                while (true) {
                    find = fun(find, v1, v2);
                    System.out.println("find : " + find);
                    if (find == -1) break;
                    set.add(find);
                }

                find = v2[i];
                int temp = find;
                System.out.println("find : " + find);
                while (true) {
                    System.out.println("find : " + find);
                    find = fun(find, v1, v2);
                    if (find == -1) {
                        break;
                    }
                    set.add(find);
                }

                System.out.println(i + " : " + set);

            }

            return 0;
        }

        public static int fun(int find, int[] v1, int[] v2) {
            int result = -1;

            for (int i = 0; i < v1.length; i++) {
                if (check[i]) continue;
                if (find == v1[i]) {
                    check[i] = true;
                    return v2[i];
                }
                if (find == v2[i]) {
                    check[i] = true;
                    return v1[i];
                }
            }

            return result;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int[] v1 = {8, 4, 4, 1};
        int[] v2 = {1, 10, 9, 4};
        int[] num = {2, 5, 8, 6, 4, 1, 3, 10, 7, 4};
        int[] amount = {3, -1, 3, 3, 1, -2, -4, 1, 2, -5};
        System.out.println(solution.solution(n, v1, v2, num, amount));
    }
}
