package src.시험2;

import java.util.*;

/**
 * test2
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-09
 */
public class test2 {
    public static void main(String[] args) {
        int[] t = {1, 1, 1, 1, 2, 3};
        int[] r = {4, 4, 3, 3, 2, 1};
        System.out.println(Arrays.toString(new Solution().solution(t, r)));
    }

    static class Solution {
        class Guest implements Comparable<Guest> {
            int index;
            int arrival;
            int grade;

            @Override
            public int compareTo(Guest o) {
                if (this.grade > o.grade) return 1;
                else if (this.grade < o.grade) return -1;
                else {
                    if (this.arrival > o.arrival) return 1;
                    else if (this.arrival < o.arrival) return -1;
                    else {
                        return Integer.compare(this.index, o.index);
                    }
                }
            }


            public Guest(int index, int arrival, int grade) {
                this.index = index;
                this.arrival = arrival;
                this.grade = grade;
            }

            @Override
            public String toString() {
                return "Guest{" +
                        "index=" + index +
                        ", arrival=" + arrival +
                        ", grade=" + grade +
                        '}';
            }
        }

        public int[] solution(int[] t, int[] r) {
            int size = t.length;
            int[] answer = new int[size];
            Map<Integer, List<Guest>> map = new HashMap<>();
            for (int i = 0; i < size; i++) {
                if (map.getOrDefault(t[i], null) == null) {
                    List<Guest> list = new ArrayList<>();
                    list.add(new Guest(i, t[i], r[i]));
                    map.put(t[i], list);
                } else {
                    map.get(t[i]).add(new Guest(i, t[i], r[i]));
                }
            }

            int index = 0;
            for (int i = 0; i <= 1000; i++) {
                if (index == size) break;
                if (map.getOrDefault(i, null) == null) continue;
                if (map.get(i).size() == 1) {
                    answer[index] = map.get(i).get(0).index;
                } else {
                    Collections.sort(map.get(i));
                    answer[index] = map.get(i).get(0).index;
                    map.get(i).remove(0);
                    if (map.getOrDefault(i + 1, null) == null) {
                        map.put(i + 1, map.get(i));
                    } else {
                        map.get(i + 1).addAll(map.get(i));
                    }
                }
                index++;
            }

            return answer;
        }
    }

}
