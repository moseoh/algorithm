# # O(NlogN)
import sys

input = sys.stdin.readline
MAX = 1_000_001

list = [0] * (MAX + 1)
dp = [0] * (MAX + 1)
for i in range(1, MAX + 1):
    for j in range(i, MAX + 1, i):
        list[j] += i
    dp[i] = dp[i - 1] + list[i]


for i in range(int(input())):
    print(dp[int(input())])
# import sys

# input = sys.stdin.readline

# dp = [0] * 1000001  # 약수의 합을 저장할 list

# for i in range(1, 1000001):
#     for j in range(i, 1000001, i):
#         dp[j] += i  # 배수들에 i를 더해줌 (i를 약수로 가지므로)
#     dp[i] += dp[i - 1]  # 이전단계까지 구한 합을 더해 누적 합 계산

# for tc in range(int(input())):  # 테스트 케이스 개수만큼 반복
#     n = int(input())  # 자연수 n
#     print(dp[n])
