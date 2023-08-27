package programmers;

import java.util.List;

class 연속_펄스_부분_수열의_합_Java_230827 {
    /*
        문제:
        주어진 수열의 연속 부분 수열에 같은 길이의 펄스 수열을 각 원소끼리 곱하여 연속 펄스 부분 수열을 만들려 합니다.
        펄스 수열이란 [1, -1, 1, -1 ...] 또는 [-1, 1, -1, 1 ...] 과 같이
        1 또는 -1로 시작하면서 1과 -1이 번갈아 나오는 수열입니다.

        예시:
        수열 [2, 3, -6, 1, 3, -1, 2, 4]의 연속 부분 수열 [3, -6, 1]에
        펄스 수열 [1, -1, 1]을 곱하면 연속 펄스 부분 수열은 [3, 6, 1]이 됩니다.
        또 다른 예시로 연속 부분 수열 [3, -1, 2, 4]에
        펄스 수열 [-1, 1, -1, 1]을 곱하면 연속 펄스 부분 수열은 [-3, -1, -2, 4]이 됩니다.

        주어진 정수 수열 sequence가 매개변수로 주어질 때,
        연속 펄스 부분 수열의 합 중 가장 큰 것을 반환하는 solution 함수를 완성하세요.
     */
    public long solution(int[] sequence) {
        long answer = Long.MIN_VALUE;

        int n = sequence.length;

        // 0 : [-1, 1, -1, 1, ...]
        // 1 : [1, -1, 1, -1, ...]
        List<long[]> dp = List.of(new long[n], new long[n]);
        // 펄스 패턴에 따른 연속 부분 수열의 곱 결과를 저장할 dp 리스트

        dp.get(0)[0] = 펄스패턴과_수열원소의_곱(0, 0, sequence);
        dp.get(1)[0] = 펄스패턴과_수열원소의_곱(1, 0, sequence);
        answer = Math.max(dp.get(0)[0], dp.get(1)[0]);

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 2; j++) {
                //DP를 이용해서 최대 합 계산
                long summary = 펄스패턴과_수열원소의_곱(j, i, sequence);
                dp.get(j)[i] = Math.max(summary, dp.get(j)[i - 1] + summary);
            }
            // 현재 인덱스에서의 최대 합과 기존의 최대 합을 비교하여 더 큰 값 선택
            answer = Math.max(answer, Math.max(dp.get(0)[i], dp.get(1)[i]));
        }

        return answer;
    }

    private long 펄스패턴과_수열원소의_곱(int k, int i, int[] sequence) {
        long answer;
        if(i % 2 == 0) { // 짝수 인덱스
            answer = (k == 0) ? (sequence[i] * -1) : sequence[i];
        } else { // 홀수 인덱스
            answer = (k == 0) ? sequence[i] : (sequence[i] * -1);
        }
        return answer;
    }
}
