"""
Created by MinSeo on 2021/11/17.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""
def solution(s):
    answer = 0
    for i in range(len(s)):
        stack = []
        s += s[0]
        s = s[1:]
        torf = True
        for j in s:
            if j == '{' or j=='(' or j=='[':
                stack.append(j)
            else:
                if stack == []: #오른쪽 괄호로 시작할 때
                    torf = False
                    break
                if stack[-1]=='{' and j=='}' or stack[-1]=='(' and j==')' or stack[-1]=='[' and j==']':
                        stack.pop()
                else: #왼쪽 괄호만 남아있을 때
                    torf = False
                    break
        if stack == [] and torf == True:
            answer += 1
    return answer