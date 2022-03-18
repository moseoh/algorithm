package practice;

public class Mod {
    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = mod(result + mod(11));
        }
        System.out.println(result);
    }

    public static int mod(int m) {
        int mod = 10;
        return m % mod;
    }
}
