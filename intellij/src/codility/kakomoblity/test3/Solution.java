package src.codility.kakomoblity.test3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        int N = 2;
        String S = "1A 2F 1C";
        System.out.println(solution(N, S));
    }

    static boolean[][] seats;

    public static int solution(int N, String S) {
        seats = enableSeats(N, S);
        return count();
    }

//    public static void print() {
//        for (boolean[] seat : seats) {
//            for (int k = 0; k < seats[0].length; k++) {
//                System.out.print(seat[k] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();
//    }

    public static int count() {
        int count = 0;
        int[] searchIndexArray = {1, 3, 5};

        for (int i = 0; i < seats.length; i++) {
            for (int searchIndex : searchIndexArray) {
                if (canReservation(seats[i], searchIndex)) {
                    reservation(i, searchIndex);
                    count++;
                }
            }
        }

        return count;
    }

    public static void reservation(int row, int index) {
        for (int i = index; i < index + 4; i++) {
            seats[row][i] = true;
        }
    }

    public static boolean canReservation(boolean[] seat, int index) {
        for (int i = index; i < index + 4; i++) {
            if (seat[i]) return false;
        }
        return true;
    }

    public static boolean[][] enableSeats(int N, String S) {
        seats = new boolean[N][10];
        if (S.trim().equals("")) {
            return seats;
        }

        String[] arr = S.split(" ");
        Pattern numPattern = Pattern.compile("([\\d]+)");
        Pattern alphaPattern = Pattern.compile("([A-Z])");

        for (String str : arr) {
            Matcher numMatcher = numPattern.matcher(str);
            Matcher alphaMatcher = alphaPattern.matcher(str);
            int num = 0;
            char alpha = 'A';
            if (numMatcher.find()) {
                num = Integer.parseInt(numMatcher.group(0));
            }
            if (alphaMatcher.find()) {
                alpha = alphaMatcher.group(0).charAt(0);
            }
            seats[num - 1][alpha - 'A'] = true;
        }
        return seats;
    }
}