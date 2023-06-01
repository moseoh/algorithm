package src.programmers.archive.aceproject.solution2;

import java.util.Stack;

public class Solution {
//    List<String> list;

    public static void main(String[] args) {
        String s = "baba";
        String answer1 = "bba";
        String result1 = new Solution().solution(s);
        System.out.println(answer1);
        System.out.println(result1);
    }

    public String solution(String s) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            while (!stack.isEmpty() && stack.peek() < s.charAt(i)) {
                stack.pop();
            }

            stack.push(s.charAt(i));
        }

        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

//    public String solution(String s) {
//        list = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            combine(0, i + 1, new StringBuilder(), s);
//        }
//
//        Collections.sort(list);
//        return list.get(list.size() - 1);
//    }
//
//    public void combine(int index, int length, StringBuilder sb, String s) {
//        if (sb.length() == length) {
//            if (!list.contains(sb.toString())) {
//                list.add(sb.toString());
//            }
//            return;
//        }
//
//        for (int i = index; i < s.length(); i++) {
//            sb.append(s.charAt(i));
//            combine(i + 1, length, sb, s);
//            sb.setLength(sb.length() - 1);
//        }
//
//    }

}
