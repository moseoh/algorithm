package src.baekjun.큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 요세푸스_문제_0 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        int index = 0;
        while (!queue.isEmpty()) {
            if (k == ++index) {
                index = 0;
                sb.append(queue.poll()).append(" ");
            } else {
                queue.add(queue.poll());
            }
        }

        System.out.println("<" + sb.toString().trim().replaceAll(" ", ", ") + ">");
    }
}
