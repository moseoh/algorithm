package src.baekjun.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class 좌표정렬하기 {
    static class XY implements Comparable<XY> {

        int x;
        int y;

        @Override
        public int compareTo(XY o) {
            if (this.x == o.x) {
                return this.y - o.y;
            } else {
                return this.x - o.x;
            }
        }
        public XY(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY(){
            return this.y;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        XY[] temp = new XY[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            temp[i] = new XY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(temp);

        for (int i = 0; i < N; i++) {
            System.out.println(temp[i].x + " " + temp[i].y);
        }
    }
}
