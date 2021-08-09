//
//  Created by MinSeo on 2021/08/09.
//  Copyright ⓒ 2021 MinSeo Shin. All rights reserved.
//
import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> hm = new HashMap<>();
        ArrayList<String> ans = new ArrayList<>();
        String[] answer;
        for(int i=0; i<record.length; ++i){
            String s = "";
            StringTokenizer st = new StringTokenizer(record[i]);
            String command = st.nextToken();
            String id = st.nextToken();
            String name = "";
            
            if(st.hasMoreTokens())
                name = st.nextToken(); 
            
            switch(command){
                case "Enter" :
                    s += id;
                    s += "님이 들어왔습니다.";
                    ans.add(s);
                    hm.put(id, name);
                    break;
                case "Leave" :
                    s = id;
                    s += "님이 나갔습니다."; //나갔다고 맵에서 아이디가 사라져버리면 
                    ans.add(s);
                    break;
                case "Change" :
                    hm.put(id, name); //change는 따로 문구가 없음.
                    break;
            }    
        }
        //여기까지 구현하고, 기존 채팅방에 남아있던 애들을 바꾸는건 어떻게 구현해야할지 몰라서 인터넷 참고.
        /*
        arr에 추가할 때부터 이름 + 님이 ~~했습니다 로 추가해줬지만
        id + 님이 ~~했습니다로 추가해주고 나중에 id들을 다 이름으로 바꿔주면 되는거였다.
        */
        int size = 0;
        answer = new String[ans.size()];
        for(int i=0; i<ans.size(); ++i){
            int idx = ans.get(i).indexOf("님"); //님까지의 index 찾기
            String id = ans.get(i).substring(0, idx); //id 가져오기
            String change = hm.get(id);
            String [] temp = ans.get(i).split(" ");
            answer[i] = change + "님이 " + temp[1];
        }
        
        return answer;
    }
}