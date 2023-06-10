package programmers;

import java.util.*;

class 마지막_두_원소_230611 {
    public int[] solution(int[] num_list) {
        
        int len = num_list.length;
        
        int[] answer = Arrays.copyOf(num_list, len+1);

        
        int last1 = num_list[len-1];
        int last2 = num_list[len-2];
    
        if(last1 > last2){
            answer[answer.length-1] = last1 - last2;
        }else{
            answer[answer.length-1] = last1 * 2;
        }
        
        
        
        return answer;
    }
}