package programmers;

import java.util.ArrayList;
import java.util.List;

class 배열_만들기_5_Java_240324 {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> resultList = new ArrayList<>();
        
        for (String str : intStrs) {
            String subStr = str.substring(s, s + l);
            int num = Integer.parseInt(subStr);
            
            if (num > k) {
                resultList.add(num);
            }
        }
        
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}
