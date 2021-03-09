package src.concept;

public class CountingSort {
    public static void main(String[] args) {
        int[] arr = {0, 4, 1, 3, 1, 2, 4, 1};

        countingSort(arr);
    }

    static void countingSort(int[] arr) {
        int[] counts = countArr(arr);
        int[] result = new int[arr.length];

        System.out.println("Start");
        printArr("DATA", arr);
        printArr("COUNTS", counts);
        printArr("TEMP", result);
        System.out.println();

        for (int i = arr.length - 1; i > 0; i--) {
            result[counts[arr[i]]-- - 1] = arr[i];

            printArr("DATA", arr);
            printArr("COUNTS", counts);
            printArr("TEMP", result);
            System.out.println();
        }
    }

    static int[] countArr(int[] arr) {
        int[] counts = new int[maxNum(arr) + 1];
        for (int i : arr) {
            counts[i]++;
        }
        for (int i = 1; i < counts.length; i++) {
            counts[i] += counts[i - 1];
        }
        return counts;
    }

    static int maxNum(int[] arr) {
        int max = 0;
        for (int i : arr) {
            if (max < i) max = i;
        }
        return max;
    }

    static void printArr(String name, int[] arr) {
        System.out.print(name + ":\t");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
