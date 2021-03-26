package src.programmers.kakao2021.순위검색;

import java.util.Arrays;

class Solution {

    static class Applicant {
        String language;
        String aDirectForce;
        String career;
        String soulFood;
        int codingTestScore;

        public Applicant(String language, String aDirectForce, String career, String soulFood, int codingTestScore){
            this.language = language;
            this.aDirectForce = aDirectForce;
            this.career = career;
            this.soulFood = soulFood;
            this.codingTestScore = codingTestScore;
        }
    }

    public static void main(String[] args) throws Exception {
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }
    public static int[] solution(String[] info, String[] query) {
        int[] answer = {};
        Applicant[] applicants = new Applicant[info.length];
        for(int i =0; i < applicants.length; i++ ) {
            String[] temp = info[i].split(" ");
            applicants[i] = new Applicant(temp[0], temp[1], temp[2], temp[3], Integer.parseInt(temp[4]));
        }


        return answer;
    }
}
