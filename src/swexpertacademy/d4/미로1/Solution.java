package src.swexpertacademy.d4.미로1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int SIZE = 16;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d4/미로1/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");

            br.readLine();

            // 미로 입력, 현재 위치 확인
            int[][] maze = new int[SIZE][SIZE];
            int positionX = 0;
            int positionY = 0;
            for (int i = 0; i < SIZE; i++) {
                String[] temp = br.readLine().split("");
                for (int k = 0; k < SIZE; k++) {
                    maze[i][k] = Integer.parseInt(temp[k]);
                    if(maze[i][k] == 2) {
                        positionY = i;
                        positionX = k;
                    }
                }
            }

            int result = 0;
            int count = 1;
            Queue<Integer> queue = new LinkedList<>();
            while (true){
                // 현재 위치 1
                maze[positionY][positionX] = 1;
                // 4방향 체크 후 0인 값 찾기
                for(int i=0; i<4; i++){
                    if(maze[positionY+dy[i]][positionX+dx[i]] == 0){
                        queue.offer(positionY+dy[i]);
                        queue.offer(positionX+dx[i]);
                    }
                    if(maze[positionY+dy[i]][positionX+dx[i]] == 3){
                        result = 1;
                        break;
                    }
                }
                System.out.println("queue: " + queue.toString());
                System.out.println();

                // 인접 구간에 3이 있다면 도착 가능, result = 1, 종료
                if(result == 1) break;
                // 인접 구간을 탐색했는데 queue 가 비어있다면 더이상 갈곳이 없다는 뜻, 종료
                if(queue.isEmpty()) break;

                positionY = queue.poll();
                positionX = queue.poll();
            }


            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
