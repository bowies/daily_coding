package programmers;

import java.util.Arrays;

class 문자열_내림차순으로_배치하기_Java_240808 {;
    public String solution(String s) {
        char[] arr = s.toCharArray();

        Arrays.sort(arr);

        String answer = new StringBuilder(new String(arr)).reverse().toString();
        //reverse 함수 있는 클래스를 잘 사용해 볼 것

        return answer;
    }
}
