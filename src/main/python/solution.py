import sys

def array_sum():
    n = int(input().strip())
    arr = [int(arr_temp) for arr_temp in input().strip().split(' ')]
    print(arr)
    print(sum(arr))

def array_left_rotation():
    n, k = map(int, input().strip().split(' '))
    a = list(map(int, input().strip().split(' ')))
    answer = a[k:]+a[:k]
    print(*answer, sep=' ')


array_left_rotation()