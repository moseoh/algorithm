package src.swexpertacademy.d3.암호생성기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d3/암호생성기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");
            br.readLine();
            String[] input = br.readLine().split(" ");
            Queue<Integer> queue = new LinkedList<>();
            for (String i : input) {
                queue.offer(Integer.parseInt(i));
            }

            int x = 1;
            while (true) {
                int move = queue.poll();
                move -= x++;
                if (move <= 0) {
                    queue.offer(0);
                    break;
                } else {
                    queue.offer(move);
                }
                if (x > 5) x = 1;
            }

            while(!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
