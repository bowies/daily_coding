package programmers;
import java.util.Stack;

class 크레인_인형뽑기_게임_Java_241013 {
    
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> basket = new Stack<>(); 
        
        for (int move : moves) {
            int column = move - 1; // 크레인 위치에 맞는 열 찾기
            
            for (int i = 0; i < board.length; i++) {
                if (board[i][column] != 0) {
                    int doll = board[i][column]; 
                    board[i][column] = 0; // 인형을 집었으니 해당 위치를 빈칸으로 만듦
                    
                    if (!basket.isEmpty() && basket.peek() == doll) {
                        basket.pop();
                        answer += 2; // 두 개의 인형
                    } else {
                        basket.push(doll);
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}
