n = int(input())

dp = [0] * 1001
dp[1] = 1
dp[2] = 3

if n < 3:
    print(dp[n])
else:
    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10_007
    print(dp[n])
