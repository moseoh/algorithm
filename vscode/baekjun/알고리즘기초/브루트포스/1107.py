N = int(input())
M = int(input())
buttons = set()
if M == 0:
    buttons = set()
else:
    buttons = set(map(int, input().split()))


def can_press(channel, broken):
    if channel == 0:
        return 0 not in broken

    while channel > 0:
        if channel % 10 in broken:
            return False
        channel //= 10
    return True


# 기본: +/- 버튼만 사용
answer = abs(N - 100)

# 숫자 버튼으로 직접 이동 시도
for i in range(1000001):
    if can_press(i, buttons):
        answer = min(answer, len(str(i)) + abs(N - i))

print(answer)
