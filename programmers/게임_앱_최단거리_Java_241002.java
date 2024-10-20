package programmers;

import java.util.LinkedList;
import java.util.Queue;

class 게임_앱_최단거리_Java_241002 {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // 0,0에서 시작
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                //상-하-좌-우 탐색
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && maps[nx][ny] == 1) {
                    //맵 범위 안에 있고, 벽이 아니면 이동 가능한 칸인데, 그러면 이전 칸 값에 1을 더해서 기록한다.
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        
        // 상대 팀 진영에 도착하지 못한 경우에는 -1을 반환한다.
        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}
