package programmers;

import java.util.Arrays;

class 정수_내림차순으로_배치하기_Java_240315 {
    public long solution(long n) {
        char[] digits = String.valueOf(n).toCharArray();
        
        Arrays.sort(digits);
        
        return Long.parseLong(new StringBuilder(new String(digits)).reverse().toString());
    }
}
