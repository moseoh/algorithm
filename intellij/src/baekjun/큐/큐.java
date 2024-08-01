package src.baekjun.큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 큐 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int rear = -1;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");

            switch (s[0]) {
                case "push":
                    rear = Integer.parseInt(s[1]);
                    queue.add(rear);
                    break;
                case "front":
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.peek());
                    }
                    sb.append("\n");
                    break;
                case "back":
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(rear);
                    }
                    sb.append("\n");
                    break;
                case "size":
                    sb.append(queue.size()).append("\n");
                case "pop":
                    if (queue.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(queue.poll());
                    }
                    sb.append("\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        sb.append(1);
                    } else {
                        sb.append(0);
                    }
                    sb.append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }

}
