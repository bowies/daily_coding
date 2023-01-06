package programmers;

import java.util.PriorityQueue;

public class 더맵게_230106 {
    public static void main(String[] args) {
        더맵게_230106 the = new 더맵게_230106();
        int [] scoville = {1,2,3,9,10,12};
        int K = 7;
        System.out.println(the.solution(scoville, K));
        System.out.println(the.solution2(scoville, K));
    }


    public int solution2(int[] scoville, int K) {
        PriorityQueue <Integer> queue = new PriorityQueue<>();

        int answer = 0;

        for(int i : scoville){
            queue.add(i);
        }

        while (queue.size() >= 2 && queue.peek() < K) {
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }

        return queue.peek() >= K ? answer : -1;
    }

    
    public int solution(int[] scoville, int K) {
        int answer = 0;

        //섞은 음식의 스코빌 지수 = 가장 맵지 않은 음식의 스코빌 지수 + (두 번째로 맵지 않은 음식의 스코빌 지수 * 2)
        //Leo는 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복하여 섞습니다.
        //Arrays.sort를 안 쓰면 ↓ 이렇게 푼다

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        
        for (int i = 0; i < scoville.length; i++) {
            queue.add(scoville[i]);
        }

        while(queue.peek() < K) {
            if (queue.size() == 1){
                return -1;
            }
            queue.add(queue.poll() + queue.poll() * 2);
            answer++;
        }
        return answer;
    }
}
