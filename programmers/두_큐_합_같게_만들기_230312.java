package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 두_큐_합_같게_만들기_230312 {

    public static void main(String[] args) {
        int [] q1 = {3, 2, 7, 2};
        int [] q2 = {4, 6, 5, 1};
        System.out.println(solution(q1, q2));
    }
    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        Queue<Integer> 진짜큐1 = new LinkedList<>();
        Queue<Integer> 진짜큐2 = new LinkedList<>();

        int length = queue1.length; //어차피 길이 똑같으니까 큐1로 한다
        long 큐1합 = Arrays.stream(queue1).sum();
        long 큐2합 = Arrays.stream(queue2).sum();
        long 총합 = 큐1합 + 큐2합;
        long 반값 = 0;


        //두 큐의 합이 같지 않을 경우부터 확인
        if(총합 % 2 != 0){
            return -1;
        }

        반값 = 총합 / 2; // 더해서 반이니까 총합의 반값이 해당되면 다른건 알아서 따라옴

        for (int i = 0; i < length; i++) {
            진짜큐1.add(queue1[i]);
            진짜큐2.add(queue2[i]);
        }

        int 임시값 = 0;

        while (큐1합 != 반값) {

            if (큐1합 < 반값) {
                임시값 = 진짜큐2.poll(); //반환은 해야 하니까 poll을 씀
                진짜큐1.add(임시값);
                큐1합 += 임시값;
            } else {
                임시값 = 진짜큐1.poll();
                진짜큐2.add(임시값);
                큐1합 -= 임시값;
            }

            answer++;

            if(answer>(length * 2 ) * 2){
                //길이 합보다 순회가 넘어가면 해봤자 도루묵이니까 그냥 -1 리턴해줌
                return -1;
            }
        }

        return answer;
    }
}
