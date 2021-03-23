package src.swexpertacademy.d3.암호문3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("src/swexpertacademy/d3/암호문3/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= 10; test_case++) {
            sb.append("#").append(test_case).append(" ");

            // 원본 암호 받기
            int length = Integer.parseInt(br.readLine());
            List<Integer> passPhrase = new LinkedList<>();
            String[] temp = br.readLine().split(" ");
            for (int i = 0; i < length; i++) {
                passPhrase.add(Integer.parseInt(temp[i]));
            }

            length = Integer.parseInt(br.readLine());
            temp = br.readLine().split(" ");
            for (int i = 0; i < temp.length; ) {
                if (temp[i].equals("I")) {
                    // 삽입할 위치와 암호문 받기
                    int position = Integer.parseInt(temp[i + 1]);
                    int number = Integer.parseInt(temp[i + 2]);
                    List<Integer> insertPassPhrase = new LinkedList<>();
                    for (int k = i + 3; k < i + 3 + number; k++) {
                        insertPassPhrase.add(Integer.parseInt(temp[k]));
                    }
                    insert(position, insertPassPhrase, passPhrase);
                    // 탐색한 만큼 건너 뛰기
                    i = i + 3 + number;
                    continue;
                }
                if (temp[i].equals("D")) {
                    // 삭제할 위치와 갯수 받기
                    int position = Integer.parseInt(temp[i + 1]);
                    int number = Integer.parseInt(temp[i + 2]);
                    delete(position, number, passPhrase);
                    i = i + 3;
                    continue;
                }
                if (temp[i].equals("A")) {
                    // 추가할 갯수와 암호문 받기
                    int number = Integer.parseInt(temp[i + 1]);
                    List<Integer> addPassPhrase = new LinkedList<>();
                    for (int k = i + 2; k < i + 2 + number; k++) {
                        addPassPhrase.add(Integer.parseInt(temp[k]));
                    }
                    add(addPassPhrase, passPhrase);
                    i = i + 2 + number;
                }
            }

            // 열개만 출력
            for (int i = 0; i < 10; i++) {
                sb.append(passPhrase.get(i));
                if (i < 10 - 1) {
                    sb.append(" ");
                }
            }

            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void insert(int position, List<Integer> insertPassPhrase, List<Integer> passPhrase) {
        for (int i = insertPassPhrase.size() - 1; i >= 0; i--) {
            passPhrase.add(position, insertPassPhrase.get(i));
        }
    }

    static void delete(int position, int number, List<Integer> passPhrase) {
        while (number-- > 0) {
            passPhrase.remove(position);
        }
    }

    static void add(List<Integer> addPassPhrase, List<Integer> passPhrase) {
        passPhrase.addAll(addPassPhrase);
    }
}
