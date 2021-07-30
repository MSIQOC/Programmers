//
//  Created by MinSeo on 2021/07/30.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> qsmall = new PriorityQueue<>();
        PriorityQueue<Integer> qbig = new PriorityQueue<>(Collections.reverseOrder());
        int qsize = 0;
        for(String s : operations){
            StringTokenizer st = new StringTokenizer(s);
            String s1 = st.nextToken();
            int in = Integer.parseInt(st.nextToken());
            if(s1.equals("I")){
                qsmall.add(in);
                qbig.add(in);
                ++qsize;
            }
            else if(s1.equals("D")){
                if(qsize==0){}
                else if(in==1){
                    qbig.poll();
                    --qsize;
                }
                else if(in == -1){
                    qsmall.poll();
                    --qsize;
                }
                if(qsize==1 && (qbig.size()!=1 || qsmall.size()!=1)){
                    int a = qbig.peek();
                    while(!qbig.isEmpty())
                        qbig.poll();
                    while(!qsmall.isEmpty())
                        qsmall.poll();
                    qbig.add(a);
                    qsmall.add(a);
                }
                
            }
        }
        if(qsize!=0){
            answer[0] = qbig.peek();
            answer[1] = qsmall.peek();
        }
        return answer;
    }
}