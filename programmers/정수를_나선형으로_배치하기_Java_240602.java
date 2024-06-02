package programmers;

class 정수를_나선형으로_배치하기_Java_240602 {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int count = 1;
        int x축 = 0, y축 = 0;
        int[][] 방향 = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int 현재방향 = 0;

        for (int i = 0; i < n * n; i++) {
            answer[x축][y축] = count++;
            int 다음x축 = x축 + 방향[현재방향][0];
            int 다음y축 = y축 + 방향[현재방향][1];
            
            if (다음x축 < 0 || 다음x축 >= n || 다음y축 < 0 || 다음y축 >= n || answer[다음x축][다음y축] != 0) {
                //좌표 상실 or 이미 1인 경우 방향 전환
                현재방향 = (현재방향 + 1) % 4; // 방향 변경
                다음x축 = x축 + 방향[현재방향][0];
                다음y축 = y축 + 방향[현재방향][1];
            }
            
            x축 = 다음x축;
            y축 = 다음y축;
        }
        
        return answer;
    }
}
