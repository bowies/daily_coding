package programmers;

import java.util.LinkedList;
import java.util.Queue;

class 미로_탈출_Java_240604 {
    private final int[] x이동기 = {-1, 1, 0, 0};
    private final int[] y이동기 = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int 세로 = maps.length;
        int 가로 = maps[0].length();
        
        좌표저장 시작점 = null;
        좌표저장 레버 = null;
        좌표저장 출구 = null;

        for (int i = 0; i < 세로; i++) {
            for (int j = 0; j < 가로; j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') 시작점 = new 좌표저장(i, j);
                if (c == 'L') 레버 = new 좌표저장(i, j);
                if (c == 'E') 출구 = new 좌표저장(i, j);
            }
        }
        
        int 시작to레버 = bfs(maps, 시작점, 레버, 세로, 가로);
        if (시작to레버 == -1) return -1;
        
        int 레버to출구 = bfs(maps, 레버, 출구, 세로, 가로);
        if (레버to출구 == -1) return -1;
        
        return 시작to레버 + 레버to출구;
    }
    
    private int bfs(String[] maps, 좌표저장 시작점, 좌표저장 끝지점, int 세로, int 가로) {
        boolean[][] 방문 = new boolean[세로][가로];
        
        Queue<좌표저장> 큐 = new LinkedList<>();        
        큐.offer(시작점);
        
        방문[시작점.x][시작점.y] = true;
        
        int 거리 = 0;
        
        while (!큐.isEmpty()) {
            int 큐크기 = 큐.size();
            for (int i = 0; i < 큐크기; i++) {
                좌표저장 현재 = 큐.poll();
                if (현재.x == 끝지점.x && 현재.y == 끝지점.y) {
                    return 거리;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = 현재.x + x이동기[j];
                    int ny = 현재.y + y이동기[j];
                    if (nx >= 0 && ny >= 0 && nx < 세로 && ny < 가로 && !방문[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        큐.offer(new 좌표저장(nx, ny));
                        방문[nx][ny] = true;
                    }
                }
            }
            거리++;
        }
        return -1; //망함
    }
    

    private static class 좌표저장 {
        int x, y;
        좌표저장(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
