package src.swexpertacademy.d4.사칙연산유효성검사;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d4/사칙연산유효성검사/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");

            int N = Integer.parseInt(br.readLine());
            char[] tree = new char[N + 1];
            boolean[] leaf = new boolean[N + 1];
            int result = 1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken();
                tree[i] = st.nextToken().charAt(0);
                if (!st.hasMoreTokens()) leaf[i] = true;
            }

            for (int i = 0; i < N + 1; i++) {
                if (leaf[i]) {
                    if (!(tree[i] >= '0' && tree[i] <= '9'))
                        result = 0;
                } else {
                    if (tree[i] >= '0' && tree[i] <= '9')
                        result = 0;
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
