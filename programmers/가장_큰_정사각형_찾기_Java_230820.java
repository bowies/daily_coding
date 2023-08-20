package programmers;

class 가장_큰_정사각형_찾기_Java_230820
{
    public int solution(int[][] board) {
        int answer = 0;

        int 가로 = board.length;
        int 세로 = board[0].length;

        int[][] dp = new int[가로][세로];

        // 초기값 설정
        for (int i = 0; i < 가로; i++) {
            dp[i][0] = board[i][0];
            answer = Math.max(answer, dp[i][0]);
        }

        for (int j = 0; j < 세로; j++) {
            dp[0][j] = board[0][j];
            answer = Math.max(answer, dp[0][j]);
        }

        // 각 위치에서 가능한 가장 큰 정사각형의 변의 길이 계산
        for (int i = 1; i < 가로; i++) {
            for (int j = 1; j < 세로; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    answer = Math.max(answer, dp[i][j]);
                }
            }
        }

        return answer * answer; // 넓이 반환
    }

    public int solution_stream(int[][] board) {
        int 가로 = board.length;
        int 세로 = board[0].length;

        int[][] dp = new int[가로][세로];

        for (int i = 0; i < 가로; i++) {
            dp[i][0] = board[i][0];
        }

        for (int j = 0; j < 세로; j++) {
            dp[0][j] = board[0][j];
        }

        for (int i = 1; i < 가로; i++) {
            for (int j = 1; j < 세로; j++) {
                if (board[i][j] == 1) {
                    dp[i][j] = Arrays.stream(new int[]{dp[i-1][j-1], dp[i-1][j], dp[i][j-1]}).min().getAsInt() + 1;
                }
            }
        }

        return Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt() * Arrays.stream(dp).flatMapToInt(Arrays::stream).max().getAsInt();
    }

}
