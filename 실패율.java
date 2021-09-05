//
//  Created by MinSeo on 2021/09/15.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.util.*;
import java.util.Map.*;
class Solution {
    public int[] solution(int n, int[] stages) {
        HashMap<Integer, Double> hm = new HashMap<>();   
        //1. stages를 오름차순으로 정렬시키기
        Arrays.sort(stages);
        
        //2. 이중에서 도전자 수 구하기.
        int p = 0;
        int num = stages.length;
        for(int i=1; i<=n; ++i){
            int howmany = 0;
            while(p < stages.length && stages[p] <= i){
                ++howmany;
                ++p;
            }
            double nn = (double) howmany/num;
            //System.out.println(howmany+"/"+num);
            hm.put(i, nn);
            num -= howmany;
        }
         // 순서 유지를 위해 링크드 리스트
        List<Map.Entry<Integer, Double>> list = new LinkedList<>(hm.entrySet());
 
        // value기준 내림차순, 인덱스 기준 오름차순 정렬
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {
            @Override
            public int compare(Entry<Integer, Double> o1, Entry<Integer, Double> o2) {
                if (o2.getValue() - o1.getValue() > 0) {
                    return 1;
                }
                if (o2.getValue() - o1.getValue() < 0) {
                    return -1;
                }
                return o1.getKey() - o2.getKey();
            }
        });
        int[] answer = new int[n];
        int i = 0;
        
        // 배열에 순서대로 인덱스 담기
        for (Iterator<Map.Entry<Integer, Double>> iter = list.iterator(); iter.hasNext();) {
            Map.Entry<Integer, Double> entry = iter.next();
            answer[i++] = entry.getKey();
        }
        return answer;
    }
}