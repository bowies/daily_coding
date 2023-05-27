package programmers;

import java.util.*;
class 삼각형의_완성조건_1_230527 {

    public int solution(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        return sides[2] >= sides[0]+sides[1] ? 2 : 1;
    }

    public int solution_arr(int[] sides) {
        int answer = 0;
        Arrays.sort(sides);
        if( sides[2] < (sides[0] + sides[1]) ) {
            answer = 1;
        } else {
            answer = 2;
        }
        return answer;
    }



}