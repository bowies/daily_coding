package programmers;

import java.util.Arrays;

class 문자열_정렬하기_2_Java_240213 {
    public String solution(String my_string) {
        my_string = my_string.toLowerCase();
        char[] arr = my_string.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }
}
