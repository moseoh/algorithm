package src.테스트;

/**
 * Solution3
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-03
 */
class Solution3 {
    public static void main(String[] args) {
        int n = 6;
//        int[] passenger = {1, 1, 1, 1, 1, 1};
//        int[][] train = {{1, 2}, {1, 3}, {1, 4}, {3, 5}, {3, 6}};
        int[] passenger = {2,1,2,2};
        int[][] train = {{1,2},{1,3},{2,4}};

        System.out.println(solution(n, passenger, train));
    }

    static boolean[] isVisited;
    static int index = 0;
    static int result = 0;

    public static int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {0,0};
        isVisited = new boolean[n+1];
        isVisited[1] = true;
        train(1, passenger, train, passenger[0]);

        System.out.println(answer[0]);
        System.out.println(answer[1]);

        return answer;
    }

    static void train(int pos, int[] passenger, int[][] train, int passengers) {

        for (int i = 0; i < train.length; i++) {
            if (train[i][0] == pos)
                if (!isVisited[train[i][1]]) {
                    isVisited[train[i][1]] = true;
                    train(train[i][1], passenger, train, passengers+passenger[train[i][1]-1]);
                }
        }

        if(result <= passengers) {
            index = pos;
            result = passengers;
        }
    }
}
