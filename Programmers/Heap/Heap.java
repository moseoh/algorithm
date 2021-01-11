package Programmers.Heap;

import java.util.Random;

public class Heap {
    int[] maxHeap;
    int size;

    public Heap(int capacity) {
        maxHeap = new int[capacity];
        maxHeap[0] = Integer.MAX_VALUE;
    }

    public void printHeap() {
        for (int i = 1; i <= size; i++) {
            System.out.print(maxHeap[i] + " ");
        }
    }

    public int parent(int size) {
        return size / 2;
    }

    public void swap(int a, int b) {
        int temp = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = temp;
    }

    public void addToSort(int data) { // 삽입과 동시에 최대 힙 정렬
        maxHeap[++size] = data;
        int current = size;
        while (maxHeap[current] > maxHeap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int pollToHeap() { // 최대 힙 제거 후 힙 재조정
        int max = maxHeap[1];
        maxHeap[1] = maxHeap[size--];
        heapify(1);
        return max;
    }

    public void heapify(int i) {
        int leftChild = i * 2;
        int rightChild = (i * 2) + 1;
        int lastNode = 0;
        if (rightChild > size) { // 핵심
            return;
        }
        if (maxHeap[leftChild] > maxHeap[rightChild]) {
            lastNode = leftChild;
        } else {
            lastNode = rightChild;
        }
        if (maxHeap[i] >= maxHeap[lastNode]) {
            return;
        }
        swap(i, lastNode);
        heapify(lastNode);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        Heap h = new Heap(5);
        h.addToSort(20);
        h.addToSort(1);
        h.addToSort(7);
        h.addToSort(12);
        h.printHeap();
        System.out.println();
        System.out.println(h.pollToHeap());
        h.printHeap();
        System.out.println();
        System.out.println(h.pollToHeap());
        h.printHeap();
    }
}