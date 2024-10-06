package src.baekjun.연결리스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_문제 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i + 1);
        }

        int count = 1;
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            if (count++ == K) {
                count = 1;
                sb.append(queue.poll()).append(", ");
            } else {
                queue.add(queue.poll());
            }
        }

        sb.setLength(sb.length() - 2);
        System.out.println("<" + sb + ">");
    }
}
