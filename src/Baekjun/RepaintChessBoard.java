package src.Baekjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RepaintChessBoard {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String chessBoardStr[] = br.readLine().split(" ");
        int n = Integer.parseInt(chessBoardStr[0]);
        int m = Integer.parseInt(chessBoardStr[1]);
        int white = 0;
        int black = 0;
        int whiteMin = 0;
        int blackMin = 0;
        boolean chessBoard[][] = new boolean[Integer.parseInt(chessBoardStr[0])][Integer.parseInt(chessBoardStr[1])];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                if (line.charAt(j) == 'B') {
                    chessBoard[i][j] = true;
                }
            }
        }

        for (int a = 0; a <= n - 8; a++) {
            for (int b = 0; b <= m - 8; b++) {
                for (int i = a; i < a + 8; i++) {
                    for (int j = b; j < b + 8; j++) {
                        if (j % 2 == i % 2) {
                            if (chessBoard[i][j] == false) {
                                black++;
                            } else {
                                white++;
                            }
                        } else {
                            if (chessBoard[i][j] == true) {
                                black++;
                            } else {
                                white++;
                            }
                        }
                    }
                }

                if (whiteMin == 0 && blackMin == 0) {
                    whiteMin = white;
                    blackMin = black;
                } else {
                    whiteMin = whiteMin > white ? white : whiteMin;
                    blackMin = blackMin > black ? black : blackMin;
                }

                white = 0;
                black = 0;

            }
        }

        System.out.println(whiteMin > blackMin ? blackMin : whiteMin);

    }
}
