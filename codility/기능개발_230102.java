import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발_230102 {
    public static void main(String[] args) {
        int [] progresses = {93, 30, 55};
        int [] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));

    }
    public static int[] solution(int[] progresses, int[] speeds) {

        Queue <Integer> queue = new LinkedList<>(); //작업일수 저장용
        ArrayList <Integer> list = new ArrayList<>(); // 결과 저장용

        int temp = 0;
        for(int i = 0; i < speeds.length; i++){
            //작업일 계산해서 큐에 넣음
            temp = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            queue.offer(temp);
        }

        int count = 1;    
        int poll = queue.poll(); //첫번째 항목 꺼내서 초기화
        
        while(!queue.isEmpty()){
            temp = queue.poll();

            if(poll >= temp){
                count++;
            }
            else{
                list.add(count); 
                poll = temp;
                count = 1; 
            }
        }
        
        list.add(count);
  
        int [] answer = list.stream().mapToInt(i -> i).toArray();
        //int [] answer = list.stream().mapToInt(Integer::intValue).toArray();
        //int [] answer = list.stream().filter(i -> i != null).mapToInt(i -> i).toArray(); 
        //↑ 아무거나 써도 됨        
          
        return answer;
    }
}
