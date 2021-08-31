"""
Created by MinSeo on 2021/08/31.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""
def bfs(visited, pan):
    q = []
    q.append(1)
    visited[1] = 1
    while q:
        v = q.pop(0)
        for e in pan[v]:
            if visited[e] == 0:
                visited[e] = visited[v] + 1
                q.append(e)


def solution(n, edge):
    answer = 0
    pan = [[] for _ in range(n + 1)]  # 어레이리스트 생성
    visited = [0] * (n + 1)
    for e in edge:
        pan[e[0]].append(e[1])
        pan[e[1]].append(e[0])
    bfs(visited, pan)
    for v in visited:
        if v == max(visited):
            answer += 1
    return answer