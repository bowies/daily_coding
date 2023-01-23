package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 오픈채팅방_230123 {
    public static void main(String[] args) {
        String [] record = {
            "Enter uid1234 Muzi", 
            "Enter uid4567 Prodo",
            "Leave uid1234",
            "Enter uid1234 Prodo",
            "Change uid4567 Ryan"
        };
        System.out.println(Arrays.toString(solution(record)));
    }


    public static String[] solution(String[] record) {

        ArrayList<String> 로그 = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0 ; i < record.length; i++){
            String [] temp = record[i].split(" ");
            String 명령어 = null;
            String 아이디 = null;
            String 이름 = null;

            if(temp.length == 2){
                //Leave 용
                명령어 = temp[0];
                아이디 = temp[1];

            }else{
                //Enter / Change 용
                명령어 = temp[0];
                아이디 = temp[1];
                이름 = temp[2];

            }
            
            switch(명령어){
                case "Enter":
                    map.put(아이디, 이름);
                    로그.add(아이디 + "님이 들어왔습니다.");
                    break;
                case "Leave":
                    로그.add(아이디 + "님이 나갔습니다.");
                    break;
                case "Change":
                    map.put(아이디, 이름);
                    break;
            }

        }
        //최종적으로 ID를 마지막 남은 이름이랑 치환해줘야 함
        //System.out.println(로그.toString());
        
        String [] answer = new String[로그.size()];
        int cnt = 0;
        
        for(String str : 로그){
            int 아이디길이 = str.indexOf("님");
            String 아이디 = str.substring(0, 아이디길이);
            
            answer[cnt++] = str.replace(아이디, map.get(아이디));
        }
        
        return answer;
    }
}
