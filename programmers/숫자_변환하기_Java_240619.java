package programmers;

import java.util.*;

class 숫자_변환하기_Java_240619 {
    public int solution(int x, int y, int n) {
        if (x == y){
            //같을 시에는 처리 하지 않음
            return 0;
        }
        
        Queue<int[]> bfs = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        
        bfs.add(new int[]{x, 0}); //처음 값 : 0
        visited.add(x);
        
        while (!bfs.isEmpty()) {
            int[] now = bfs.poll();
            int 현재값 = now[0];
            int 현재count = now[1];

            int[] 다음값처리 = {현재값 + n, 현재값 * 2, 현재값 * 3};
            
            for (int i : 다음값처리) {
                if (i == y) {
                    return 현재count + 1;
                }
                
                if (i < y && !visited.contains(i)) {
                    bfs.add(new int[]{i, 현재count + 1});
                    visited.add(i);
                }
            }
        }
        
        return -1;
    }
}
