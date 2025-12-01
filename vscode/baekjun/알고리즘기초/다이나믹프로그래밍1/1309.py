MAX = 100_001
dp = [0] * MAX
dp[1] = 3
dp[2] = 7

for i in range(3, MAX):
    dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901

print(dp[int(input())])
