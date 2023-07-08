package programmers;

import java.util.stream.IntStream;

class 공배수_230519 {
    public int solution(int number, int n, int m) {
        return (number % n == 0 && number % m == 0) ? 1 : 0;
    }

    public int solution2(int number, int n, int m) {
        //굳이 Stream을 써서 이렇게도 할 수 있음 
        return IntStream.of(number).filter(num -> num % n == 0 && num % m == 0).count() > 0 ? 1 : 0;
    }
}

