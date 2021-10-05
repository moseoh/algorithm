package src.baekjun.큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*

1
4 2
1 2 3 4

 */
public class 프린터_큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            sb.append(run(br));
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static int run(BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int index = Integer.parseInt(st.nextToken());
        int count = 0;
        int[] importance = new int[11];

        st = new StringTokenizer(br.readLine(), " ");
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queueIndex = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            queue.offer(num);
            queueIndex.offer(i);
            importance[num]++;
        }

        for (int i = 10; i > 0; i--) {
            if (importance[i] > 0) {
                if (queue.peek() == i) {
                    if(queueIndex.peek() == index) {
                        count++;
                        break;
                    }
                    queue.poll();
                    queueIndex.poll();
                    importance[i]--;
                    count++;
                } else {
                    queue.offer(queue.poll());
                    queueIndex.offer(queueIndex.poll());
                }
                i++;
            }
        }

        return count;
    }
}
