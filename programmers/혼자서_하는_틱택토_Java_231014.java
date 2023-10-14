package programmers;

import java.util.Arrays;
import java.util.stream.IntStream;
public class 혼자서_하는_틱택토_Java_231014 {

    public int solution(String[] board) {
        int O체크 = 0;
        int X체크 = 0;

        for (String 행 : board) {
            for (char 열 : 행.toCharArray()) {
                if (열 == 'O') {
                    O체크++;
                } else if (열 == 'X') {
                    X체크++;
                }
            }
        }

        if (X체크 > O체크 || O체크 - X체크 >= 2) {
            return 0;
        }

        boolean O가승리 = 승리체크(board, 'O');
        boolean X가승리 = 승리체크(board, 'X');

        if (O가승리 && X가승리) {
            return 0;
        }

        if (O가승리 && O체크 == X체크 || X가승리 && O체크 > X체크) {
            return 0;
        }

        return 1;
    }

    private boolean 승리체크(String[] board, char 승리대상) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == 승리대상 && board[i].charAt(1) == 승리대상 && board[i].charAt(2) == 승리대상) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0].charAt(i) == 승리대상 && board[1].charAt(i) == 승리대상 && board[2].charAt(i) == 승리대상) {
                return true;
            }
        }
        if (board[0].charAt(0) == 승리대상 && board[1].charAt(1) == 승리대상 && board[2].charAt(2) == 승리대상) {
            return true;
        }
        if (board[0].charAt(2) == 승리대상 && board[1].charAt(1) == 승리대상 && board[2].charAt(0) == 승리대상) {
            return true;
        }
        return false;
    }








    public int solution_stream(String[] board) {
        int O체크 = 0;
        int X체크 = 0;

        for (String 행 : board) {
            O체크 += 행.chars().filter(열 -> 열 == 'O').count();
            X체크 += 행.chars().filter(열 -> 열 == 'X').count();
        }

        if (X체크 > O체크 || O체크 - X체크 >= 2) {
            return 0;
        }

        boolean O가승리 = 승리체크_stream(board, 'O');
        boolean X가승리 = 승리체크_stream(board, 'X');

        if (O가승리 && X가승리) {
            return 0;
        }

        if (O가승리 && O체크 == X체크 || X가승리 && O체크 > X체크) {
            return 0;
        }

        return 1;
    }

    private boolean 승리체크_stream(String[] board, char 승리대상) {
        return Arrays.stream(board).anyMatch(행 -> 행.chars().allMatch(열 -> 열 == 승리대상))
                || IntStream.range(0, 3).anyMatch(i ->
                board[0].charAt(i) == 승리대상 && board[1].charAt(i) == 승리대상 && board[2].charAt(i) == 승리대상)
                || (board[0].charAt(0) == 승리대상 && board[1].charAt(1) == 승리대상 && board[2].charAt(2) == 승리대상)
                || (board[0].charAt(2) == 승리대상 && board[1].charAt(1) == 승리대상 && board[2].charAt(0) == 승리대상);
    }

}
