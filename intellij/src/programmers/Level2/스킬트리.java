package src.programmers.Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class 스킬트리 {
    public static void main(String[] args) {
//        String skill = "CBD";
//        String[] skill_trees = {"CAD"};
//        String[] skill_trees = {"AEF", "ZJW"};
//        String[] skill_trees = {"C", "D", "CB", "BDA"};
//        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};

//        String skill = "REA";
//        String[] skill_trees = {"REA", "POA"};

//        String skill = "BDC";
//        String[] skill_trees = {"AAAABACA"};

        String skill = "CBDK";
        String[] skill_trees =  {"CB", "CXYB", "BD", "AECD", "ABC", "AEX", "CDB", "CBKD", "IJCB", "LMDK"};


        for(int i = 0; i < skill_trees.length; i++){
            System.out.println(i);
            System.out.println(skill_trees[i]);
            String temp = skill_trees[i].replaceAll("[^" + skill + "]","");
            System.out.println(temp);
            System.out.println(skill.indexOf(temp));
            System.out.println();
        }

        new Solution2().solution(skill, skill_trees);
    }

    static class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;

            for (String skill_tree : skill_trees) {
                List<Integer> index = new ArrayList<>();

                for (int k = 0; k < skill_tree.length(); k++) {
                    for (int n = 0; n < skill.length(); n++) {
                        if (skill.charAt(n) == skill_tree.charAt(k)) {
                            index.add(n);
                        }
                    }
                }
                for (int x : index) {
                    System.out.print(x + "\t");
                }
                System.out.println();

                if (index.size() == 0) answer++;
                else {
                    for (int x = 0; x < index.size(); x++) {
                        if (index.get(x) != x) break;
                        if (x == index.size() - 1) answer++;
                    }
                }

            }

            System.out.println("answer: " + answer);
            return answer;
        }
    }

    static class Solution2 {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            ArrayList<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
            Iterator<String> it = skillTrees.iterator();
            while (it.hasNext()) {
                if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                    it.remove();
                }
            }
            answer = skillTrees.size();
            System.out.println("answer: " + answer);
            return answer;
        }
    }
}
