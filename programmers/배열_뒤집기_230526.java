package programmers;

import java.util.Arrays;
import java.util.stream.IntStream; 

class 배열_뒤집기_230526 {
    public int[] solution_Intstream(int[] num_list) {
        return IntStream.range(0, num_list.length)
                .map(i -> num_list[num_list.length - 1 - i])
                .toArray();
    }
    
    public int[] solution_for(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i = num_list.length-1 ; i >= 0; i--){
            answer[num_list.length-1-i] = num_list[i];
        }
        return answer;
    }
}
