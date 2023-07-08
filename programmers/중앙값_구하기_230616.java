package programmers;

import java.util.*;

class 중앙값_구하기_230616 {
    public int solution(int[] array) {
        Arrays.sort(array);
        
        return array[array.length/2];
    }
}