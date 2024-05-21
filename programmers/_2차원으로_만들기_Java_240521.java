package programmers;

class Solution {
    public int[][] solution(int[] num_list, int n) {
        int length = num_list.length;
        int[][] answer = new int[length / n][n];
        
        for (int i = 0; i < length; i++) {
            answer[i / n][i % n] = num_list[i];
        }
        
        return answer;
    }
}
