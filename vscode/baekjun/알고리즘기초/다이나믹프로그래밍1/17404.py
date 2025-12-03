N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
ans = INF = float("inf")

for x in range(3):
    dp = [[INF, INF, INF] for _ in range(N)]
    dp[0][x] = arr[0][x]

    for i in range(1, N):
        dp[i][0] = min(
            dp[i - 1][1] + arr[i][0],
            dp[i - 1][2] + arr[i][0],
        )
        dp[i][1] = min(
            dp[i - 1][0] + arr[i][1],
            dp[i - 1][2] + arr[i][1],
        )
        dp[i][2] = min(
            dp[i - 1][0] + arr[i][2],
            dp[i - 1][1] + arr[i][2],
        )

    for i in range(3):
        if i != x:
            ans = min(ans, dp[N - 1][i])

print(ans)
