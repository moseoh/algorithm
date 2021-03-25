package src;

class Temp {
    public static void main(String[] args) {
        boolean[][] arr = new boolean[3][3];
        boolean[][] temp = new boolean[3][3];

        System.out.println("arr");
        for(boolean[] a : arr) {
            for (boolean b: a) System.out.print(b + "\t");
            System.out.println();
        }

        System.out.println();
        System.out.println("temp");
        for(boolean[] a : temp) {
            for (boolean b: a) System.out.print(b + "\t");
            System.out.println();
        }

        arr[1][1] = true;
        System.out.println("arr");
        for(boolean[] a : arr) {
            for (boolean b: a) System.out.print(b + "\t");
            System.out.println();
        }

        System.out.println();
        System.out.println("temp");
        for(boolean[] a : temp) {
            for (boolean b: a) System.out.print(b + "\t");
            System.out.println();
        }

        temp = arr;
        System.out.println("arr");
        for(boolean[] a : arr) {
            for (boolean b: a) System.out.print(b + "\t");
            System.out.println();
        }

        System.out.println();
        System.out.println("temp");
        for(boolean[] a : temp) {
            for (boolean b: a) System.out.print(b + "\t");
            System.out.println();
        }

        arr[0][0] = true;
        System.out.println("arr");
        for(boolean[] a : arr) {
            for (boolean b: a) System.out.print(b + "\t");
            System.out.println();
        }

        System.out.println();
        System.out.println("temp");
        for(boolean[] a : temp) {
            for (boolean b: a) System.out.print(b + "\t");
            System.out.println();
        }
    }
}
