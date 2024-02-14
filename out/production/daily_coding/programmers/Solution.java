class 합성수_찾기_Java_240214 {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 4; i <= n; i++) { // 4부터 시작
            if (합성수(i)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean 합성수(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
            }
            if (count > 2) { // 약수의 개수가 3개 이상이면 합성수
                return true;
            }
        }
        return false;
    }


    public int solution_stream(int n) {
        return (int) IntStream.rangeClosed(1, n) //1부터 n까지 숫자 범위를 생성
                .filter(i -> { //i에 대해 필터링 수행
                    long 약수개수 = IntStream.rangeClosed(1, i) //i의 약수 개수를 구하는데, i를 1부터 자신까지 숫자로 나누어서 확인
                            .filter(i2 -> i % i2 == 0) // i의 약수를 찾기
                            .count(); // 약수의 개수를 세기

                    return 약수개수 > 2;  //1하고 자기 자신 포함 + 3개 이상인 경우를 찾음
                })
                // 최종적으로 총 개수를 세어서 반환
                .count();
    }

    public int solution_stream_plus(int n) {
        //↓ programmers에서 stream으로 유명한 분 풀이
        return (int) IntStream.rangeClosed(1, n).filter(i -> (int) IntStream.rangeClosed(1, i).filter(i2 -> i % i2 == 0).count() > 2).count();
    }
}
