package programmers;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class 이중우선순위큐_221230 {
    public static void main(String[] args) {
        //String [] operations = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String [] operations = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int [] arr = solution(operations);
        System.out.println(Arrays.toString(arr));
    }

    
    public static int[] solution(String[] operations) {
        /*
            16과 -5643을 삽입합니다.
            최솟값을 삭제합니다. -5643이 삭제되고 16이 남아있습니다.
            최댓값을 삭제합니다. 16이 삭제되고 이중 우선순위 큐는 비어있습니다.
            우선순위 큐가 비어있으므로 최댓값 삭제 연산이 무시됩니다.
            123을 삽입합니다.
            최솟값을 삭제합니다. 123이 삭제되고 이중 우선순위 큐는 비어있습니다.
                        
            I 숫자	큐에 주어진 숫자를 삽입합니다.
            D 1	큐에서 최댓값을 삭제합니다.
            D -1	큐에서 최솟값을 삭제합니다.
         * 
         */
        int [] answer = new int[2];
        PriorityQueue <Integer> minQueue = new PriorityQueue <Integer>();
        PriorityQueue <Integer> maxQueue = new PriorityQueue <Integer>(Collections.reverseOrder()); //reverse를 매번 시키지 말고 이걸 쓰자!
        String [] temp = new String[2];

        for(String s : operations){
            temp = s.split(" ");
            //System.out.println("ㅎㅅㅎ" + temp[0] + " " + temp[1]);

            switch(temp[0]){
                case "I":
                    //큐에 숫자 삽입
                    minQueue.add(Integer.parseInt(temp[1]));
                    maxQueue.add(Integer.parseInt(temp[1]));
                    break;
                case "D":
                    if(minQueue.isEmpty()){
                        break;
                    }else if(temp[1].equals("-1")){
                        //최소값 삭제
                        maxQueue.remove(minQueue.poll());
                        break;
                        
                    }else{
                        //최대값 삭제
                        minQueue.remove(maxQueue.poll());
                        break;
                    }
                default:
                    break;
            }

        }
        
        /*
            while(!minQueue.isEmpty()){

                System.out.println("ㅇㅅㅇ" + minQueue.poll());
            }
         */
        if(minQueue.isEmpty()){
            answer[0] = 0;
            answer[1] = 0;
        }else{
            answer[0] = maxQueue.peek();
            answer[1] = minQueue.peek();
        }

        return answer;
    }
}
