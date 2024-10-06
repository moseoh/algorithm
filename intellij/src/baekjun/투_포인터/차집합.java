package src.baekjun.투_포인터;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class 차집합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arrA = new int[a];
        int[] arrB = new int[b];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrA.length; i++) {
            arrA[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arrB.length; i++) {
            arrB[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        List<Integer> list = binarySearch(arrA, arrB);

        StringBuilder sb = new StringBuilder();
        sb.append(list.size());
        if (list.isEmpty()) {
            System.out.println(sb);
            return;
        }

        sb.append("\n");
        for (Integer i : list) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }

    private static List<Integer> twoPointer(int[] arrA, int[] arrB) {
        int indexA = 0;
        int indexB = 0;

        List<Integer> list = new ArrayList<>();
        while (indexA < arrA.length) {
            if (arrA[indexA] < arrB[indexB]) {
                list.add(arrA[indexA]);
                indexA++;
            } else if (arrA[indexA] > arrB[indexB]) {
                if (indexB == arrB.length - 1) {
                    list.add(arrA[indexA]);
                    indexA++;
                } else {
                    indexB++;
                }
            } else {
                indexA++;
            }
        }
        return list;
    }

    private static List<Integer> binarySearch(int[] arrA, int[] arrB) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arrA.length; i++) {
            int left = 0;
            int right = arrB.length - 1;


            boolean flag = false;
            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (arrA[i] == arrB[mid]) {
                    flag = true;
                    break;
                }

                if (arrA[i] > arrB[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (!flag) {
                list.add(arrA[i]);
            }
        }
        return list;
    }
}