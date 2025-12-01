n = int(input())
arr = list(map(int, input().split()))
dp = [[0 for _ in range(2)] for _ in range(n)]
# 0 현재까지 수열 합, 1 한개 재거한 수열
dp[0][0] = arr[0]
dp[0][1] = 0

result = arr[0]
for i in range(1, n):
    dp[i][0] = max(dp[i - 1][0] + arr[i], arr[i])
    dp[i][1] = max(dp[i - 1][0], dp[i - 1][1] + arr[i])
    result = max(result, max(dp[i]))

print(result)
