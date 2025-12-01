N = int(input())
dp = list(map(int, input().split()))
dp.insert(0, 0)

for i in range(1, (N + 1)):
    for j in range(0, i // 2 + 1):
        dp[i] = max(dp[i], dp[i - j] + dp[j])

print(dp[N])
