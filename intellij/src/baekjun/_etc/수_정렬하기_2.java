package src.baekjun._etc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class 수_정렬하기_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n];
        ArrayList<Integer> list = new ArrayList<>();

        int count = 0;
        int index = k - 1;
        while (count < n) {
            if (index >= n) {
                index -= n;
            }

            System.out.println(Arrays.toString(visited));

            if (!visited[index]) {
                visited[index] = true;
                list.add(index + 1);
                index += k;
                count++;
            } else {
                index++;
            }
        }

        System.out.println(list);

    }
}
