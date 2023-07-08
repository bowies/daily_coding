package programmers;

import java.util.Arrays;

class 배열_자르기_230614 {
    public int[] solution(int[] numbers, int num1, int num2) {
        
        
        int[] answer = Arrays.copyOfRange(numbers, num1, num2+1);
        
        return answer;
    }
}