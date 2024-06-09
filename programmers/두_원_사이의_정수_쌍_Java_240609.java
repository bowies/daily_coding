package programmers;

class 두_원_사이의_정수_쌍_Java_240609 {
    public long solution(int r1, int r2) {
        //best solution 분석 진행

        long 정수좌표개수 = 0;

        for (int i = 1; i <= r2; i++) {
            //r2가 더 큰 원이라서 반지름 까지 모든 증가 값에 대해서 반복함 (x값임)
            
            // 현재 x값(i)에 대해 내부 원 안에 있는 최소 y값 계산
            // Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i)은 주어진 x값에 대한 내부 원의 y값을 계산
            // Math.ceil은 정수 좌표만 포함하기 위해 소수점을 올림 (중요)
            long 최소y값 = (int) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i));

            // 현재 x값(i)에 대해 외부 원 안에 있는 최대 y값 계산
            // Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i)은 주어진 x값에 대한 외부 원의 y값을 계산
            // Math.floor는 정수 좌표만 포함하기 위해 소수점을 내림 (중요)
            long 최대y값 = (int) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i));

            // 유효한 y값의 범위 = 최대y값 - 최소y값 + 1 를 정수좌표개수에 더함
            정수좌표개수 += (최대y값 - 최소y값 + 1);
        }

        long answer = 정수좌표개수 * 4;//각 방향마다 동일한 개수의 정수 좌표가 있으니까 * 4를 함
        return answer;
    }
}
