n, k = map(int, input().split())
d = []
del_d = []
for i in range(1, n+1) :
  d.append(i)
num = 0

for i in range(n) :
  num += k-1
  if num >= len(d) :
    num = num%len(d)
  
  del_d.append(str(d.pop(num)))
print("<",", ".join(del_d)[:],">", sep='')