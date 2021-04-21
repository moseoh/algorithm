package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 부등호 {

    static int N;
    static String[] arrSign;
    // 0 ~ 9
    static boolean[] isVisited = new boolean[10];
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrSign = br.readLine().split(" ");

        dfs(0, -1,"");

        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
    }

    static void dfs(int prev, int pos, String str) {
        if (pos == N) {
            list.add(str);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if(pos == -1) {
                if(!isVisited[i]) {
                    isVisited[i] = true;
                    dfs(i, 0, str + i);
                    isVisited[i] = false;
                }
            } else {
                if(!isVisited[i]) {
                    if(arrSign[pos].equals("<")) {
                        if (prev >= i) continue;
                    } else {
                        if(prev <= i) continue;
                    }
                    isVisited[i] = true;
                    dfs(i,pos + 1, str + i);
                    isVisited[i] = false;
                }
            }
        }
    }
}
