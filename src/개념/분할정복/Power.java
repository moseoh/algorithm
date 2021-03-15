package src.개념.분할정복;

public class Power {
    public static void main(String[] args) {
        int num = 2;
        int exponent = 0;

        System.out.println(basicPower(num, exponent));
        System.out.println(dividePower(num, exponent));
    }

    static int basicPower(int base, int exponent) {
        int result = 1;
        for (int i = exponent; i >= 0; i--) {
            if (i == 0) result *= 1;
            else result *= base;
        }
        return result;
    }

    static int dividePower(int base, int exponent) {
        if (exponent == 0) return 1;
        if (exponent == 1) return base;

        if (exponent % 2 == 0) {
            return dividePower(base, exponent / 2)
                    * dividePower(base, exponent / 2);
        } else {
            return dividePower(base, (exponent - 1) / 2)
                    * dividePower(base, (exponent - 1) / 2)
                    * base;
        }
    }
}
