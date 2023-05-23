package programmers;

import java.util.Arrays;

class Solution {
    public int solution(int[] num_list, int n) {
        return Arrays.stream(num_list).anyMatch(i -> i == n) ? 1 : 0;
    }

    public int old_solution(int[] num_list, int n) {
        int answer = 0;
        for(int i = 0; i < num_list.length; i++){
            if(n==num_list[i]){
                answer = 1;
            }
        }
        return answer;
    }
}

