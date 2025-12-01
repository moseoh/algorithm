N = int(input())
arr = list(map(int, input().split()))
dp = [1] * N

result = 1
for i in range(1, N):
    for j in range(i - 1, -1, -1):
        if arr[i] < arr[j]:
            dp[i] = max(dp[j] + 1, dp[i])
            result = max(result, dp[i])

print(result)
