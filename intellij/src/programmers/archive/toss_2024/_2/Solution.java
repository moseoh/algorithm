package src.programmers.archive.toss_2024._2;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 예시 입력
        int[] customers = {12, 39, 16}; // 시간별 고객 수
        int[] modelCapacities = {5, 19, 39}; // AI 모델의 1시간당 처리 가능 고객 수
        int[] modelCosts = {3, 9, 19}; // AI 모델의 1시간당 비용
        int result = solution.solution(customers, modelCapacities, modelCosts);
        System.out.println(result); // 결과 출력: 55
    }

    public int solution(int[] customers, int[] modelCapacities, int[] modelCosts) {
        int n = customers.length;  // 시간대의 수
        int m = modelCapacities.length;  // AI 상담원 모델의 수
        int totalCost = 0;  // 총 비용

        for (int customerCount : customers) {
            int minCost = Integer.MAX_VALUE;

            // 가능한 모든 모델 조합 탐색
            for (int mask = 1; mask < (1 << m); mask++) {
                int capacitySum = 0;
                int costSum = 0;

                for (int j = 0; j < m; j++) {
                    if ((mask & (1 << j)) != 0) {
                        capacitySum += modelCapacities[j];
                        costSum += modelCosts[j];
                    }
                }

                if (capacitySum >= customerCount) {
                    minCost = Math.min(minCost, costSum);
                }
            }

            totalCost += minCost;
        }

        return totalCost;
    }
}
