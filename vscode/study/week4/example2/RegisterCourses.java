package study.week4.example2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class RegisterCourses {
    public static void main(String[] args) {
        String[] s1 = { "A", "E", "B", "D", "B", "H", "F", "H", "C" };
        String[] s2 = { "G", "C", "G", "F", "J", "E", "B", "F", "B" };
        String k = "B";
        // DHECFB

        // String[] s1 = { "A", "E", "B", "D", "B", "H", "F", "H", "C" };
        // String[] s2 = { "G", "C", "G", "F", "J", "E", "B", "F", "B" };
        // String k = "G";
        // ADHECFBG

        Solution s = new Solution();
        System.out.println(s.solution(s1, s2, k));
    }

}

class Solution {
    public String[] solution(String[] s1, String[] s2, String k) {
        Map<String, Set<String>> preCourseMap = preparePreCourse(s1, s2, k);
        System.out.println(preCourseMap);
        String[] answer = course(k, preCourseMap, new HashSet<>());
        Queue<String> que = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println(o1 + " " + o2);
                if (!preCourseMap.containsKey(o1) && !preCourseMap.containsKey(o2)) {
                    return o1.compareTo(o2);
                }

                if (preCourseMap.containsKey(o1) && !preCourseMap.containsKey(o2)) {
                    return 1;
                }

                if (!preCourseMap.containsKey(o1) && preCourseMap.containsKey(o2)) {
                    return -1;
                }

                if (preCourseMap.get(o2).contains(o1)) {
                    return -1;
                }

                if (isChild(preCourseMap, o1, o2)) {
                    return -1;
                }

                return o1.compareTo(o2);
            }
        });

        for (String s : answer) {
            que.add(s);
            System.out.println(que);
        }
        System.out.println(que);

        return answer;
    }

    public Map<String, Set<String>> preparePreCourse(String[] s1, String[] s2, String k) {
        Map<String, Set<String>> preCourseMap = new HashMap<>();
        for (int i = 0; i < s2.length; i++) {
            Set<String> temp = preCourseMap.getOrDefault(s2[i], new HashSet<>());
            temp.add(s1[i]);
            preCourseMap.put(s2[i], temp);
        }

        return preCourseMap;
    }

    public int compare(Map<String, Set<String>> preCourseMap, String o1, String o2) {
        if (!preCourseMap.containsKey(o1) && !preCourseMap.containsKey(o2)) {
            return o1.compareTo(o2);
        }

        if (preCourseMap.containsKey(o1) && !preCourseMap.containsKey(o2)) {
            return 1;
        }

        if (!preCourseMap.containsKey(o1) && preCourseMap.containsKey(o2)) {
            return -1;
        }

        if (preCourseMap.get(o2).contains(o1)) {
            return -1;
        }

        if (isChild(preCourseMap, o1, o2)) {
            return -1;
        }

        return o1.compareTo(o2);
    }

    public boolean isChild(Map<String, Set<String>> preCourseMap, String a, String b) {
        return true;
    }

    public String[] course(String k, Map<String, Set<String>> preCourse, Set<String> course) {
        course.add(k);
        if (preCourse.containsKey(k)) {
            for (String pre : preCourse.get(k)) {
                course(pre, preCourse, course);
            }
        }
        return course.toArray(new String[course.size()]);
    }
}