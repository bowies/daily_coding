package programmers;

import java.util.Arrays;

class 서울에서_김서방_찾기_Java_230704 {
    public String solution(String[] seoul) {
        String 김서방 = "Kim";
        String answer = null;
        for(int i = 0; i < seoul.length; i++){
            if(seoul[i].equalsIgnoreCase(김서방)){
                answer = "김서방은 "+ i + "에 있다";
            }
        }

        return answer;
    }


    public String solution_Short(String[] seoul) {
        int index = Arrays.asList(seoul).indexOf("Kim");

        String answer = (index != -1) ? "김서방은 " + index + "에 있다" : null;
        return answer;
    }
}