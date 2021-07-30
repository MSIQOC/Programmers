"""
Created by MinSeo on 2021/07/30.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""

def solution(bridge_length, weight, truck_weights):
    queue = []
    dochak = 0
    answer = 0
    qw = 0
    end = len(truck_weights)
    point = 0
    while dochak != end :
        if len(queue) == bridge_length:
            p = queue.pop(0)
            qw -= p
            if p != 0 :
                dochak += 1
        elif point == end:
            queue.append(0)
            answer += 1
        elif qw + truck_weights[point] > weight :
            queue.append(0)
            answer += 1
        elif qw + truck_weights[point] <= weight :
            queue.append(truck_weights[point])
            qw += truck_weights[point]
            point += 1
            answer += 1
    return answer + 1