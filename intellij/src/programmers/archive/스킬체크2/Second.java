package src.programmers.archive.스킬체크2;

public class Second {
    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {"BACDE", "CBADF", "AECB", "BDA"};
        new Solution22().solution(skill, skill_trees);
    }
}

class Solution22 {
    public int solution(String skill, String[] skill_trees) {
        String pattern = "[A-Z^C]*C?[A-Z^B]*B?[A-Z^D]*D?[A-Z]*";
        System.out.println(skill_trees[0].matches(pattern));
        System.out.println(skill_trees[1].matches(pattern));
        System.out.println(skill_trees[2].matches(pattern));
        System.out.println(skill_trees[3].matches(pattern));
        int answer = 0;

        return answer;
    }
}