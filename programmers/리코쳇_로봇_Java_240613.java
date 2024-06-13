package programmers;

import java.util.*;

class 리코쳇_로봇_Java_240613 {
    
    public int solution(String[] board) {
        int 행 = board.length;
        int 열 = board[0].length();
        int[][] 상하좌우 = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        int 초기X = 0, 초기Y = 0, 목표X = 0, 목표Y = 0;
        boolean 로봇위치 = false, 목표위치 = false;
        
        for (int i = 0; i < 행; i++) {
            for (int j = 0; j < 열; j++) {
                if (board[i].charAt(j) == 'R') {
                    초기X = i;
                    초기Y = j;
                    로봇위치 = true;
                }
                if (board[i].charAt(j) == 'G') {
                    목표X = i;
                    목표Y = j;
                    목표위치 = true;
                }
                if (로봇위치 && 목표위치) break; //다 찾음
            }
            if (로봇위치 && 목표위치) break;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[행][열];

        queue.add(new int[] {초기X, 초기Y, 0});
        visited[초기X][초기Y] = true;
        
        //BFS
        while (!queue.isEmpty()) {
            int[] 현재위치 = queue.poll();
            int x = 현재위치[0], y = 현재위치[1], 이동횟수 = 현재위치[2];
            
            if (x == 목표X && y == 목표Y) {
                return 이동횟수;  // 도착
            }
            
            for (int[] direction : 상하좌우) {
                int 이동한X = x, 이동한Y = y;
                
                while (true) {
                    int 다음X = 이동한X + direction[0];
                    int 다음Y = 이동한Y + direction[1];

                    if (다음X < 0 || 다음X >= 행 || 다음Y < 0 || 다음Y >= 열 || board[다음X].charAt(다음Y) == 'D') {
                        //경계 | 장애물에 마주침
                        break;
                    }
                    
                    이동한X = 다음X;
                    이동한Y = 다음Y;
                }
                
                if (!visited[이동한X][이동한Y]) {
                    //아직 방문되지 않은 위치가 새로운 위치면 방문 처리 후 큐에 추가
                    visited[이동한X][이동한Y] = true;
                    queue.add(new int[] {이동한X, 이동한Y, 이동횟수 + 1});
                }
            }
        }
        
        return -1; //지점 도달 실패
    }
}
