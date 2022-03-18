package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 스타트와링크 {
    static int N;
    static int[][] arr;
    static int ans = Integer.MAX_VALUE;
    static boolean[] team = new boolean[21];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int k = 1; k <= N; k++) {
                arr[i][k] = Integer.parseInt(st.nextToken());
            }
        }
        makeTeam(1, 0);
        System.out.println(ans);
    }

    static void makeTeam(int idx, int cnt) {
        if (cnt >= N / 2) {
            calState();
            return;
        }

        for (int i = idx; i <= N; i++) {
            if (!team[i]) {
                team[i] = true;
                makeTeam(i, cnt + 1);
                team[i] = false;
            }
        }
    }

    static void calState() {
        int star = 0;
        int link = 0;

        for (int i = 1; i <= N; i++) {
            for (int k = 1; k <= N; k++) {
                if(i==k) continue;
                if (team[i] && team[k]) star += arr[i][k];
                if (!team[i] && !team[k]) link += arr[i][k];
            }
        }

        ans = Math.min(ans, Math.abs(star - link));
    }
}
