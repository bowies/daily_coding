package programmers;

class 특별한_이차원_배열_1_Java_240307 {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    answer[i][j] = 1;
                } else {
                    answer[i][j] = 0;
                }
            }
        }
        
        return answer;
    }


    //이거랑 결과가 같은 이유가 뭘까?
    //답 : 주어진 문제의 조건을 충족하기 위해서는 대각선 요소만 1로 초기화하면 되므로,
    //     대각선 요소만 1로 초기화하고 나머지는 기본값 0으로 설정하는 것이 맞다고 한다!!
    public int[][] solution_Same(int n) {
        int[][] answer = new int[n][n];
        for(int i = 0 ; i < n ; i++) {
            answer[i][i] = 1;
        }
        return answer;
    }
}
