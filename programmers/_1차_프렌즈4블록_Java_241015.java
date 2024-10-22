package programmers;

class _1차_프렌즈4블록_Java_241015 {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int totalRemoved = 0;
        boolean isFinished = false;

        while (!isFinished) {
            boolean[][] toBeRemoved = new boolean[m][n];
            isFinished = true;
            
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char block = map[i][j];
                    if (block != ' ' && block == map[i+1][j] && block == map[i][j+1] && block == map[i+1][j+1]) {
                        toBeRemoved[i][j] = true;
                        toBeRemoved[i+1][j] = true;
                        toBeRemoved[i][j+1] = true;
                        toBeRemoved[i+1][j+1] = true;
                        isFinished = false;
                    }
                }
            }
            
            // 지워진 블록 수 세기
            int removedThisRound = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (toBeRemoved[i][j]) {
                        map[i][j] = ' ';
                        removedThisRound++;
                    }
                }
            }
            totalRemoved += removedThisRound;
            
            // 블록이 아래로 떨어지도록 처리
            for (int j = 0; j < n; j++) {
                int emptyRow = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != ' ') {
                        char temp = map[i][j];
                        map[i][j] = ' ';
                        map[emptyRow][j] = temp;
                        emptyRow--;
                    }
                }
            }
        }
        
        return totalRemoved;
    }
}
