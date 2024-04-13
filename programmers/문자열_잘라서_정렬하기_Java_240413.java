package programmers;

import java.util.*;

class 문자열_잘라서_정렬하기_Java_240413 {
    public String[] solution(String myString) {

        String[] arr = myString.split("x");
        
        List<String> list = new ArrayList<>();
        for (String s : arr) {
            if (!s.isEmpty()) {
                list.add(s);
            }
        }
        
        String[] answer = list.toArray(new String[0]);
        Arrays.sort(answer);
        
        return answer;
    }
}
