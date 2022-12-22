package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class 오지탐험가_221222 {

    
    public static void main(String[] args) {
        int n = 0;
        int [][] path = {{0,1},{0,3},{0,7},{8,1},{3,6},{1,2},{4,7},{7,5}};
        int [][] order = {{8,5},{6,7},{4,1}};
        solution(n, path, order);

        //모든 방을 적어도 한 번 방문
        //방 순서가 정해져 있음

    }


    public static boolean solution(int n, int[][] path, int[][] order) {

        int[] visited = new int[n];
        Queue<Integer> queue = new LinkedList<>();

        ArrayList<Integer>[] list = new ArrayList[n];
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();

        int NOT_VISITED = 0;
        int VISITED = 1;
        int WAITING = 2;
        
        for(int i = 0; i < n; i++) list[i] = new ArrayList<>();
        
        for(int[] i : path){ 
            //list에 path 정보 삽입
            list[i[0]].add(i[1]);
            list[i[1]].add(i[0]);
        }
        
        for(int[] i : order){ 
            //처음 -> 나중의 map 형태 만들기
            first.put(i[0], i[1]);
            last.put(i[1], i[0]);
        }
        
        if(last.keySet().contains(0)){
            //나중 map 형태에 0이 있는 경우에는 처음으로 가니까 조건 내에 포함되면 안됨
            return false; 
        }
        
        queue.offer(0);

        visited[0] = VISITED;

        while(!queue.isEmpty()){
            int popped = queue.poll(); // pop 한 뒤에 방문되지 않은 방 next를 해줌
            for(int i = 0; i < list[popped].size(); i++){
                int next = list[popped].get(i);

                if(visited[next] == NOT_VISITED){
                    if(last.keySet().contains(next)){ //다음에 갈 곳(next)의 선행 방의 방문 여부 확인 하여 분류
                        if(visited[last.get(next)] == VISITED){
                            queue.offer(next);
                            visited[next] = VISITED;
                        }else
                            visited[next] = WAITING;
                    }else{ // next의 후행 방이 waiting인 경우 visited로 바꿔주고 삽입

                        if(first.keySet().contains(next) && visited[first.get(next)] == WAITING){
                            queue.offer(first.get(next));
                            visited[first.get(next)] = VISITED;
                        }

                        queue.offer(next); // visited[next]를 visited로 바꾸고 삽입해줌
                        visited[next] = VISITED;
                    }
                }
            }
        }
        
        
        for(int i : visited){
            //방문한 곳에 VISITED가 아닌 값이 있으면 false
            if(i != VISITED){
                return false;
            }
        } 
            
        
        return true;
    }
}
