import re
import sys

for line in sys.stdin:
    result = [0] * 4
    for char in line:
        if re.match(r"[a-z]", char):
            result[0] += 1
        if re.match(r"[A-Z]", char):
            result[1] += 1
        if re.match(r"[0-9]", char):
            result[2] += 1
        if re.match(r"[ ]", char):
            result[3] += 1
    print(" ".join(map(str, result)))
