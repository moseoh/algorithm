package src.baekjun.연결리스트;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 에디터 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();

        // 초기 문자열을 왼쪽 스택에 넣음
        for (char c : str.toCharArray()) {
            leftStack.push(c);
        }

        int M = Integer.parseInt(br.readLine());

        while (M-- > 0) {
            String input = br.readLine();
            char cmd = input.charAt(0);

            switch (cmd) {
                case 'L':
                    if (!leftStack.isEmpty()) {
                        rightStack.push(leftStack.pop());
                    }
                    break;
                case 'D':
                    if (!rightStack.isEmpty()) {
                        leftStack.push(rightStack.pop());
                    }
                    break;
                case 'B':
                    if (!leftStack.isEmpty()) {
                        leftStack.pop();
                    }
                    break;
                case 'P':
                    leftStack.push(input.charAt(2));
                    break;
            }
        }

        // 왼쪽 스택에 있는 모든 문자를 출력하고, 오른쪽 스택을 거꾸로 출력
        StringBuilder sb = new StringBuilder();
        for (char c : leftStack) {
            sb.append(c);
        }
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        System.out.println(sb);
    }
}