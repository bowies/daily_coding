package programmers;

class PCCE_기출문제_9번_이웃한_칸_Java_240618 {
    public int solution(String[][] board, int h, int w) {
        int length = board.length;
        int answer = 0;
        int[] h방향 = {0, 1, -1, 0};
        int[] w방향 = {1, 0, 0, -1};

        for (int i = 0; i < 4; i++) {
            int h좌표 = h + h방향[i];
            int w좌표 = w + w방향[i];

            if (0 <= h좌표 && h좌표 < length && 0 <= w좌표 && w좌표 < length) {
                if (board[h][w].equals(board[h좌표][w좌표])) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
