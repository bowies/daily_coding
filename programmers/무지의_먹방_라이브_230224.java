package programmers;

import java.util.Arrays;

public class 무지의_먹방_라이브_230224 {
    public static void main(String[] args) {
        int [] food_times = {3,1,2};
        long k = 5;
        System.out.println(solution(food_times,k));

    }
    public static int solution(int[] task_times, long k) {

        long 총합 = 0;
        int 길이 = task_times.length;
        int[] 정렬용배열 = new int[길이];

        for (int i = 0; i < 길이; i++) {
            정렬용배열[i] = task_times[i];
            총합 += task_times[i];
        }

        if (총합 <= k) {
            //종료 시간이 먹을 것보다 크면 -1임 (섭취 불가)
            return -1;
        }

        Arrays.sort(정렬용배열);

        int 최소 = 0;
        int width = 길이;
        long cnt = 0;

        while (k >= width) {
            //최소값과 한바퀴 도는 길이보다 시간이 더 길면 while문 돌려서 계산한다.
            k -= width;
            cnt++;

            while(정렬용배열[최소] - cnt <= 0) {
                최소++;
                width--;
            }
        }

        for (int i = 0; i < 길이; i++) {
            task_times[i] -= cnt;
        }

        // 남은 시간은 순차적으로 계산
        //남은 시간 계산
        int counter = 0;
        
        while (k-- > 0) {
            while (task_times[counter] <= 0) {
                //이건 0 될때까지 계속 넘겨버림
                counter = (counter + 1) % task_times.length;
            }
            task_times[counter]--;
            counter = (counter + 1) % task_times.length;
        }

        // k 이후 다음번째 음식이 있을때까지 인덱스 넘김
        while (task_times[counter] <= 0) {
            counter = (counter + 1) % task_times.length;
        }


        counter++; //0부터 시작했으니까 +1해야 함
        return counter;
    }
}