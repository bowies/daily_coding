package programmers;

import java.util.stream.IntStream;

class n개_간격의_원소들_Java_230822 {
    /*
        정수 리스트 num_list와 정수 n이 주어질 때,
        num_list의 첫 번째 원소부터
        마지막 원소까지 n개 간격으로 저장되어있는 원소들을 차례로 담은
        리스트를 return하도록 solution 함수를 완성해주세요.


     */
    public int[] solution(int[] num_list, int n) {
        return IntStream.iterate(0, i -> i < num_list.length, i -> i + n)
                .map(i -> num_list[i])
                .toArray();
        // IntStream.iterate를 사용하여 인덱스를 n만큼 증가시키며 반복하고,
        // map을 사용하여 해당 인덱스의 num_list 원소를 추출한 뒤,
        // toArray를 호출하여 스트림을 배열로 변환합니다.
        // 이로써 주어진 배열의 원소를 n개 간격으로 추출하여 새로운 배열로 변환하는 작업이 스트림을 활용하여 수행됩니다.
    }
    public int[] solution_ori(int[] num_list, int n) {
        int[] answer = {};
        int len = num_list.length;
        int answer_len = len / n;
        if (len % n != 0) {
            answer_len++;
        }
        answer = new int[answer_len];
        int idx = 0;
        for (int i = 0; i < len; i += n) {
            answer[idx++] = num_list[i];
        }

        return answer;
    }
}