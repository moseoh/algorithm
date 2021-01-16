package src.Programmers;

public class BiggestNum {
    public static void main(String[] args) {
        int[] numbers = { 6, 10, 2 };
        int[] numbers2 = { 3, 30, 34, 5, 9 };

        System.out.println(solution(numbers2));
    }

    public static String solution(int[] numbers) {
        String answer = "";
        int[] numCount = new int[10];

        for (int i : numbers) {
            String num = String.valueOf(i);
            checkNum(num, numCount);
        }

        for (int i = 9; i >= 0; i--) {
            while (numCount[i] > 0) {
                answer = answer + i;
                numCount[i]--;
            }
        }

        return answer;
    }

    public static void checkNum(String num, int[] numCount) {
        if (num.length() > 1) {
            addNum(num.substring(0, 1), numCount);
            num = num.substring(1);
            checkNum(num, numCount);
        } else {
            addNum(num, numCount);
        }
    }

    public static void addNum(String num, int[] numCount) {
        numCount[Integer.parseInt(num)]++;
    }

}