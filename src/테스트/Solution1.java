package src.테스트;

/**
 * Solution1
 * 주소
 * Github : https://github.com/azqazq195
 * Created by azqazq195@gmail.com on 2021-04-03
 */
class Solution1 {
    public static void main(String[] args) {
        int[] gift_cards1 = {4, 5, 3, 2, 1};
        int[] gift_cards2 = {5, 4, 5, 4, 5};
        int[] gift_cards3 = {5,5,5,5,5};
        int[] wants1 = {2, 4, 4, 5, 1};
        int[] wants2 = {1, 2, 3, 5, 4};
        int[] wants3 = {5,5,5,5,5};

        System.out.println(solution(gift_cards3,wants3));
    }

    public static int solution(int[] gift_cards, int[] wants) {
        int answer = 0;
        int[] num = new int[100001];
        for(int gift_card : gift_cards) {
            num[gift_card]++;
        }
        for(int want : wants) {
            if(num[want] != 0)
                num[want]--;
        }
        for(int n : num) {
            answer += n;
        }

        return answer;
    }
}