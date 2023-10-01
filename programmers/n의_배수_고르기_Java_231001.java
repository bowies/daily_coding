package programmers;

import java.util.Arrays;

class n의_배수_고르기_Java_231001 {
    /*
    정수 n과 정수 배열 numlist가 매개변수로 주어질 때,
     numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 solution 함수를 완성해주세요.


     */
    public int[] solution(int n, int[] numlist) {
        int [] answer = new int[numlist.length];
        for(int i = 0; i < numlist.length; i++) {
            if(numlist[i] % n == 0) {
                answer[i] = numlist[i];
            }
        }

        answer = Arrays.stream(answer).filter(i -> i != 0).toArray();

        return answer;

    }
    public int[] solution2(int n, int[] numList) {
        return Arrays.stream(numList).filter(value -> value % n == 0).toArray();
    }


}