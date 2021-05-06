package src.programmers.SummerCoding2018.level2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 영어끝말잇기
 * https://programmers.co.kr/learn/courses/30/lessons/12981
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-28
 */
public class 영어끝말잇기 {
    public static void main(String[] args) {
        int n = 2;
        String[] words = {"hello", "one", "even", "never", "now", "world", "draw"};
        System.out.println(Arrays.toString(new Solution().solution(n, words)));
    }

    // 단어가 이어지지 않거나
    // 중복된 단어를 말하거나

    static class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {};
            Set<String> wordSet = new HashSet<>();

            String temp = " ";
            boolean done = false;
            int index;
            for (index = 0; index < words.length; index++) {
                String word = words[index];
                if (index != 0) {
                    if (wordSet.contains(word)) break;
                    if (temp.charAt(temp.length() - 1) != word.charAt(0)) break;
                }
                temp = word;
                wordSet.add(word);
                if (index == words.length - 1) done = true;
            }

            if (done) return new int[]{0, 0};
            else {
                int x = index % n + 1;
                int y = index / n + 1;
                return new int[] {x, y};
            }
        }
    }
}
