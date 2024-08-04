package src.baekjun.큐;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class 덱3 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Deck deck = new Deck();

        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            String[] temp = br.readLine().split(" ");
            switch (temp[0]) {
                case "push_front":
                    deck.pushFront(Integer.parseInt(temp[1]));
                    break;
                case "push_back":
                    deck.pushBack(Integer.parseInt(temp[1]));
                    break;
                case "pop_front":
                    bw.write(deck.popFront() + "\n");
                    break;
                case "pop_back":
                    bw.write(deck.popBack() + "\n");
                    break;
                case "size":
                    bw.write(deck.size() + "\n");
                    break;
                case "empty":
                    bw.write(deck.empty() + "\n");
                    break;
                case "front":
                    bw.write(deck.front() + "\n");
                    break;
                case "back":
                    bw.write(deck.back() + "\n");
                    break;
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Deck {
        List<Integer> list = new ArrayList<>();

        public void pushFront(int i) {
            list.add(0, i);
        }

        public void pushBack(int i) {
            list.add(i);
        }

        public int popFront() {
            if (list.size() == 0) return -1;
            else {
                int num = list.get(0);
                list.remove(0);
                return num;
            }
        }

        public int popBack() {
            if (list.size() == 0) return -1;
            else {
                int num = list.get(list.size() - 1);
                list.remove((list.size() - 1));
                return num;
            }
        }

        public int size() {
            return list.size();
        }

        public int empty() {
            if (list.size() == 0) return 1;
            else return 0;
        }

        public int front() {
            if (list.size() == 0) return -1;
            else return list.get(0);
        }

        public int back() {
            if (list.size() == 0) return -1;
            else return list.get(list.size() - 1);
        }
    }
}
