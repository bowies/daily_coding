package programmers;

import java.util.Collections;
import java.util.PriorityQueue;

public class 야근지수_230103 {
    public static void main(String[] args) {
        //int n = 4;
        //int [] works = {4,3,3};
        int n = 1;
        int [] works = {2,1,2};
        System.out.println(solution(n, works));
    }

    
    public static long solution(int n, int[] works) {
        //야근피로도 : 제곱이 되므로 줄여주는 것이 관건이다.

        long answer = 0;
        int temp = 0;
        PriorityQueue <Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0; i < works.length; i++){
            queue.add(works[i]);

        }

        while(n > 0){
            temp = queue.poll();
            if(temp == 0){
                break;
            }else{
                temp--;
                queue.add(temp);
                n--;
            }

        }

        for(int i : queue){
            //Integer 선언 안 해주면 for문 귀찮음...
            answer = answer + i*i;
        }
        return answer;
    }
}
