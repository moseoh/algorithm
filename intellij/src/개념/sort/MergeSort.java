package src.개념.sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(69);
        list.add(10);
        list.add(30);
        list.add(2);
        list.add(16);
        list.add(8);
        list.add(31);
        list.add(22);

        System.out.println("정렬 전 => ");
        for(Integer integer: list) {
            System.out.print(integer + " ");
        }
        System.out.println();

        System.out.println();

        list = mergeSort(list);
        System.out.println();
        System.out.println("정렬 후 => ");
        for(Integer integer: list) {
            System.out.print(integer + " ");
        }
    }

    static List<Integer> mergeSort(List<Integer> list) {
        if (list.size() <= 1) {
            return list;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 0; i < list.size() / 2; i++) {
            left.add(list.get(i));
        }
        for (int i = list.size() / 2; i < list.size(); i++) {
            right.add(list.get(i));
        }

        // List 의 크기가 1이 될 때까지 분할
        System.out.print("left : ");
        for(Integer integer: left) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.print("right : ");
        for(Integer integer: right) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
        left = mergeSort(left);
        right = mergeSort(right);

        // 분할된 List 들 병합
        return merge(left, right);
    }

    static List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> result = new ArrayList<>();

        while(left.size() > 0 && right.size() > 0){
            if(left.get(0) <= right.get(0)){
                result.add(left.get(0));
                left.remove(0);
            } else {
                result.add(right.get(0));
                right.remove(0);
            }
        }

        if(left.size() >0){
            while(left.size() > 0) {
                result.add(left.get(0));
                left.remove(0);
            }
        }
        if(right.size() >0){
            while(right.size() > 0) {
                result.add(right.get(0));
                right.remove(0);
            }
        }

        System.out.print("merge : ");
        for(Integer integer: result) {
            System.out.print(integer + " ");
        }
        System.out.println();
        System.out.println();
        return result;
    }
}