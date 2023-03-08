package src.개념.archive.sort;

public class QuickSort {
    //    static String test = "1 5 4 -1 0 55 55 32 48 6 41 15 23 35 22";
    static String test = "1 5 4 -1 0 55 55 32 48 6 41 15 23 35 22 111 100 125 26 487 -5 -15 -15 -12 54 885 12 111 32 518";

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        String[] tempString = test.split(" ");
        int[] num = new int[tempString.length];
        int[] result = new int[tempString.length];
        boolean[] isSorted = new boolean[tempString.length];
        for (int i = 0; i < num.length; i++) {
            num[i] = Integer.parseInt(tempString[i]);
        }

        printArray(num);
        int sortCount = 0;
        while (sortCount < isSorted.length) {
            // 정렬이 안된 배열 찾기
            int startIndex = -1;
            int endIndex = -1;
            int arrCount = 0;

            // startIndex 찾기
            for (int i = 0; i < isSorted.length; i++) {
                if (!isSorted[i]) {
                    startIndex = i;
                    break;
                }
            }

            // endIndex 찾기
            for (int i = startIndex; i < isSorted.length; i++) {
                if (!isSorted[i]) arrCount++;
                else break;
            }

            if (startIndex != -1) endIndex = startIndex + arrCount - 1;
            if (startIndex == endIndex && startIndex != -1) {
                isSorted[startIndex] = true;
                sortCount++;
                printArray(num);
                printBooleanArray(isSorted);
                continue;
            }

            // 축 => 여기서는 중심 축
            int pivot = startIndex + (endIndex - startIndex) / 2;
            int leftIndex = 0;
            int rightIndex = 0;
            System.out.println("pivot: " + num[pivot]);

            // 왼쪽
            for (int i = startIndex; i < endIndex; i++) {
                if (num[pivot] <= num[i]) {
                    leftIndex = i;
                    break;
                }
            }

            // 오른쪽
            for (int i = endIndex; i >= startIndex; i--) {
                if (num[pivot] > num[i]) {
                    rightIndex = i;
                    break;
                }
                if (i == leftIndex) {
                    rightIndex = leftIndex;
                    break;
                }
            }

            if (leftIndex == rightIndex) {
                isSorted[leftIndex] = true;
                sortCount++;
                num = swap(leftIndex, pivot, num);
                printArray(num);
                printBooleanArray(isSorted);
            } else {
                System.out.println("left: " + num[leftIndex] + ", right: " + num[rightIndex]);
                num = swap(leftIndex, rightIndex, num);
                printArray(num);
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("수행 시간: " + (endTime - startTime) / 1000.0 + "초");
    }

    static int[] swap(int x, int y, int[] num) {
        int temp = 0;
        temp = num[x];
        num[x] = num[y];
        num[y] = temp;
        return num;
    }

    static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void printBooleanArray(boolean[] arr) {
        for (boolean i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
