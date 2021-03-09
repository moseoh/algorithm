package src.swexpertacademy.다른문제;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/패키지명/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }
}
