import java.util.*;

class 자연수_뒤집어_배열로_만들기_Java_240427 {
    public int[] solution(long n) {
        String temp = Long.toString(n);
        char[] arr = temp.toCharArray();
        
        int len = arr.length;
        
        int[] answer = new int[len];
        
        for (int i = len - 1; i >= 0; i--) {
            answer[len - i - 1] = Character.getNumericValue(arr[i]);
        }
        
        return answer;
    }
}
