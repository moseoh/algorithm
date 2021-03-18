package src;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Temp {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        for(Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();

        list.add(1, 7);
        list.add(1, 6);
        list.add(1, 5);

        for(Integer integer : list) {
            System.out.print(integer + " ");
        }
    }
}
