package programmers;

class 숫자_블록_Java_240118 {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];

        // 주어진 범위 내의 각 숫자에 대해 가장 큰 약수 계산
        for (int i = 0; i < answer.length; i++) {
            long current = begin + i;

            // 에라토스테네스의 체를 이용하여 소수 판별
            for (long j = 2; j <= Math.sqrt(current); j++) {
                if (current % j == 0) {
                    // 소수가 아닌 경우, 가장 큰 약수 계산
                    if (current / j > 10000000) {
                        answer[i] = (int) j;
                        continue;
                    } else {
                        answer[i] = (int) (current / j);
                    }
                    break;
                }
            }

            // 소수인 경우 약수가 1과 자기자신밖에 없다.
            if (answer[i] == 0) {
                answer[i] = 1;
            }
        }

        // 특수 케이스: 1일 때는 약수가 0임을 표시
        if (begin == 1) {
            answer[0] = 0;
        }
        return answer;
    }
}