package programmers;

import java.util.*;

class 무인도_여행_Java_240606{
    public int[] solution(String[] maps) {
        int 행 = maps.length;
        int 열 = maps[0].length();
        boolean[][] 방문한곳 = new boolean[행][열];
        List<Integer> answer = new ArrayList<>();
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        for (int i = 0; i < 행; i++) {
            for (int j = 0; j < 열; j++) {
                if (maps[i].charAt(j) != 'X' && !방문한곳[i][j]) {
                    int 식량 = bfs(maps, 방문한곳, i, j, 행, 열, dx, dy);
                    answer.add(식량);
                }
            }
        }
        
        if (answer.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(answer);
        return answer.stream().mapToInt(i -> i).toArray();
    }
    
    private int bfs(String[] maps, boolean[][] 방문한곳, int x, int y, int 행, int 열, int[] dx, int[] dy) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        int answer = 0;
        
        while (!stack.isEmpty()) {
            int[] 현재위치 = stack.pop();
            int 현재X = 현재위치[0];
            int 현재Y = 현재위치[1];
            
            if (방문한곳[현재X][현재Y]) {
                continue;
            }
            
            방문한곳[현재X][현재Y] = true;
            answer += Character.getNumericValue(maps[현재X].charAt(현재Y));
            
            for (int i = 0; i < 4; i++) {
                int 다음X = 현재X + dx[i];
                int 다음Y = 현재Y + dy[i];
                
                if (다음X >= 0 && 다음X < 행 && 다음Y >= 0 && 다음Y < 열 && !방문한곳[다음X][다음Y] && maps[다음X].charAt(다음Y) != 'X') {
                    stack.push(new int[]{다음X, 다음Y});
                }
            }
        }
        
        return answer;
    }
}
