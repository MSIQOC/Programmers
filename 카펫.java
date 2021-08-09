class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int bcal = (brown+4)/2;
        boolean check = false;
        for(int x=1; x<bcal; ++x){
            int y = bcal - x;
            if((x-2)*(y-2) == yellow){
                answer[0] = (x >= y) ? x : y;
                answer[1] = (x >= y) ? y : x;
            }
        }
        return answer;
    }
}