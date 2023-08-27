package programmers;

import java.util.Arrays;

class n_번째_원소부터_Java_230825 {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length - n+1];

        for( int i = 0 ; i < answer.length; i++){
            answer[i] = num_list[n-1+i];
        }

        return answer;
    }


    public int[] solution2(int[] num_list, int n) {
        return Arrays.copyOfRange(num_list, n-1, num_list.length);
    }
}