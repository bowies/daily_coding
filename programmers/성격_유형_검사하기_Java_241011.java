package programmers;

import java.util.HashMap;

class 성격_유형_검사하기_Java_241011 {
    public String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> scores = new HashMap<>();
        scores.put('R', 0);
        scores.put('T', 0);
        scores.put('C', 0);
        scores.put('F', 0);
        scores.put('J', 0);
        scores.put('M', 0);
        scores.put('A', 0);
        scores.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            String pair = survey[i];
            int choice = choices[i];
            
            if (choice < 4) { // 비동의 선택지
                scores.put(pair.charAt(0), scores.get(pair.charAt(0)) + (4 - choice));
            } else if (choice > 4) { // 동의 선택지
                scores.put(pair.charAt(1), scores.get(pair.charAt(1)) + (choice - 4));
            }
        }

        StringBuilder result = new StringBuilder();
        result.append(scores.get('R') >= scores.get('T') ? 'R' : 'T');
        result.append(scores.get('C') >= scores.get('F') ? 'C' : 'F');
        result.append(scores.get('J') >= scores.get('M') ? 'J' : 'M');
        result.append(scores.get('A') >= scores.get('N') ? 'A' : 'N');
        
        return result.toString();
    }
}
