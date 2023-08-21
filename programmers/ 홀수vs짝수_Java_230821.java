package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 홀수vs짝수_Java_230821{
    /*
        정수 리스트 num_list가 주어집니다.
        가장 첫 번째 원소를 1번 원소라고 할 때,
        홀수 번째 원소들의 합과 짝수 번째 원소들의 합 중 큰 값을 return 하도록 solution 함수를 완성해주세요.
        두 값이 같을 경우 그 값을 return합니다.


     */
    public int solution(int [] num_list){
        int 홀수 = 0;
        int 짝수 = 0;

        for (int i = 0; i < num_list.length; i++) {
            if ((i + 1) % 2 == 1) {
                홀수 += num_list[i];
            } else {
                짝수 += num_list[i];
            }
        }
        return Math.max(홀수, 짝수);
    }

    public int solution2(int[] num_list) {
        int 홀수 = Arrays.stream(num_list)
                .filter((num, index) -> (index + 1) % 2 == 1) // 홀수 번째 원소 필터링
                .sum(); // 홀수 번째 원소의 합

        int 짝수 = Arrays.stream(num_list)
                .filter((num, index) -> (index + 1) % 2 == 0) // 짝수 번째 원소 필터링
                .sum(); // 짝수 번째 원소의 합

        // 두 합 중 큰 값을 반환
        return Math.max(홀수, 짝수);
    }
    public int solution_short(int[] num_list) {
        return Integer.max(
                IntStream.iterate(0, i -> i < num_list.length, i -> i + 2)
                        .map(i -> num_list[i])
                        .sum(),
                IntStream.iterate(1, i -> i < num_list.length, i -> i + 2)
                        .map(i -> num_list[i])
                        .sum()
        );
    }


}