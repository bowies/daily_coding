package programmers;

import java.util.HashMap;
import java.util.Map;

public class 다단계_칫솔_판매_230303 {
    public static void main(String[] args) {


        /*
            center : 두목님
            피라미드 구조의 판매
            모든 판매원은 이익금 10%를 추천인에게 배분하고 나머지는 내가 가짐
            그리고 내가 추천해준 사람한테 발생한 이익금까지 10% 가짐
            1개 팔면 100원 남음
            12개 팔면 1200원인데
            120원을 내 추천인한테 주고
            나머지 1080원을 가짐
            그럼 내 추천인은 120원 중 12원을 내 추천인의 추천인(2)에게 주고
            2는 어쩌구저쩌구 해서 결국 두목님은 1을 가짐
            그래서 각 추천인들이 먹은 것 + 두목님이 먹은 이익금을 나열한 배열을 계산하면 됨ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ

         */
        String [] 판매원 = {};
        String [] 다단계맨배열 = {};
        String [] 판매원데이터 = {};
        int [] 판매수량 = {};

    }


    private static Map<String,String> 호구목록 = new HashMap<>();
    private static Map<String,Integer> 돈이들어온다 = new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {

        int[] answer = new int[enroll.length];

        for(int i=0; i<enroll.length; i++) {
            //호구목록에 판매원 이름 + 다단계맨배열을 넣는다 (추천인 목록이다)
            호구목록.put(enroll[i], referral[i]);
        }

        for(int i=0; i<seller.length; i++) {
            //판매원 데이터(이름), 돈 * 100 (한개 팔면 100원씩 남음)
            돈나눠갖기(seller[i], amount[i] * 100);
        }

        for(int i=0; i<enroll.length; i++) {
            answer[i] = 돈이들어온다.getOrDefault(enroll[i], 0);
        }

        return answer;
    }

    private void 돈나눠갖기(String 판매원이름, int 돈) {
        if (판매원이름.equalsIgnoreCase("-") || 돈 == 0) {
            //추천 없이 셀프 가입은 "-"
            return;
        }
        int 나눠가질돈 = 돈 / 10;
        돈이들어온다.put(판매원이름, 돈이들어온다.getOrDefault(판매원이름, 0) + 돈 - 나눠가질돈);
        돈나눠갖기(호구목록.get(판매원이름), 나눠가질돈);
    }
}
