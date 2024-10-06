package src.baekjun.연결리스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 키로거 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (N-- > 0) {
            sb.append(getPassword(br.readLine())).append("\n");
        }
        System.out.println(sb);
    }

    public static String getPassword(String str) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            switch (c) {
                case '<':
                    if (!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case '>':
                    if (!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case '-':
                    if (!left.isEmpty()) {
                        left.pop();
                    }
                    break;
                default:
                    left.push(c);
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (char ch : left) {
            sb.append(ch);
        }

        while (!right.isEmpty()) {
            sb.append(right.pop());
        }

        return sb.toString();
    }
}
