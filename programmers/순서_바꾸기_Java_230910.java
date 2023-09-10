package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class 순서_바꾸기_Java_230910 {
    /*
    정수 리스트 num_list와 정수 n이 주어질 때,
    num_list를 n 번째 원소 이후의 원소들과
    n 번째까지의 원소들로 나눠
    n 번째 원소 이후의 원소들을
    n 번째까지의 원소들 앞에 붙인 리스트를 return하도록 solution 함수를 완성해주세요.
     */

    public int[] solution(int[] num_list, int n) {
        int length = num_list.length;
        int[] answer = new int[length];

        // n 이후의 원소들을 결과 배열의 앞부분에 복사
        System.arraycopy(num_list, n, answer, 0, length - n);

        // n 이전의 원소들을 결과 배열의 나머지 부분에 복사
        System.arraycopy(num_list, 0, answer, length - n, n);

        return answer;
    }

    public int[] solution_stream(int[] num_list, int n) {
        // IntStream.range(0, num_list.length): 0부터 num_list.length - 1까지의 정수 스트림을 생성
        // map(i -> num_list[(i + n) % num_list.length]): 각 인덱스를 n만큼 이동한 후 원래 배열에서 해당 위치의 값을 추출
        // toArray(): 스트림을 정수 배열로 변환하여 반환
        return IntStream.range(0, num_list.length).map(i -> num_list[(i + n) % num_list.length]).toArray();
    }
}
