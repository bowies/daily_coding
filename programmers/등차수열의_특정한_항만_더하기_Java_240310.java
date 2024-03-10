package programmers;
import java.util.stream.IntStream;

class 등차수열의_특정한_항만_더하기_Java_240310 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        
        for (int i = 0; i < included.length; i++) {
            if (included[i]) {
                answer += a + (i * d);
            }
        }
        
        return answer;
    }


    public int solution_stream(int a, int d, boolean[] included) {
                // 1. 등차수열의 각 항에 대해 필터링하여 합을 계산한다.
        return IntStream.range(0, included.length)
                // 2. 필터링 조건: included 배열에서 값이 true인 경우만 포함한다.
                .filter(i -> included[i]) //  .filter(i -> included[i] == true)
                // 3. 각 항에 대한 값을 계산한다: 등차수열 항의 값 = a + (인덱스 * 공차)
                .map(i -> a + (i * d))
                // 4. 모든 등차수열 항의 값을 더한다.
                .sum();
    }
}
