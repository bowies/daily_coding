package programmers;
import java.util.*;

class 배달_Java_241128 {
    public int solution(int N, int[][] road, int K) {
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }
        
        int[] dist = new int[N + 1]; //다익스트라 
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0; // 시작점 1번 마을
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int currentNode = current.index;
            int currentDist = current.distance;
            
            if (currentDist > dist[currentNode]) continue;
            
            for (Node neighbor : graph.get(currentNode)) {
                int newDist = currentDist + neighbor.distance;
                if (newDist < dist[neighbor.index]) {
                    dist[neighbor.index] = newDist;
                    pq.offer(new Node(neighbor.index, newDist));
                }
            }
        }
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    class Node implements Comparable<Node> {
        int index;
        int distance;
        
        Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
        
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.distance, other.distance);
        }
    }
}