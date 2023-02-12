import java.util.Arrays;

public class SocksLaundering_230212 {
    public static void main(String[] args) {
        int K = 2;
        int [] C = {1,2,1,1};
        int [] D = {1,4,3,2,4};
        System.out.println(solution(K,C,D));
    }

    public static int solution(int K, int[] C, int[] D) {
        int answer = 0;
        //K = 세탁기가 청소할수 있는 양말수의 MAX
        //C = 깨끗한 양말 수
        //D = 더러운 양말 수

        int 최대요소수 = 51;

        int[] 깨끗한것 = new int[최대요소수];
        int[] 더러운것 = new int[최대요소수];


        for(int i : C) {
            //sort 하지 않고 있는 것 대로 저장
            깨끗한것[i] += 1;
        }

        for(int i : D) {
            //sort 하지 않고 있는 것 대로 저장
            더러운것[i] += 1;
        }

        for(int i = 1; i < 최대요소수; i++) {
            answer += 깨끗한것[i]/2;

            if(깨끗한것[i]%2 != 0 && K > 0 && 더러운것[i] > 0) {
                //깨끗한 양말 쌍  + 더러운 양말 쌍
                answer += 1;
                K -= 1;
                더러운것[i] -= 1;
            }
        }

        for(int i = 1; i < 최대요소수; i++) {
            //앞에서 더러운것을 처리하긴 했는데, 아직 남아있으면 쌍으로 묶어서 빤다
            if(K < 2){
                //2개보다 적으면 종료
                break;
            }
            if(더러운것[i] >= 2) {
                // i번 양말 쌍보다 세탁 가능한 양말 개수 K 중 더 작은 수 만큼만 세탁 가능
                int 세탁용 = Math.min(더러운것[i], K)/2;
                answer += 세탁용;
                K -= 세탁용*2;
            }
        }

        return answer;
    }
}
