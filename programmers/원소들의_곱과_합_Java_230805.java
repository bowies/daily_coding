package programmers;

import java.util.Arrays;

class 원소들의_곱과_합_Java_230805 {
    /*
        정수가 담긴 리스트 num_list가 주어질 때,
        모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return하도록 solution 함수를 완성해주세요.
     */
    public int solution(int[] num_list) {
        int answer = 0;

        int 곱 = 1;
        int 합 = 0;

        for(int i = 0; i < num_list.length; i++) {
            곱 *= num_list[i];
            합 += num_list[i];
        }

        if(곱 < 합 * 합) {
            answer = 1;
        } else {
            answer = 0;
        }

        return answer;
    }


    public int solution_stream(int[] num_list) {
        int 곱 = Arrays.stream(num_list).reduce(1, (x, y) -> x * y);
        int 합 = Arrays.stream(num_list).sum();

        return (곱 < 합 * 합) ? 1 : 0;
    }
}