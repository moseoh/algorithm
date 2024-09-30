package src.baekjun.해시;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 문자열_지옥에_빠진_호석 {

    static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};
    static String[] STRING_MAP;
    static Map<String, Integer> MAP;
    static Set<String> PREFIX_SET;
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        STRING_MAP = new String[N];
        for (int i = 0; i < N; i++) {
            STRING_MAP[i] = br.readLine();
        }

        String[] answer = new String[K];
        MAP = new HashMap<>();
        PREFIX_SET = new HashSet<>();
        for (int i = 0; i < K; i++) {
            answer[i] = br.readLine();
            MAP.put(answer[i], 0);
            for (int j = 1; j <= answer[i].length(); j++) {
                PREFIX_SET.add(answer[i].substring(0, j));
            }
        }

        StringBuilder str = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int k = 0; k < M; k++) {
                record(i, k, str);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            sb.append(MAP.get(answer[i])).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static void record(int x, int y, StringBuilder str) {
        str.append(STRING_MAP[x].charAt(y));
        String currentStr = str.toString();

        if (!PREFIX_SET.contains(currentStr)) {
            str.deleteCharAt(str.length() - 1);
            return;
        }

        if (MAP.containsKey(currentStr)) {
            MAP.put(currentStr, MAP.getOrDefault(currentStr, 0) + 1);
        }

        if (str.length() == K) {
            str.deleteCharAt(str.length() - 1);
            return;
        }

        for (int i = 0; i < 8; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0) {
                nextX = N - 1;
            } else if (nextX >= N) {
                nextX = 0;
            }

            if (nextY < 0) {
                nextY = M - 1;
            } else if (nextY >= M) {
                nextY = 0;
            }

            record(nextX, nextY, str);
        }
        str.deleteCharAt(str.length() - 1);
    }
}
