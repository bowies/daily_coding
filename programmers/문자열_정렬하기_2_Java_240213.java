package programmers;

import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        // 문자열을 모두 소문자로 변환
        my_string = my_string.toLowerCase();
        
        // 문자열을 문자 배열로 변환
        char[] charArray = my_string.toCharArray();
        
        // 문자 배열을 오름차순으로 정렬
        Arrays.sort(charArray);
        
        // 정렬된 문자 배열을 다시 문자열로 변환하여 반환
        return new String(charArray);
    }
}
