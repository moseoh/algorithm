package src.스코페;

import java.io.*;

class Main4 {
    static int N, Q;
    static String[] strings;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        strings = new String[N];
        for (int i = 0; i < N; i++) {
            strings[i] = br.readLine();
        }

        Q = Integer.parseInt(br.readLine());
        for(int i=0; i < Q; i++) {
            int cnt = 0;
            String find = br.readLine();
            for(int k=0; k<N; k++) {
                if(strings[k].matches(".*" + find + ".*")){
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}