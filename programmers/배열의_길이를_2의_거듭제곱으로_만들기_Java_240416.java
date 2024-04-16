package programmers;

import java.util.*;

class 배열의_길이를_2의_거듭제곱으로_만들기_Java_240416 {
    public int[] solution(int[] arr) {
        int i = 1;

        while (i < arr.length) {
            i *= 2;
        }

        return Arrays.copyOf(arr, i);
    }
}