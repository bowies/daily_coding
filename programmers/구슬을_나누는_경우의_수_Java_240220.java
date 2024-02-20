package programmers;

import java.math.BigInteger;

class 구슬을_나누는_경우의_수_Java_240220 {
    public int solution(int balls, int share) {
        // Int로 하면 오버플로우 남...
        BigInteger 구슬개수 = 팩토리얼(balls);
        BigInteger 분모계산 = 팩토리얼(balls - share).multiply(팩토리얼(share));

        // BigInteger를 int로 변환하여 반환
        return 구슬개수.divide(분모계산).intValue();
    }

    public BigInteger 팩토리얼(int n) {
        BigInteger answer = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            answer = answer.multiply(BigInteger.valueOf(i));
        }
        return answer;
    }



    public long solution_best(int balls, int share) {
        // 구슬 개수를 ball이랑 share중 더 작은 값으로 설정함
        share = Math.min(balls - share, share);

        // 나눌 구슬의 개수가 0이면, 하나의 경우 밖에 없으므로 1을 반환함
        if (share == 0)
            return 1;

        // 재귀로 계산
        // balls - 1과 share - 1의 조합에 balls를 곱하고 share로 나누어 경우의 수를 구함
        // nCr=n-1Cr+n-1Cr-1 식 이라고 함
        long result = solution(balls - 1, share - 1);
        result *= balls;
        result /= share;

        return result;
    }

}
