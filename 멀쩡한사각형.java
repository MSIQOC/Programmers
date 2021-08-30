//
//  Created by MinSeo on 2021/08/30.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
class Solution {
    public long gcd(long w, long h){
        long small = 0;
        if(w > h)  small = h;
        else small = w;
        for(long i = small; i >= 1; --i) {
            if(w%i==0 && h%i==0)
                return i;
        }
        return 1;
    }
    public long solution(long w, long h) {
        long g = gcd(w, h);
        return w*h - (w+h-g);
    }
}