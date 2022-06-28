package study.week4.example1;

public class Growth {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        int max_virus = 2;
        int[][] queries = {
                { 3, 2 },
                { 3, 2 },
                { 2, 2 },
                { 3, 2 },
                { 1, 4 },
                { 3, 2 },
                { 2, 3 },
                { 3, 1 },
        };
        Solution s = new Solution();
        System.out.println(s.solution(rows, columns, max_virus, queries));
    }

}

class Solution {
    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];

        for (int i = 0; i < queries.length; i++) {
            growth(queries[i][0] - 1, queries[i][1] - 1, max_virus, answer, new boolean[rows][columns]);
        }

        return answer;
    }

    public void growth(int x, int y, int max_virus, int[][] arr, boolean[][] visited) {
        // System.out.printf("x: %d, y: %d\n", x, y);

        if (x < 0 || arr.length <= x || y < 0 || arr[x].length <= y) {
            // System.out.println("Out of Index");
            return;
        }

        if (visited[x][y]) {
            // System.out.println("Visited");
            return;
        }

        visited[x][y] = true;

        if (arr[x][y] < max_virus) {
            arr[x][y]++;
            // print(arr);
            return;
        }

        growth(x + 1, y, max_virus, arr, visited);
        growth(x - 1, y, max_virus, arr, visited);
        growth(x, y + 1, max_virus, arr, visited);
        growth(x, y - 1, max_virus, arr, visited);

    }

    public void print(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int dept = 0; dept < arr.length; dept++) {
            for (int index = 0; index < arr[dept].length; index++) {
                sb.append(arr[dept][index]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        sb.append("\n");
        System.out.println(sb.toString());
    }
}