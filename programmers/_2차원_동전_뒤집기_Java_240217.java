package programmers;

class _2차원_동전_뒤집기_Java_240217 {
    public int solution(int[][] beginning, int[][] target) {
        int 행 = beginning.length;
        int 열 = beginning[0].length;
        int 경우의수 = 1 << (행 + 열);
        int 최소뒤집기횟수 = 21;
        int[][] 그래프 = new int[행][열];

        for (int 바이너리 = 0; 바이너리 < 경우의수; 바이너리++) {
            for (int y = 0; y < 행; y++)
                for (int x = 0; x < 열; x++)
                    그래프[y][x] = beginning[y][x];

            int 이동횟수 = 0;
            // 앞 행부터 뒤집기
            for (int i = 0; i < 행; i++) {
                int 행비트 = 1 << i;
                // 뒤집기
                if ((바이너리 & 행비트) != 0) {
                    이동횟수++;
                    // 행 뒤집기
                    for (int j = 0; j < 열; j++)
                        그래프[i][j] = 그래프[i][j] == 1 ? 0 : 1;
                }
            }
            // 열 뒤집기
            for (int j = 0; j < 열; j++) {
                int 열비트 = 1 << (j + 행);
                if ((바이너리 & 열비트) != 0) {
                    이동횟수++;
                    // 열 뒤집기
                    for (int i = 0; i < 행; i++)
                        그래프[i][j] = 그래프[i][j] == 1 ? 0 : 1;
                }
            }

            boolean 일치확인 = true;
            for (int i = 0; i < 행; i++) {
                for (int j = 0; j < 열; j++) {
                    if (그래프[i][j] != target[i][j]) {
                        일치확인 = false;
                        break;
                    }
                }
                if (!일치확인)
                    break;
            }
            if (일치확인)
                최소뒤집기횟수 = Math.min(최소뒤집기횟수, 이동횟수);
        }

        if (최소뒤집기횟수 == 21)
            최소뒤집기횟수 = -1;

        return 최소뒤집기횟수;
    }
}
