package second;

import java.util.*;

public class test2 {
    public static void main(String[] args) {
        String[] arr = { "1", "2", "4", "3", "3", "4", "1", "5" };
        String[] processes = { "read 1 3 1 2", "read 2 6 4 7", "write 4 3 3 5 2", "read 5 2 2 5", "write 6 1 3 3 9",
                "read 9 1 0 7" };
        System.out.println(Arrays.toString(new Solution().solution(arr, processes)));
    }

    static class Solution {
        public String[] solution(String[] arr, String[] processes) {
            String[] answer = {};

            PriorityQueue<Process> waitingQueue = new PriorityQueue<>(new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    return o2.method.compareTo(o1.method);
                }
            });

            Queue<Process> que = new LinkedList<>();

            int time = 0;
            for (String str : processes) {
                Process process = new Process(str.split(" "));

                System.out.println(time);
                System.out.println(process);

                if (waitingQueue.size() > 0 && !que.peek().method.equals(process.method)) {
                    System.out.println("waitingQue");
                    waitingQueue.add(process);
                }

                if (que.size() == 0) {
                    que.add(process);
                    time += process.t2;
                    continue;
                }

                if (que.peek().method.equals("read") && process.method.equals("read")) {
                    time = Math.max(time, process.t2 + process.t1 - 1);
                    que.add(process);
                    continue;
                }
            }

            while (!waitingQueue.isEmpty()) {
                que.add(waitingQueue.poll());
            }

            System.out.println();

            for (Process pro : waitingQueue) {
                System.out.println(pro.toString());
            }

            System.out.println();

            for (Process pro : que) {
                System.out.println(pro.toString());
            }

            return answer;
        }
    }
}

class Process {
    String method;
    int t1;
    int t2;
    int A;
    int B;
    int C;

    Process(String[] str) {
        this.method = str[0];
        this.t1 = Integer.parseInt(str[1]);
        this.t2 = Integer.parseInt(str[2]);
        this.A = Integer.parseInt(str[3]);
        this.B = Integer.parseInt(str[4]);
        if (method.equals("write"))
            this.C = Integer.parseInt(str[5]);
        else
            this.C = -1;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d %d %d %d", method, t1, t2, A, B, C);
    }
}