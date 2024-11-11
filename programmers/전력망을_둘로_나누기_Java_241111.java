package programmers;

import java.util.*;

class 전력망을_둘로_나누기_Java_241111 {
    
    public int solution(int n, int[][] wires) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        int minDifference = n;  
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            // 전선을 끊음
            graph.get(v1).remove((Integer) v2);
            graph.get(v2).remove((Integer) v1);
            
            // BFS를 이용하여 분리된 서브트리의 크기 구하기
            int sizeOfSubgraph = bfs(graph, n, v1);
            int difference = Math.abs(n - 2 * sizeOfSubgraph);  // 차이 계산
            minDifference = Math.min(minDifference, difference);
            
            // 전선 복구
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        return minDifference;
    }

    private int bfs(List<List<Integer>> graph, int n, int start) {
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        int count = 1;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                    count++;
                }
            }
        }
        
        return count;
    }
}
