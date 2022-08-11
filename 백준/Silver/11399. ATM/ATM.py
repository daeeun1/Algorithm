n = int(input())
ans = list(map(int, input().split()))
count = 0
answer = 0
ans.sort()
for a in ans:
  count += a
  answer += count
print(answer)