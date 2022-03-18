package src.baekjun.백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class 암호만들기 {
    static int L;
    static int C;
    static char[] words;
    static boolean[] isVowels;
    static boolean[] isVisited;
    static StringBuilder ans = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        words = new char[C];
        isVowels = new boolean[C];
        isVisited = new boolean[C];
        for (int i = 0; i < C; i++) {
            words[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(words);
        for (int i = 0; i < C; i++) {
            if (words[i] == 'a' ||
                    words[i] == 'e' ||
                    words[i] == 'i' ||
                    words[i] == 'o' ||
                    words[i] == 'u')
                isVowels[i] = true;
        }

        makePassword(0, 0, 0, new StringBuilder());

        System.out.println(ans);
    }

    static void makePassword(int idx, int vowCnt, int conCnt, StringBuilder sb) {
        if (sb.length() >= L) {
            if (vowCnt >= 1 && conCnt >= 2) {
                ans.append(sb).append("\n");
            }
            return;
        }

        for (int i = idx; i < C; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                if (isVowels[i]) {
                    makePassword(i, vowCnt + 1, conCnt, sb.append(words[i]));
                } else {
                    makePassword(i, vowCnt, conCnt + 1, sb.append(words[i]));
                }
                sb.setLength(sb.length()-1);
                isVisited[i] = false;
            }
        }


    }
}
