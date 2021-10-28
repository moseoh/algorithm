package src.baekjun.스택;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class 오큰수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(temp[i]);
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                sb.append("-1").append(" ");
                stack.push(nums[i]);
                continue;
            }

            if (nums[i] < stack.peek()) {
                sb.append(stack.peek()).append(" ");
                stack.push(nums[i]);
            } else {
                stack.pop();
                i++;
            }
        }

        String[] str = sb.toString().split(" ");
        sb = new StringBuilder();
        for (int i = str.length - 1; i >= 0; i--) {
            sb.append(str[i]).append(" ");
        }

        System.out.println(sb.toString());
    }
}
