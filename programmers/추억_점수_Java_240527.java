package programmers;

import java.util.HashMap;

class 추억_점수_Java_240527 {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < name.length; i++) {
            map.put(name[i], yearning[i]);
        }
        
        int[] answer = new int[photo.length];
        
        for (int i = 0; i < photo.length; i++) {
            int total = 0;
            for (String str : photo[i]) {
                if (map.containsKey(str)) {
                    total += map.get(str);
                }
            }
            answer[i] = total;
        }
        
        return answer;
    }
}
