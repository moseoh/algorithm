package test.dev_matching;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        int[][] dist = new int[][] { { 0, 2, 3, 1 }, { 2, 0, 1, 1 }, { 3, 1, 0, 2 },
                { 1, 1, 2, 0 } };
        // int[][] dist = new int[][] { { 0, 5, 2, 4, 1 }, { 5, 0, 3, 9, 6 }, { 2, 3, 0,
        // 6, 3 }, { 4, 9, 6, 0, 3 },
        // { 1, 6, 3, 3, 0 } };
        new Solution().solution(dist);
    }

    static class Solution {
        public int[][] solution(int[][] dist) {
            List<Entry> suf = new ArrayList<>();
            List<Entry> pre = new ArrayList<>();
            Map<Integer, Integer> lengthMap = new HashMap<>();

            for (int i = 0; i < dist[0].length; i++) {
                pre.add(new Entry(i, dist[0][i]));
                lengthMap.put(i, dist[0][i]);
            }

            Collections.sort(pre);

            System.out.println(pre);

            int num = 1;
            while (true) {
                if (pre.size() - 1 == num) {
                    break;
                }

                if (Math.abs(pre.get(num + 1).length
                        - pre.get(num).length) != dist[pre.get(num + 1).index][pre.get(num).index]) {
                    suf.add(pre.get(num + 1));
                    pre.remove(num + 1);
                } else {
                    num++;
                }
            }

            Collections.reverse(suf);
            suf.addAll(pre);

            int[][] answer = new int[2][suf.size()];
            int[] a1 = new int[suf.size()];
            int[] a2 = new int[suf.size()];
            for (int i = 0; i < suf.size(); i++) {
                a1[i] = suf.get(i).index;
                a2[i] = suf.get(suf.size() - 1 - i).index;
            }

            if (suf.get(0).index < suf.get(suf.size() - 1).index) {
                answer[0] = a1;
                answer[1] = a2;
            } else {
                answer[0] = a2;
                answer[1] = a1;
            }

            System.out.println(Arrays.toString(a1));
            System.out.println(Arrays.toString(a2));

            return answer;
        }
    }

    static class Entry implements Comparable<Entry> {
        int index;
        int length;

        Entry(int index, int length) {
            this.index = index;
            this.length = length;
        }

        @Override
        public String toString() {
            return index + "";
        }

        @Override
        public int compareTo(Entry o) {
            return this.length = o.length;
        }
    }
}
