//
//  Created by MinSeo on 2021/08/31.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.util.*;
class Solution {
    static ArrayList<Integer>[] pan;
    static int visited[];
    static int n;
    public static void bfs(int v){
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = 1;
		while(!q.isEmpty()) {
            for(int i=0; i<q.size(); ++i){
                int c = q.poll();
                for(int temp : pan[c]){ //c와 인접한 애들만 순회.
                    if(visited[temp] == 0){
                        q.add(temp);
                        visited[temp] = visited[c] + 1;
                    }
                }
            }
		}
	}
    public int solution(int nn, int[][] edge) {
        n = nn;
        int answer = 0;

        // 인접리스트에서는 arraylist로 선언
        pan = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
	        pan[i] = new ArrayList<Integer>();
        }
        visited = new int[n+1];
        for(int i=0; i<edge.length; ++i){
            pan[edge[i][0]].add(edge[i][1]);
            pan[edge[i][1]].add(edge[i][0]);
        }
        bfs(1);
        Arrays.sort(visited);
        answer = 1;
        for(int i=n-1; i>=1; --i){
            if(visited[i] == visited[n]) ++answer;
        }
        return answer;
    }
}