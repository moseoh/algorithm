package src.baekjun.정렬;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * 좌표압축
 * https://www.acmicpc.net/problem/18870
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-28
 */
public class 좌표압축 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];

        for (int i = 0; i < N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);

        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int num: sortNums)
            if(!map.containsKey(num))
                map.put(num, index++);

        StringBuilder sb = new StringBuilder();
        for(int num: nums)
            sb.append(map.get(num)).append(" ");

        System.out.println(sb);
    }

}
