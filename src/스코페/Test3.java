package src.스코페;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

class Main3 {
    static int N, Q;
    static boolean[] isTop;
    static HashMap<Integer, List<Integer>> setMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        isTop = new boolean[N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int top = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            if (!setMap.containsKey(top))
                setMap.put(top, new ArrayList<>());
            setMap.get(top).add(bottom);
            isTop[top] = true;
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int top = Integer.parseInt(st.nextToken());
            int bottom = Integer.parseInt(st.nextToken());
            if (!setMap.containsKey(top)) {
                sb.append("no").append("\n");
                continue;
            }

            if (search(top, bottom)) {
                sb.append("yes").append("\n");
            } else {
                sb.append("no").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean search(int top, int bottom) {
        List<Integer> list = setMap.get(top);
        if (list.contains(bottom)) return true;
        for (int i = 0; i < list.size(); i++) {
            if (isTop[list.get(i)])
                if (search(list.get(i), bottom))
                    return true;
        }
        return false;
    }
}
