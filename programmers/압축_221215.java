package programmers;

import java.util.ArrayList;
import java.util.HashMap;

class 압축_221215 {
    public static void main(String[] args) {
        String msg = "KAKAO";
        solution(msg);
    }
    public static int[] solution(String msg) {
        
        ArrayList<Integer> ans = new ArrayList<Integer>();
        HashMap<String, Integer> map = new HashMap<String,Integer>();

        int count = 0; 
                
        String[] alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
        for(String s : alpha){
            count++;
            map.put(s,count);
        }


        for(int i =0; i< msg.length(); i++){
            int cnt = 1;

            while(i+cnt <= msg.length() && map.containsKey(msg.substring(i,i+cnt))){
                cnt++;                
            }

            if(i+cnt > msg.length()){
                ans.add(map.get(msg.substring(i)));
                break;
            }
            
            ans.add(map.get(msg.substring(i,i+cnt-1)));

            count++;
            map.put(msg.substring(i,i+cnt),count);
            
            if(cnt>1){
                i += cnt-2;
            }
        }


        int[] answer = new int [ans.size()];
        for(int i = 0; i < ans.size(); i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }
}