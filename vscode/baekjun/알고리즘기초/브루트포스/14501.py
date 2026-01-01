N = int(input())
arr = []
for _ in range(N):
    arr.append(list(map(int, input().split())))

answer = 0


def search(index, cost):
    global answer

    next_index = index + arr[index][0]
    print(f"next_index: {next_index + 1}, index: {index + 1}, cost: {cost}")
    if next_index > N + 1:
        answer = max(answer, cost)
        return

    cost += arr[next_index][1]
    for i in range(next_index, N):
        search(i, cost)


for i in range(N):
    search(i, arr[i][1])

print(answer)
