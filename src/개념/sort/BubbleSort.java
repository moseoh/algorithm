package src.개념.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {55, 7, 78, 12, 42};

        bubbleSortASC(arr);
    }

    static void bubbleSortASC(int[] arr) {
        System.out.println("Start");
        printArr(arr);
        for( int x = arr.length; x > 0; x--){
            for (int i = 0; i < x - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
                printArr(arr);
            }
            System.out.println();
        }
    }

    static void printArr(int[] arr) {
        System.out.print("arr: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
