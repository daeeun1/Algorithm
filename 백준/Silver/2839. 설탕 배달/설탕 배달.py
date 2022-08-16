n = int(input())
bag = 0

while True : 
  if n % 5 == 0 :
    bag += n//5
    print(bag)
    break
  n -= 3
  bag += 1
  if n <0 :
    print(-1)
    break