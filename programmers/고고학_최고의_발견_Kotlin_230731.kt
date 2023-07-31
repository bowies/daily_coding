package programmers

class 고고학_최고의_발견_Kotlin_230731 {
    var maxInt = Int.MAX_VALUE // 시계의 개수 (N)의 최댓값을 저장하는 변수
    var answer = Int.MAX_VALUE // 최소 회전 횟수를 저장하는 변수
    lateinit var 시계상태: Array<IntArray> // 시계들의 상태를 저장하는 2차원 배열
    lateinit var 회전수: IntArray // 각 시계의 회전 횟수를 저장하는 배열
    val xArr = intArrayOf(0, 0, 0, 1, -1) // 회전할 때 인접한 시계의 행을 결정하는 배열
    val yArr = intArrayOf(0, 1, -1, 0, 0) // 회전할 때 인접한 시계의 열을 결정하는 배열

    // 시계들의 회전 수를 결정하는 dfs 함수
    fun dfs(입력값: Int) {
        // 모든 시계의 회전 수를 결정했을 때 (기저 조건)
        if (입력값 == maxInt) {
            val temp = Array(maxInt) { IntArray(maxInt) }
            val 현재회전수 = IntArray(maxInt)
            // 현재 시계의 회전 수를 복사
            for (i in 0 until maxInt)
                현재회전수[i] = 회전수[i]
            // 현재 시계 상태를 복사
            for (i in 0 until maxInt) {
                for (j in 0 until maxInt)
                    temp[i][j] = 시계상태[i][j]
            }

            var 회전횟수계산 = 0 // 회전 횟수를 계산하는 변수
            // 시계 상태를 시뮬레이션하며 회전 횟수를 계산
            for (i in 0 until maxInt) {
                for (j in 0 until maxInt) {
                    회전횟수계산 += 현재회전수[j]
                    for (k in 0..4) {
                        val X = i + xArr[k]
                        val Y = j + yArr[k]
                        // 인접한 시계의 위치가 범위를 벗어나면 건너뜀
                        if (X < 0 || Y < 0 || X >= maxInt || Y >= maxInt) continue
                        // 인접한 시계의 상태를 업데이트
                        temp[X][Y] = if (temp[X][Y] - 현재회전수[j] >= 0) temp[X][Y] - 현재회전수[j] else temp[X][Y] - 현재회전수[j] + 4
                    }
                }

                // 다음 행의 회전할 시계의 회전 수 결정
                for (j in 0 until maxInt)
                    현재회전수[j] = temp[i][j]
            }

            var flag = true
            // 마지막 열의 상태를 판별하여 모든 시계가 12시 방향을 가리키는지 확인
            for (i in 0 until maxInt) {
                if (현재회전수[i] != 0) {
                    flag = false
                    break
                }
            }
            // 모든 시계가 12시 방향을 가리키면 결과를 갱신
            if (flag) answer = answer.coerceAtMost(회전횟수계산)
            return
        }

        // 회전 수 정하기 (백트래킹)
        for (i in 0..3) {
            회전수[입력값] = i
            dfs(입력값 + 1)
        }
    }

    fun solution(clockHands: Array<IntArray>): Int {
        // 초기화
        maxInt = clockHands.size // 시계 개수를 결정
        시계상태 = Array(maxInt) { IntArray(maxInt) } // 시계 상태를 저장할 2차원 배열 생성
        회전수 = IntArray(maxInt) // 회전 수를 저장할 배열 생성
        // 시계의 상태를 변경하여 12시 방향을 0으로 맞춤
        for (i in 0 until maxInt) {
            for (j in 0 until maxInt)
                시계상태[i][j] = if (4 - clockHands[i][j] == 4) 0 else 4 - clockHands[i][j]
        }

        // dfs 진행하여 최소 회전 횟수 계산
        dfs(0)
        return answer // 최소 회전 횟수 반환
    }
}
