package src.기출;

import java.io.*;

class Temp3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int length = Integer.parseInt(br.readLine());
        int[][] arr = new int[length][length];
        for (int i = 0; i < length; i++) {
            String[] input = br.readLine().split("");
            for (int k = 0; k < length; k++) {
                arr[i][k] = Integer.parseInt(input[k]);
            }
        }

        int totalCount = 0;
        for (int size = 1; size <= length; size++) {
            int count = 0;
            for (int i = 0; i < length - size + 1; i++) {
                for (int k = 0; k < length - size + 1; k++) {

                    boolean temp = true;
                    for (int x = 0; x < size; x++) {
                        for(int y = 0; y < size; y++){
                            if (arr[i+x][k+y] != 1) {
                                temp = false;
                                break;
                            }
                        }
                    }
                    if(temp) count++;
                }
            }
            totalCount += count;
            if(count != 0) sb.append("size[").append(size).append("]: ").append(count).append("\n");
        }

        System.out.println("total: " + totalCount);
        System.out.println(sb);
    }
}
