package src.baekjun.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 나무_자르기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int treeCount = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int[] trees = new int[treeCount];
        String[] s = br.readLine().split(" ");
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < treeCount; i++) {
            trees[i] = Integer.parseInt(s[i]);
            max = Math.max(max, trees[i]);
        }

        int left = 0;
        int right = max;

        while (left < right) {
            int mid = (right + left) / 2;
            if (isPossible(trees, mid, score)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        bw.write((left - 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean isPossible(int[] trees, int height, int score) {
        long currentScore = 0;
        for (int tree : trees) {
            int diff = tree - height;
            if (diff > 0) {
                currentScore += diff;
            }
        }
        return currentScore >= score;
    }
}