"""
Created by MinSeo on 2022/03/11.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""
def solution(n, left, right):
    answer = []
    for i in range(int(left), int(right+1)):
        answer.append(max(i//n, i%n) + 1)
    return answer