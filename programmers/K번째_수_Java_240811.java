package programmers;

import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int idx = 0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];
            
            // array에서 i-1부터 j까지 자르기
            int[] subArray = Arrays.copyOfRange(array, i-1, j);
            
            // 자른 배열 정렬
            Arrays.sort(subArray);
            
            // k번째 수를 answer 배열에 저장
            answer[idx] = subArray[k-1];
        }
        
        return answer;
    }
}
