package src.baekjun.큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        while (true) {
            if(queue.size() == 1) break;
            queue.poll();
            if(queue.size() == 1) break;
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
