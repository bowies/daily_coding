package programmers;
import java.util.stream.IntStream;

class flag에_따라_다른_값_반환하기_230517 {
    public int solution(int a, int b, boolean flag) {
        return flag ? IntStream.of(a, b).sum() : IntStream.of(a, b).reduce((x, y) -> x - y).orElse(0);

    }

    public int solution2(int a, int b, boolean flag){
        //이렇게 하면 되긴 합니다...
        return flag ? a + b : a - b;
    }
}