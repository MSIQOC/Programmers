"""
Created by MinSeo on 2021/08/09.
Copyright ⓒ 2021 MinSeo Shin. All rights reserved.

"""
def solution(n):
    dp = [0] * (n+1)
    dp[1] = 1
    for i in range(2, n+1) :
        dp[i] = dp[i-1] % 1234567 + dp[i-2] % 1234567
        dp[i] = dp[i] % 1234567
    answer = dp[n]
    return answer