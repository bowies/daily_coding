package programmers;

import java.util.Arrays;

public class 징검다리_230307 {

    public static void main(String[] args) {
        int 도착지점 = 25;
        int [] 돌 = {2,14,11,21,17};
        int 제거해야하는바위의수 = 2;

        System.out.println(solution(도착지점,돌,제거해야하는바위의수));
    }
    public static int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);

        //n개 제거를 할 건데
        //각 지점 사이 거리의 최소값 중 가장 큰 값 리턴하도록 함수 작성
        //이분탐색

        int answer = 0;

        int 왼쪽 = 0;
        int 오른쪽 = distance;

        while(왼쪽 <= 오른쪽) {
            int 중간 = (왼쪽 + 오른쪽) / 2;
            int 돌없애기 = 0;
            int 없앨라그런돌 = 0;

            for(int i = 0; i < rocks.length; i++) {
                if (rocks[i] - 없앨라그런돌 < 중간){
                    돌없애기++;
                }
                else {
                    없앨라그런돌 = rocks[i];
                }
            }
            if(distance - rocks[rocks.length-1] < 중간){
                돌없애기++;

            }
            if(돌없애기 <= n) {
                answer = 중간;
                왼쪽 = 중간 + 1;
            }
            else {
                오른쪽 = 중간 - 1;
            }
        }

        return answer;

    }
}
