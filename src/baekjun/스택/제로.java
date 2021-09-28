package src.baekjun.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        while (count-- > 0) {
            int num = Integer.parseInt(br.readLine());
            if(num != 0) {
                result += num;
                stack.push(num);
            } else {
                result -= stack.pop();
            }
        }

        System.out.println(result);
    }
}
