"""
Created by MinSeo on 2021/08/01.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""
def solution(array, commands):
    answer = []
    for a,b,c in commands :
        arr = array[(a-1):b] #시작:끝+1
        arr.sort()
        answer.append(arr[c-1])
    return answer