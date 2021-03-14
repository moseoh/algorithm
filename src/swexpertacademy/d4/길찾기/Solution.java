package src.swexpertacademy.d4.길찾기;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d4/길찾기/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");

            br.readLine();
            int result = 0;
            int[] left = new int[100];
            int[] right = new int[100];
            String[] temp = br.readLine().split(" ");
            int[] num = new int[temp.length];

            for (int i = 0; i < num.length; i++) {
                num[i] = Integer.parseInt(temp[i]);
            }

            int overlap = -1;
            int max = 0;
            for (int i = 0; i < num.length; i += 2) {
                if (max < num[i] && num[i] != 99) max = num[i];
                if (num[i] != overlap) {
                    left[num[i]] = num[i + 1];
                    overlap = num[i];
                } else {
                    right[num[i]] = num[i + 1];
                }
            }

            boolean[] visited = new boolean[100];
            Stack<Integer> stack = new Stack<>();

            int move = 0;

            while(true){
                if(move == 99) {
                    result = 1;
                    break;
                }

                if(!visited[move]){
                    stack.push(move);
                    visited[move] = true;
                }

                if(!visited[left[move]]){
                    move = left[move];
                    continue;
                }

                if(!visited[right[move]]){
                    move = right[move];
                    continue;
                }

                stack.pop();
                if(stack.isEmpty()) break;
                move = stack.peek();
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
