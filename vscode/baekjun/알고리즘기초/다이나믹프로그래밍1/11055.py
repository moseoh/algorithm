N = int(input())
arr = list(map(int, input().split()))
dp = arr.copy()

for i in range(1, N):
    for j in range(i - 1, -1, -1):
        if arr[i] > arr[j]:
            dp[i] = max(dp[i], dp[j] + arr[i])

print(max(dp))
