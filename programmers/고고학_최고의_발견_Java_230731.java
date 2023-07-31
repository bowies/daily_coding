package programmers;

class 고고학_최고의_발견_Java_230731 {

    // 출처 : https://velog.io/@ddongh1122/%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-%EA%B3%A0%EA%B3%A0%ED%95%99-%EC%B5%9C%EA%B3%A0%EC%9D%98-%EB%B0%9C%EA%B2%AC

    /*
    고고학자인 혜선은 오래전부터 성궤의 행방을 추적해왔습니다.
    그동안 그의 연구는 주류 학자들로부터 인정받지 못했었지만,
    혜선이는 포기하지 않고 조사를 계속했고 마침내 성궤의 행방을 알아내었습니다.

    그러나 오래전 누군가로부터 봉인된 성궤는 특별한 잠금장치에 의해 보호되고 있었습니다.
    잠금장치는 일종의 퍼즐과 연결되어 퍼즐을 해결하면 열리는 것으로 보입니다.

    퍼즐은 시계들이 행렬을 이루는 구조물인데 하나의 시계에 시곗바늘은 하나씩만 있습니다.
    각 시곗바늘은 시계방향으로만 돌릴 수 있고 한 번의 조작으로 90도씩 돌릴 수 있습니다.
    시계들은 기계장치에 의해 연결되어 있어 어떤 시계의 시곗바늘을 돌리면
    그 시계의 상하좌우로 인접한 시계들의 시곗바늘도 함께 돌아갑니다.
    행렬의 모서리에 위치한 시계의 시곗바늘을 돌리는 경우에는
    인접한 세 시계의 시곗바늘들이 함께 돌아가며,
    꼭짓점에 위치한 시계의 시곗바늘을 돌리는 경우에는
    인접한 두 시계의 시곗바늘들이 함께 돌아갑니다.

    각 시계는 12시, 3시, 6시, 9시 방향 중의 한 방향을 가리키고 있습니다.
    각 시계의 시곗바늘을 적절히 조작하여
    모든 시곗바늘이 12시 방향을 가리키면 퍼즐이 해결되어 성궤를 봉인하고 있는 잠금장치가 열릴 것입니다.

    노후화된 퍼즐 기계장치가 걱정되었던 혜선은 가능한 최소한의 조작으로 퍼즐을 해결하려고 합니다.
    시곗바늘들의 행렬 clockHands가 매개변수로 주어질 때,
    퍼즐을 해결하기 위한 최소한의 조작 횟수를 return 하도록 solution 함수를 완성해주세요.

    제한사항
    2 ≤ clockHands의 길이 ≤ 8
    clockHands는 2차원 배열이며 행과 열의 크기가 동일합니다.
    0 ≤ clockHands의 원소 ≤ 3
    clockHands[i]의 원소들은 시곗바늘의 방향을 나타내며 0은 12시 방향, 1은 3시 방향, 2는 6시 방향, 3은 9시 방향을 나타냅니다.
    해결 가능한 퍼즐만 주어집니다.

    입출력 예
    clockHands	result
    [[0,3,3,0],[3,2,2,3],[0,3,2,0],[0,3,3,3]]	3
     */
    int maxInt = Integer.MAX_VALUE; // 시계의 개수 (N)의 최댓값을 저장하는 변수
    int answer = Integer.MAX_VALUE; // 최소 회전 횟수를 저장하는 변수
    int[][] 시계상태; // 시계들의 상태를 저장하는 2차원 배열
    int[] 회전수; // 각 시계의 회전 횟수를 저장하는 배열
    int[] xArr = {0, 0, 0, 1, -1}; // 회전할 때 인접한 시계의 행을 결정하는 배열
    int[] yArr = {0, 1, -1, 0, 0}; // 회전할 때 인접한 시계의 열을 결정하는 배열

    // 시계들의 회전 수를 결정하는 dfs 함수
    public void dfs(int 입력값) {
        // 모든 시계의 회전 수를 결정했을 때 (기저 조건)
        if (입력값 == maxInt) {
            int[][] temp = new int[maxInt][maxInt];
            int[] 현재회전수 = new int[maxInt];
            // 현재 시계의 회전 수를 복사
            for (int i = 0; i < maxInt; i++)
                현재회전수[i] = 회전수[i];
            // 현재 시계 상태를 복사
            for (int i = 0; i < maxInt; i++) {
                for (int j = 0; j < maxInt; j++)
                    temp[i][j] = 시계상태[i][j];
            }

            int 회전횟수계산 = 0; // 회전 횟수를 계산하는 변수
            // 시계 상태를 시뮬레이션하며 회전 횟수를 계산
            for (int i = 0; i < maxInt; i++) {
                for (int j = 0; j < maxInt; j++) {
                    회전횟수계산 += 현재회전수[j];
                    for (int k = 0; k < 5; k++) {
                        int X = i + xArr[k];
                        int Y = j + yArr[k];
                        // 인접한 시계의 위치가 범위를 벗어나면 건너뜀
                        if (X < 0 || Y < 0 || X >= maxInt || Y >= maxInt) continue;
                        // 인접한 시계의 상태를 업데이트
                        temp[X][Y] = temp[X][Y] - 현재회전수[j] >= 0 ? temp[X][Y] - 현재회전수[j] : temp[X][Y] - 현재회전수[j] + 4;
                    }
                }

                // 다음 행의 회전할 시계의 회전 수 결정
                for (int j = 0; j < maxInt; j++)
                    현재회전수[j] = temp[i][j];
            }

            boolean flag = true;
            // 마지막 열의 상태를 판별하여 모든 시계가 12시 방향을 가리키는지 확인
            for (int i = 0; i < maxInt; i++) {
                if (현재회전수[i] != 0) {
                    flag = false;
                    break;
                }
            }
            // 모든 시계가 12시 방향을 가리키면 결과를 갱신
            if (flag) answer = Math.min(answer, 회전횟수계산);
            return;
        }

        // 회전 수 정하기 (백트래킹)
        for (int i = 0; i < 4; i++) {
            회전수[입력값] = i;
            dfs(입력값 + 1);
        }
    }

    public int solution(int[][] clockHands) {
        // 초기화
        maxInt = clockHands.length; // 시계 개수를 결정
        시계상태 = new int[maxInt][maxInt]; // 시계 상태를 저장할 2차원 배열 생성
        회전수 = new int[maxInt]; // 회전 수를 저장할 배열 생성
        // 시계의 상태를 변경하여 12시 방향을 0으로 맞춤
        for (int i = 0; i < maxInt; i++) {
            for (int j = 0; j < maxInt; j++)
                시계상태[i][j] = 4 - clockHands[i][j] == 4 ? 0 : 4 - clockHands[i][j];
        }

        // dfs 진행하여 최소 회전 횟수 계산
        dfs(0);
        return answer; // 최소 회전 횟수 반환
    }
}
