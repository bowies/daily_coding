package programmers

class 고고학_최고의_발견_Kotlin2_230731 {
    fun solution(clockHands: Array<IntArray>): Int {
        var answer: Int = Int.MAX_VALUE
        val length = clockHands.size

        // 시계를 회전하는 함수
        fun rotate(x: Int, y: Int, 각도: Int) {
            // 시계의 방향을 각도만큼 회전시킴 (0~3: 90도, 180도, 270도, 360도)
            clockHands[x][y] = (clockHands[x][y] + 각도) % 4
            // 상하좌우의 인접한 시계도 함께 회전
            if (x > 0) clockHands[x - 1][y] = (clockHands[x - 1][y] + 각도) % 4
            if (x < length - 1) clockHands[x + 1][y] = (clockHands[x + 1][y] + 각도) % 4
            if (y > 0) clockHands[x][y - 1] = (clockHands[x][y - 1] + 각도) % 4
            if (y < length - 1) clockHands[x][y + 1] = (clockHands[x][y + 1] + 각도) % 4
        }

        // DFS로 시계들의 상태를 탐색하며 최소 회전 횟수를 찾는 함수
        fun dfs(x: Int, y: Int, count: Int) {
            // 모든 시계의 상태를 탐색했을 때 (기저 조건)
            if (x == length) {
                // 마지막 시계가 12시 방향을 가리키면 최소 회전 횟수 갱신
                if (clockHands[length - 1][length - 1] == 0) answer = minOf(answer, count)
                return
            } else if (x == 0) {
                // 첫 번째 행의 시계들을 모든 회전 수(각도)에 대해 탐색
                for (각도 in 0..3) {
                    // 각도가 1 이상이면 해당 시계를 회전시키고 다음 행으로 이동하여 탐색
                    if (각도 >= 1) rotate(x, y, 1)
                    dfs(x + (y + 1) / length, (y + 1) % length, count + 각도)
                }
                // 회전 수에 따라 원래 상태로 되돌려줌
                rotate(x, y, 1)
            } else {
                // 마지막 행이 아닌 경우, 이전 행과의 시계 상태를 비교하여 일치하지 않으면 탐색 종료
                if (x == length - 1 && y > 0 && clockHands[x - 1][y] != clockHands[x][y - 1]) return
                // 이전 행과의 시계 상태를 맞추기 위한 회전 수(각도) 계산
                val 각도 = (4 - clockHands[x - 1][y]) % 4
                // 해당 시계를 회전시키고 다음 행으로 이동하여 탐색
                rotate(x, y, 각도)
                dfs(x + (y + 1) / length, (y + 1) % length, count + 각도)
                // 회전 수에 따라 원래 상태로 되돌려줌
                rotate(x, y, 4 - 각도)
            }
        }

        // DFS 호출을 통해 최소 회전 횟수를 찾음
        dfs(0, 0, 0)
        return answer
    }
}