package src.baekjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Temp {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = 1;

        int a = 1 << 'Z' - 'A';
        int b = 1 << 'Y' - 'A';
        System.out.println(a);
        System.out.println(b);
        System.out.println(a+b);
        System.out.println(a & b);
        System.out.println(a | b);
        System.out.println(1 << 'C' - 'A');
        System.out.println(1 << 'B' - 'A');
        System.out.println(1 << 'A' - 'A');
    }
}
