package src.테스트;

import java.util.HashMap;
import java.util.Map;

/**
 * Solution2
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-03
 */

class Solution2 {
    public static void main(String[] args) {
        int[][] needs = {{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}};
        int r = 2;
        System.out.println(solution(needs, r));
    }

    static Map<String, Integer> map = new HashMap<>();
    public static int solution(int[][] needs, int r) {
        int answer = 0;

        for (int i = 0; i < needs.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int k = 0; k < needs[i].length; k++) {
                if (needs[i][k] == 1) temp.append(k);
            }
            if (map.getOrDefault(temp.toString(), 0) == 0) {
                map.put(temp.toString(), 1);
            } else {
                map.put(temp.toString(), map.get(temp.toString()) + 1);
            }
        }

        System.out.println(map.toString());

        int[] arr = new int[needs[0].length];
        for(int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= r; i++) {
            System.out.println("\n" + arr.length + " 개 중에서 " + i + " 개 뽑기");
            combination(arr, new boolean[arr.length], 0, arr.length, i);
        }

        if(needs[0].length == r) {
            for(String key: map.keySet()) answer += map.getOrDefault(key, 0);
        } else {

        }
        return answer;
    }

    static void combination(int[] arr, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            print(arr, visited, n);
            return;
        }

        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(arr, visited, i + 1, n, r - 1);
            visited[i] = false;
        }
    }

    // 배열 출력
    static void print(int[] arr, boolean[] visited, int n) {
        String temp = "";
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                temp += i;
            }
        }
        System.out.println("temp : " + temp);
        System.out.println("map : " + map.getOrDefault(temp,0));
    }
}
