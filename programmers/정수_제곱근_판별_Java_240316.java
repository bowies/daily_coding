package programmers;

class 정수_제곱근_판별_Java_240316 {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        
        if (sqrt == (int)sqrt) {
            // 제곱근이 정수로 딱 떨어진다면 양의 정수 x의 제곱이므로 x+1을 제곱한 값을 반환
            return (long)Math.pow(sqrt + 1, 2);
        } else {
            // 제곱근이 정수로 딱 떨어지지 않는다면 양의 정수 x의 제곱이 아니므로 -1을 반환
            return -1;
        }
    }
}
