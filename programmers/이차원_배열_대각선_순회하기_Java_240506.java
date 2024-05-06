package programmers;

class 이차원_배열_대각선_순회하기_Java_240506 {
    public int solution(int[][] board, int k) {
        int answer = 0;
        
        int 행 = board.length;
        int 열 = board[0].length;
        
        for (int i = 0; i < 행; i++) {
            for (int j = 0; j < 열; j++) {
                if (i + j <= k) {
                    answer += board[i][j];
                }
            }
        }
        return answer;
    }
}
