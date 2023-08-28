package programmers;

import java.util.ArrayList;
import java.util.List;

public class 조건에_맞게_수열_변환하기_1_Java_230828 {

    /*
        정수 배열 arr가 주어집니다.
        arr의 각 원소에 대해 값이 50보다 크거나 같은 짝수라면 2로 나누고,
        50보다 작은 홀수라면 2를 곱합니다.
        그 결과인 정수 배열을 return 하는 solution 함수를 완성해 주세요.
     */
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();

        for (int i : arr) {
            if (i >= 50 && i % 2 == 0) {
                list.add(i / 2);
            } else if (i < 50 && i % 2 == 1) {
                list.add(i * 2);
            } else {
                list.add(i);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
