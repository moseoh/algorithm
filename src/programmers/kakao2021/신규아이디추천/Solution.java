package src.programmers.kakao2021.신규아이디추천;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String new_id = br.readLine();
        System.out.println(solution(new_id));
    }

    public static String solution(String new_id) throws Exception {
        // 1단계 : 소문자 만들기
        // 2단계 : 소문자, 숫자, -, _, . 제외 문자 제거
        // 3단계 : '.'이 두개 이상 연속되면 => '.'
        // 4단계 : 아이디의 처음이나 끝에 위치한 '.' 제거
        String answer = new_id.toLowerCase()
                .replaceAll("^a-z0-9-_.", "")
                .replaceAll("[.]+", ".")
                .replaceAll("^\\.|\\.$", "");
        // 5단계 : 빈 문자열이라면 "a" 대입
        if (answer.equals("")) answer = "a";
        // 6단계 : 길이가 16자 이상이라면 앞에서부터 15개 문자를 가져온다.
        // 만약 제거후 마침표(.)가 끝에 위치한다면 제거
        if (answer.length() > 15)
            answer = answer.substring(0, 15)
                    .replaceAll("\\.$", "");

        // 7단계 : 길이가 2자 이하라면, new_id의 마지막 문자를 길이가 3될때 까지 반복 더하기
        if (answer.length() <= 2) {
            while (answer.length() < 3) {
                answer += answer.charAt(answer.length() - 1);
            }
        }
        return answer;
    }
}
