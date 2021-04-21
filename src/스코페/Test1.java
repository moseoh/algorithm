package src.스코페;

import java.io.*;
import java.util.*;

class Main {
    static int N;
    static int[] timeLimit = new int[3];
    static int[][] times;
    static int ans = Integer.MIN_VALUE;
    static int index = -1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        String[] temp = st.nextToken().split(":");
        for (int i = 0; i < 3; i++) {
            timeLimit[i] = Integer.parseInt(temp[i]);
        }
        times = new int[N][3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), ":");
            times[i][1] = Integer.parseInt(st.nextToken());
            times[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            run(i);
        }

        System.out.println(ans + " " + (index+1));
    }

    static void run(int pos) {
        int count = 0;
        int[] sum = new int[3];
        for (int i = pos; i < N; i++) {
            sum[1] += times[i][1];
            sum[2] += times[i][2];

            if (sum[2] >= 60) {
                sum[1]++;
                sum[2] -= 60;
            }

            if (sum[1] >= 60) {
                sum[0]++;
                sum[1] -= 60;
            }
            count++;
            if(sum[0]*60*60 + sum[1]*60 + sum[2] >=
            timeLimit[0]*60*60 + timeLimit[1]*60 + timeLimit[2]) {
                if(ans < count) {
                    ans = count;
                    index = pos;
                }
                return;
            }
        }
    }
}