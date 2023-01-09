package programmers;

import java.util.Arrays;

public class 땅따먹기_230109 {
    public static void main(String[] args) {
        땅따먹기_230109 land = new 땅따먹기_230109();
        int [][] arr = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};

        System.out.println(land.solution(arr));
    }
    int solution(int[][] land) {
        //땅은 N행 4열
        //1행 4열을 밟으면 2행 4열은 못밟음
        
        //어차피 전체 탐색은 해야함
        // 0 1 2 3
        // 1 0 2 3
        // 2 


        for(int i = 1; i < land.length; i++){

            land[i][0] += Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]); //0 - 123 

            land[i][1] += Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]); //1 - 023 
            
            land[i][2] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]); //2 - 013 
        	
            land[i][3] += Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]); //3 - 012

            /*
            for(int j : land[i]){
                System.out.print(j + " ");
            }
            System.out.println(i+"입니다");
             */
        }


        int[] answer = land[land.length-1];
        Arrays.sort(answer);

        return answer[answer.length-1];


        /*
          
         와... ↓
         (=.=)
         
        int hopscotch(int[][] board, int size) {
            for(int i=1; i<size; i++) {
                board[i][0] += Math.max(board[i-1][1], Math.max(board[i-1][2], board[i-1][3]));
                board[i][1] += Math.max(board[i-1][0], Math.max(board[i-1][2], board[i-1][3]));
                board[i][2] += Math.max(board[i-1][0], Math.max(board[i-1][1], board[i-1][3]));
                board[i][3] += Math.max(board[i-1][0], Math.max(board[i-1][1], board[i-1][2]));
            }
            return Math.max(board[size-1][0], Math.max(board[size-1][1], Math.max(board[size-1][2], board[size-1][3])));
        }

        public static void main(String[] args) {
            Hopscotch c = new Hopscotch();
            int[][] test = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
            //아래는 테스트로 출력해 보기 위한 코드입니다.
            System.out.println(c.hopscotch(test, 3));
        } 
          
         */
    }
}
