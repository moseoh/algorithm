import sys

input = sys.stdin.readline

# 입력
n = int(input())
A = list(map(int, input().split()))

# Step 1: DP 배열 초기화
dp = [1] * n  # 자기 자신만 선택하면 길이 1

# Step 2: DP 계산
for i in range(1, n):
    for j in range(i):
        if A[j] < A[i]:  # 증가 조건
            dp[i] = max(dp[i], dp[j] + 1)

# Step 3: LIS 길이와 끝 위치 찾기
lis_length = max(dp)
print(lis_length)

# Step 4: 역추적으로 실제 수열 복원
result = []
current_length = lis_length
last_value = float("inf")  # 처음엔 무한대 (아무 값이나 선택 가능)

# 뒤에서 앞으로 탐색
for i in range(n - 1, -1, -1):
    if dp[i] == current_length and A[i] < last_value:
        result.append(A[i])
        last_value = A[i]
        current_length -= 1
        if current_length == 0:
            break

# 역순으로 찾았으므로 뒤집기
result.reverse()
print(*result)
