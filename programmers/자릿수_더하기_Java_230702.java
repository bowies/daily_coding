package programmers;

import java.util.Arrays;

public class 자릿수_더하기_Java_230702 {

/*
    정수 n이 매개변수로 주어질 때 n의 각 자리 숫자의 합을 return하도록 solution 함수를 완성해주세요
 */
    public int solution(int n) {
        int answer = 0;

        int [] arr = new int [String.valueOf(n).length()];

        for(int i = 0; i < arr.length; i++) {
            arr[i] = n % 10;
            n /= 10;
        }

        answer = Arrays.stream(arr).sum();

        return answer;
    }


    public int solution_short(int n) {
        int answer = 0;

        while(n > 0){
            answer += n % 10;
            n /= 10;
        }

        return answer;
    }

}
