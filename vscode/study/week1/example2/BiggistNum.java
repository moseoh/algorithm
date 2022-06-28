package study.week1.example2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BiggistNum {
    public static void main(String[] args) {
        int[] numbers = { 303, 3, 333, 343, 35 };

        Solution s = new Solution();
        System.out.println(s.solution(numbers));
    }

}

class Solution {
    public String solution(int[] numbers) {
        String answer = IntStream.of(numbers)
                .mapToObj(String::valueOf)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());

        if (answer.startsWith("0"))
            return "0";
        return answer;
    }
}

class Solution1 {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++)
            strNumbers[i] = String.valueOf(numbers[i]);

        // Arrays.sort(strNumbers, new Comparator<String>() {
        // @Override
        // public int compare(String o1, String o2) {
        // return (o2 + o1).compareTo(o1 + o2);
        // }
        // });

        // 람다
        Arrays.sort(strNumbers, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        for (String strNumber : strNumbers)
            answer.append(strNumber);

        if (answer.toString().matches("^0+$"))
            return "0";
        else
            return answer.toString();
    }
}