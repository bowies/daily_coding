package programmers;
import java.util.*;

class PCCP_기출문제_2번_석유_시추_Java_240127 {
    //출처 : https://howudong.tistory.com/434
    
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private List<Group> 그룹들 = new ArrayList<>();
    private int 가로길이, 세로길이;
    private boolean[][] 방문여부;
    private int[][] 땅;
    
    public int solution(int[][] 땅) {
        int 최대값 = 0;
        this.땅 = 땅;
        그룹들_초기화(땅);
        int[] 결과 = new int[땅[0].length];
        
        // 모든 석유 덩어리를 확인해서, 시추 가능한 땅의 열에 모두 저장
        for (int i = 0; i < 그룹들.size(); i++) {
            for (Integer 오프셋 : 그룹들.get(i).가능한Y) {
                결과[오프셋] += 그룹들.get(i).개수;
                최대값 = Math.max(최대값, 결과[오프셋]);
            }
        }
        return 최대값;
    }
    
    private void 그룹들_초기화(int[][] 땅) {
        방문여부 = new boolean[땅.length][땅[0].length];
        세로길이 = 땅.length;
        가로길이 = 땅[0].length;
        
        for (int i = 0; i < 땅.length; i++) {
            for (int j = 0; j < 땅[0].length; j++) {
            	// 석유가 없는 땅이거나, 이미 방문한 땅이면 패스
                if (방문여부[i][j] || 땅[i][j] == 0) continue;
                그룹들.add(bfs(i, j));
            }
        }
    }
    
    // 최종적으로 만들어지는 것은 석유 덩어리
    private Group bfs(int 시작X, int 시작Y) {
        Queue<List<Integer>> 큐 = new LinkedList<>();
        Set<Integer> 가능한Y = new HashSet<>();
        int 개수 = 1;
        큐.add(List.of(시작X, 시작Y));
        방문여부[시작X][시작Y] = true;
        가능한Y.add(시작Y);
        while (!큐.isEmpty()) {
            List<Integer> 임시 = 큐.poll();
            int x = 임시.get(0);
            int y = 임시.get(1);
            for (int i = 0; i < 4; i++) {
                int 새로운X = x + dx[i];
                int 새로운Y = y + dy[i];
                if (새로운X < 0 || 새로운Y < 0 || 새로운X >= 세로길이 || 새로운Y >= 가로길이
                  || 땅[새로운X][새로운Y] == 0 || 방문여부[새로운X][새로운Y]) continue;
                
                방문여부[새로운X][새로운Y] = true;
                큐.add(List.of(새로운X, 새로운Y));
                개수++;
                가능한Y.add(새로운Y);
            }
        }
        return new Group(가능한Y, 개수);
    }
    
    // 석유 덩어리 그룹 클래스를 만듦
    public class Group {
        int 개수;
        Set<Integer> 가능한Y;
        public Group(Set<Integer> 가능한Y, int 개수) {
            this.가능한Y = 가능한Y;
            this.개수 = 개수;
        }
    }

    
}