package src.baekjun.큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 큐2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int rear = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] temp = br.readLine().split(" ");

            switch (temp[0]) {
                case "push":
                    rear = Integer.parseInt(temp[1]);
                    queue.offer(rear);
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if (queue.isEmpty()) {
                        bw.write("1\n");
                    } else {
                        bw.write("0\n");
                    }
                    break;
                default:
                    if (queue.isEmpty()) {
                        bw.write("-1\n");
                        continue;
                    }

                    switch (temp[0]) {
                        case "pop":
                            bw.write(queue.poll() + "\n");
                            break;
                        case "front":
                            bw.write(queue.peek() + "\n");
                            break;
                        case "back":
                            bw.write(rear + "\n");
                            break;
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();
    }
}
