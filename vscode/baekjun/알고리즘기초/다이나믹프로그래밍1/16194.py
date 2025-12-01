N = int(input())
dp = list(map(int, input().split()))
dp.insert(0, 0)

for i in range(1, N + 1):
    for j in range(i // 2 + 1):
        dp[i] = min(dp[i], dp[i - j] + dp[j])

print(dp[N])
