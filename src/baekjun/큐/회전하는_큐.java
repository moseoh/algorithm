package src.baekjun.큐;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 회전하는_큐
 * 주소
 * Github : http://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-10-28
 */
public class 회전하는_큐 {
    static int index = 1;
    static int count = 0;
    static int num, N;
    static boolean[] isNull;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        isNull = new boolean[N + 1];
        st.nextToken();

        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        int temp = 10;
        while (st.hasMoreTokens()) {
            System.out.println(index);
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= N; i++) {
                if (!isNull[i]) sb.append(i);
                sb.append("\t");
            }
            System.out.println(sb);

            if(index == num)

            if(true) {
                moveRight();
            } else {
                moveLeft();
            }
            isNull[index] = true;
            num = Integer.parseInt(st.nextToken());
        }

        System.out.println(count);
    }

    public static void moveRight() {
        index++;
        checkIndex();
        count++;
        if(index == num) return;
        if (isNull[index]) {
            count--;
        }
        moveRight();
    }

    public static void moveLeft() {
        index++;
        checkIndex();
        count++;
        if(index == num) return;
        if(isNull[index]) moveLeft();
    }

    public static void checkIndex() {
        if (index < 1) {
            index = N;
            return;
        }
        if (index > N) {
            index = 1;
        }
    }
}
/*
1 2 3 4 5 6
 */