str = input()


world = []
result = []
bracket = False
for char in str:
    if char == "<":
        if len(world) != 0:
            result.append("".join(world[::-1]))
            world = []

        world.append(char)
        bracket = True
        continue
    if char == ">":
        world.append(char)
        bracket = False
        result.append("".join(world))
        world = []
        continue

    if not bracket and char == " ":
        result.append("".join(world[::-1]))
        result.append(" ")
        world = []
    else:
        world.append(char)

if world:
    result.append("".join(world[::-1]))


print("".join(result))
