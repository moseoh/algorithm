package src.swexpertacademy.View;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/View/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    }
}