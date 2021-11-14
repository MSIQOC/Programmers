"""
Created by MinSeo on 2021/11/14.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""
def solution(name):
    answer = 0
    make_name = [min(ord(i) - ord("A"), ord("Z") - ord(i) + 1) for i in name]  # 이름에서 실제로 더 가까운 거리를 계산
    # 여기에서 Z로 맞춰지면 한번은 밑으로 내려야하기 때문에 +1을 해준다. (초기 세팅이 AAA로 돼있음.)
    p = 0
    while True:
        answer += make_name[p]
        make_name[p] = 0
        if sum(make_name) == 0:  # sum 메소드를 사용해서 배열의 총 합을 구한다.
            break
        l, r = 0, 0
        pp = p
        while make_name[pp] == 0:
            l += 1
            pp -= 1
        pp = p
        while make_name[pp] == 0:
            r += 1
            pp += 1
        if l < r:
            p -= l
            answer += l
        else:
            p += r
            answer += r

    return answer