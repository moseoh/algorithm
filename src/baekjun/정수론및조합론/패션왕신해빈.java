package src.baekjun.정수론및조합론;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 패션왕신해빈
 * https://www.acmicpc.net/problem/9375
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-30
 */
public class 패션왕신해빈 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            Map<String, Integer> clothMap= new HashMap<>();
            while (num-- > 0) {
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String clothKind = st.nextToken();
                int count = clothMap.getOrDefault(clothKind, 0);
                clothMap.put(clothKind, count + 1);
            }

            int result = 1;
            for(String key : clothMap.keySet())
                result *= clothMap.get(key)+1;
            result--;

            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }
}
