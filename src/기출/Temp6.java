package src.기출;

import java.io.*;
import java.util.Stack;

class Temp6 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int[][] arr = new int[Integer.parseInt(input[1])][Integer.parseInt(input[0])];

        for (int i = 0; i < arr.length; i++) {
            String[] temp = br.readLine().split(" ");
            for (int k = 0; k < arr[i].length; k++) {
                arr[i][k] = Integer.parseInt(temp[k]);
            }
        }

        System.out.println(runByStack(arr));

    }

    static int runByStack(int[][] maze) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        int result = 0;
        int positionY = 0;
        int positionX = 0;
        int add = 0;
        int addTemp = 0;
        Stack<Integer> stack = new Stack<>();
        while (true) {

            if(positionX == maze[0].length -1 || positionY == maze.length - 1){
                if(positionX == maze[0].length - 1){
                    addTemp = add;
                    for(int i = positionY; i < maze.length; i++) {
                        add += maze[i][positionX];
                        if (result < add) result = add;
                    }
                    add = addTemp;
                }
                if(positionY == maze.length - 1){
                    addTemp = add;
                    for(int i = positionX; i < maze[0].length; i++) {
                        add += maze[positionY][i];
                        if (result < add) result = add;
                    }
                    add = addTemp;
                }
                System.out.println("addTemp: "+addTemp);
            } else {
                add += maze[positionY][positionX];
                if (!visited[positionY][positionX+1]) {
                    stack.push(positionY);
                    stack.push(positionX + 1);
                }
                if (!visited[positionY+1][positionX]) {
                    stack.push(positionY + 1);
                    stack.push(positionX);
                }
            }

            if (stack.isEmpty()) break;

            positionX = stack.pop();
            positionY = stack.pop();
            visited[positionY][positionX] = true;

        }
        return result;
    }
}
