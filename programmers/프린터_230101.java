package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터_230101 {
    public static void main(String[] args) {
        int [] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;
        System.out.println(solution(priorities, location));

    }

    
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        int len = priorities.length;

        PriorityQueue <Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0; i < len; i++){
            queue.add(priorities[i]);
        }

        while(queue.isEmpty() == false){
            for(int i = 0; i < len; i++){
                if(priorities[i] == queue.peek()){
                    //System.out.println("" + priorities[i] + "  " +  i);
                    if(i == location){
                        answer++;
                        return answer;
                    }
                    queue.poll();
                    answer++;
                }
            }
        }


        answer = -1; //초기값을 -1하고 ++해도 되겠지만...
        return answer;
    }

    public static int solutions(int[] priorities, int location) {
        int answer = 0;

        int max = 0;
        int len = priorities.length;

        while (true) {
            answer++;
            max = 0;
            int maxIndex = 0;
            // max 찾기
            for (int i = 0; i < len; i++) {
                if (max < priorities[i]) {
                    max = priorities[i];
                    maxIndex = i;
                }
            }

            // 처음값이 최대값이 아니라면 회전하기 - location 값 변경

            if (maxIndex != 0) {
                int[] tempArr = new int[maxIndex];

                for (int i = 0; i < maxIndex; i++) {
                    tempArr[i] = priorities[i];
                }

                int j;
                for (j = 0; j+maxIndex < len; j++) {
                    priorities[j] = priorities[j+maxIndex];
                }

                for (int i = 0; i < maxIndex; i++) {
                    priorities[j++] = tempArr[i];
                }

                location -= maxIndex;

                if (location < 0) {
                    location += len;
                }

            }


            if (location == 0)
                break;


            for (int i = 1; i < len; i++) {
                priorities[i - 1] = priorities[i];
            }
            location--;
            len--;
        }

        return answer;
    }
}
