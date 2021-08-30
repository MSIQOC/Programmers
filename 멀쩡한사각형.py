"""
Created by MinSeo on 2021/08/30.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""
def gcd(w, h):
    small = 0
    if w>h :
        small = h
    else :
        small = w
    for i in range(small, 0, -1) :
        if w % i == 0 and h % i == 0 :
            return i
    return 1

def solution(w,h):
    g = gcd(w,h)
    return w * h - (w + h - g)