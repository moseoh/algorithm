package src.시험;

import java.util.Arrays;

/**
 * test4
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-08
 */
public class test4 {
    public static void main(String[] args) {
        String[][] places = {{

                "OOOOO",
                "OOOOP",
                "OOOOP",
                "OOOOO",
                "OOOOO"},

                {
                "OOOOP",
                "OOOOP",
                "OOOOO",
                "OOOOO",
                "OOOOO"},

                {
                "OOOOP",
                "OOOPX",
                "OOOOP",
                "OOOOO",
                "OOOOO"},

                {
                "OOOOO",
                "OOOOO",
                "OOOOO",
                "OOOOO",
                "OOOOO"},

                    {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(new Solution().solution(places)));
    }

    static class Solution {
        public int[] solution(String[][] places) {
            int[] answer = new int[5];

            for (int i = 0; i < 5; i++) {
                boolean result = true;
                for (int j = 0; j < 5; j++) {
                    for (int k = 0; k < 5; k++) {
                        if (places[i][j].charAt(k) == 'P') {
                            // 상하좌우
                            if (j + 1 < 5 && places[i][j + 1].charAt(k) == 'P') {
                                result = false;
                                break;
                            }
                            if (j - 1 > 0 && places[i][j - 1].charAt(k) == 'P') {
                                result = false;
                                break;
                            }
                            if (k - 1 > 0 && places[i][j].charAt(k - 1) == 'P') {
                                result = false;
                                break;
                            }
                            if (k + 1 < 5 && places[i][j].charAt(k + 1) == 'P') {
                                result = false;
                                break;
                            }

                            // 한칸 띈 곳
                            if (j + 2 < 5 && places[i][j + 2].charAt(k) == 'P' && places[i][j + 1].charAt(k) == 'O') {
                                result = false;
                                break;
                            }
                            if (j - 2 > 0 && places[i][j - 2].charAt(k) == 'P' && places[i][j - 1].charAt(k) == 'O') {
                                result = false;
                                break;
                            }
                            if (k - 2 > 0 && places[i][j].charAt(k - 2) == 'P' && places[i][j].charAt(k - 1) == 'O') {
                                result = false;
                                break;
                            }
                            if (k + 2 < 5 && places[i][j].charAt(k + 2) == 'P' && places[i][j].charAt(k + 1) == 'O') {
                                result = false;
                                break;
                            }

                            // 대각선
                            if (j + 1 < 5 && k + 1 < 5 && places[i][j + 1].charAt(k + 1) == 'P' && (places[i][j].charAt(k + 1) == 'O' || places[i][j + 1].charAt(k) == 'O')) {
                                result = false;
                                break;
                            }
                            if (j + 1 < 5 && k - 1 > 0 && places[i][j + 1].charAt(k - 1) == 'P' && (places[i][j].charAt(k - 1) == 'O' || places[i][j + 1].charAt(k) == 'O')) {
                                result = false;
                                break;
                            }
                            if (j - 1 > 0 && k + 1 < 5 && places[i][j - 1].charAt(k + 1) == 'P' && (places[i][j].charAt(k + 1) == 'O' || places[i][j - 1].charAt(k) == 'O')) {
                                result = false;
                                break;
                            }
                            if (j - 1 > 0 && k - 1 > 0 && places[i][j - 1].charAt(k - 1) == 'P' && (places[i][j].charAt(k - 1) == 'O' || places[i][j - 1].charAt(k) == 'O')) {
                                result = false;
                                break;
                            }
                        }
                    }
                    if (!result) break;
                }
                answer[i] = result ? 1 : 0;
            }

            return answer;
        }
    }
}
