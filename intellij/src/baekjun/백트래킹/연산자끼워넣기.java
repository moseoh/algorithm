package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 연산자끼워넣기 {
    // 0 = +, 1 = -, 2 = *, 3 = /
    static int[] opCnt = new int[4];
    static int[] Num;
    static int N;
    static int max = -1000000000;
    static int min = 1000000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Num = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            Num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            opCnt[i] = Integer.parseInt(st.nextToken());
        }

        backTracking(Num[0], 1);

        System.out.println(max);
        System.out.println(min);
    }

    static void backTracking(int num, int index) {
        if (index == N) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for(int i =0; i < 4; i++) {
            if(opCnt[i] > 0) {
                opCnt[i]--;
                switch (i) {
                    case 0: backTracking(num + Num[index], index + 1); break;
                    case 1: backTracking(num - Num[index], index + 1); break;
                    case 2: backTracking(num * Num[index], index + 1); break;
                    case 3: backTracking(num / Num[index], index + 1); break;
                }
                opCnt[i]++;
            }
        }
    }


}
