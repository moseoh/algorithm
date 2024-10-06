package src.baekjun.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 먹을_것인가_먹힐_것인가 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] A = new int[Integer.parseInt(st.nextToken())];
            int[] B = new int[Integer.parseInt(st.nextToken())];

            st = new StringTokenizer(br.readLine());
            for (int a = 0; a < A.length; a++) {
                A[a] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int b = 0; b < B.length; b++) {
                B[b] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int count = 0;
            int index = 0;
            for (int a : A) {
                for (int j = index; j < B.length; j++) {
                    if (a > B[j]) index++;
                    else break;
                }
                count += index;
            }
            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }
}
