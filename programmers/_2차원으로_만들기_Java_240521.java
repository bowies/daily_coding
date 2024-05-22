package programmers;

class _2차원으로_만들기_Java_240521 {
    public int[][] solution(int[] num_list, int n) {
        int length = num_list.length;
        int[][] answer = new int[length / n][n];
        
        for (int i = 0; i < length; i++) {
            answer[i / n][i % n] = num_list[i];
        }
        
        return answer;
    }
}
