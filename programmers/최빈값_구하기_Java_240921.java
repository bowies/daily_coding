package programmers;
package programmers;

import java.util.HashMap;

class 최빈값_구하기_Java_240921 {
    public int solution(int[] array) {
        HashMap<Integer, Integer> 빈도 = new HashMap<>();
        
        for (int num : array) {
            빈도.put(num, 빈도.getOrDefault(num, 0) + 1);
        }
        
        int maxFrequency = 0;
        int 최빈값 = -1;
        boolean 최빈값Flag = false; 
        
        // 빈도 맵을 순회하며 최빈값 찾기
        for (int key : 빈도.keySet()) {
            int freq = 빈도.get(key);
            
            if (freq > maxFrequency) {
                maxFrequency = freq;
                최빈값 = key;
                최빈값Flag = false; // 새로운 최빈값이 생겼으므로 중복 해제
            } else if (freq == maxFrequency) {
                최빈값Flag = true; // 최빈값이 여러 개일 때
            }
        }
        
        return 최빈값Flag ? -1 : 최빈값;
    }
}
