package src.baekjun.이분탐색;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class 수_찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr1);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (hasNumber(arr1, n, num)) sb.append("1\n");
            else sb.append("0\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean hasNumber(int[] arr, int n, int num) {
        int min = 0;
        int max = n;

        while (min < max) {
            int mid = (min + max) >> 1;
            if (arr[mid] == num) {
                return true;
            } else if (arr[mid] < num) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return false;
    }
}
