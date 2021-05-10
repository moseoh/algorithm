package src.시험;

import java.util.Stack;

/**
 * test5
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-05-08
 */
public class test5 {
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2", "C", "U 3", "C", "D 4", "C", "U 2", "Z", "Z"};
        System.out.println(new Solution().solution(n, k, cmd));
    }

    static class Solution {
        public String solution(int n, int k, String[] cmd) {
            boolean[] isDeleted = new boolean[8];
            Stack<Integer> temp = new Stack<>();
            int pos = k;

            for (int i = 0; i < cmd.length; i++) {
                int num = 0;
                switch (cmd[i].charAt(0)) {
                    case 'U':
                        num = Character.getNumericValue(cmd[i].charAt(2));
                        for (int j = 0; j < num; j++) {
                            if (!isDeleted[pos - 1]) pos--;
                            else {
                                pos--;
                                j--;
                            }
                        }
                        break;
                    case 'D':
                        num = Character.getNumericValue(cmd[i].charAt(2));
                        for (int j = 0; j < num; j++) {
                            if (!isDeleted[pos + 1]) pos++;
                            else {
                                pos++;
                                j--;
                            }
                        }
                        break;
                    case 'C':
                        temp.push(pos);
                        isDeleted[pos] = true;

                        int tempPos = pos;
                        boolean up = false;

                        while (isDeleted[pos]) {
                            if (!up) {
                                if (pos + 1 < n) {
                                    pos++;
                                } else {
                                    pos = tempPos;
                                    up = true;
                                }
                            } else {
                                pos--;
                            }
                        }
                        break;
                    case 'Z':
                        isDeleted[temp.pop()] = false;
                        break;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (boolean b : isDeleted) {
                if (b) sb.append("X");
                else sb.append("O");
            }

            return sb.toString();
        }
    }
}
