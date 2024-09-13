import sys

n = int(sys.stdin.readline())
block = []
for _ in range(n):
    block.append(int(sys.stdin.readline()))

for _ in range(2):
    temp = []
    s, e = map(int,sys.stdin.readline().split())
    s, e = s-1, e-1
    for i in range(len(block)):
        if i < s or i > e:
            temp.append(block[i])
    block = temp[:]

print(len(block))
print(*block,sep="\n")
