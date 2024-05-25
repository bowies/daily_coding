package programmers;

import java.util.*;
import java.util.stream.IntStream;

class 무작위로_K개의_숫자_뽑기_Java_240525 {
    public int[] solution(int[] arr, int k) {
        return IntStream.concat(Arrays.stream(arr).distinct(), IntStream.range(0, k).map(i -> -1)).limit(k).toArray();
    }
}
