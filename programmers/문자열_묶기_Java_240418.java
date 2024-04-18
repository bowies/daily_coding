package programmers;

import java.util.*;

class 문자열_묶기_Java_240418 {
    public int solution(String[] strArr) {
        int answer = 0;
        
        Map<Integer, List<String>> map = new HashMap<>(); //길이, 문자열 목록
        
        for (String s : strArr) {
            int length = s.length();

            if (!map.containsKey(length)) {
                map.put(length, new ArrayList<>());
            }

            map.get(length).add(s);
        }
        
        for (List<String> list : map.values()) {
            answer = Math.max(answer, list.size());
        }
        
        return answer;
    }
}
