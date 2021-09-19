"""
Created by MinSeo on 2021/09/19.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""
def solution(rows, columns, queries):
    answer = []
    graph = [[0] * columns for _ in range(rows)]
    cnt = 1
    for i in range(rows):
        for j in range(columns):
            graph[i][j] = cnt
            cnt += 1
    for i in range(len(queries)):
        x1 = queries[i][0] - 1
        y1 = queries[i][1] - 1
        x2 = queries[i][2] - 1
        y2 = queries[i][3] - 1
        arr = []
        prev = graph[x1][y1]
        nex = 0
        for j in range(y1+1, y2+1):
            nex = graph[x1][j]
            graph[x1][j] = prev
            prev = nex
            arr.append(prev)
        for j in range(x1+1, x2+1):
            nex = graph[j][y2]
            graph[j][y2] = prev
            prev = nex
            arr.append(prev)
        for j in range(y2-1, y1-1, -1):
            #print("j",j)
            nex = graph[x2][j]
            graph[x2][j] = prev
            prev = nex
            arr.append(prev)
        for j in range(x2-1, x1-1, -1):
            nex = graph[j][y1]
            graph[j][y1] = prev
            prev = nex
            arr.append(prev)
        answer.append(min(arr))
    return answer