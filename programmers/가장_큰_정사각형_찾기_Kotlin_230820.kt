package programmers

class 가장_큰_정사각형_찾기_Kotlin_230820{
    fun solution(board: Array<IntArray>): Int {
        var answer = 0

        val 가로 = board.size
        val 세로 = board[0].size

        val dp = Array(가로) { IntArray(세로) }

        // 초기값 설정
        for (i in 0 until 가로) {
            dp[i][0] = board[i][0]
            answer = Math.max(answer, dp[i][0])
        }

        for (j in 0 until 세로) {
            dp[0][j] = board[0][j]
            answer = Math.max(answer, dp[0][j])
        }

        // 각 위치에서 가능한 가장 큰 정사각형의 변의 길이 계산
        for (i in 1 until 가로) {
            for (j in 1 until 세로) {
                if (board[i][j] == 1) {
                    dp[i][j] = minOf(dp[i - 1][j - 1], minOf(dp[i - 1][j], dp[i][j - 1])) + 1
                    answer = Math.max(answer, dp[i][j])
                }
            }
        }

        return answer * answer // 넓이 반환
    }



}
