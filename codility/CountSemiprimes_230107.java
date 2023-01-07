package codility;

import java.util.Arrays;

public class CountSemiprimes_230107 {
    public static void main(String[] args) {
        CountSemiprimes_230107 c = new CountSemiprimes_230107();
        int N = 26;
        int [] P = {1,4,16};
        int [] Q = {26,10,20};
        int [] s = c.solution(N, P, Q);
        System.out.println(Arrays.toString(s));
        
        
    }
    

    public int[] solution(int N, int[] P, int[] Q) {
        int len = P.length;
        
        int[] arr = new int[N+1];
        int[] arrCheck = new int[N+1];
        int [] answer = new int[len];

        int temp = 2;
        while (temp * temp <= N) {
            if (arr[temp] == 0) {
                int cnt = temp * temp;
                while (cnt <= N) {
                    if (arr[cnt] == 0) {
                        arr[cnt] = temp;
                    }
                    cnt += temp;
                }
            }
            temp++;
        }

        for (int i = 4; i <= N; i++) {
            if (arr[i] > 0) {                 
                if (arr[i / arr[i]] == 0) {    
                    arrCheck[i] = 1;
                }
            }
        }

        int[] answerCheck = new int[N + 1]; //이 부근이 PreFix Sum 사용한 부분!
        //for문을 2중으로 사용하지 않을 수 있음!
        
        for (int p = 1; p < N+1; p++) {
            answerCheck[p] = answerCheck[p - 1] + arrCheck[p];
        }

        for (int i = 0; i < len; i++) {
            answer[i] = answerCheck[Q[i]] - answerCheck[P[i] - 1];
        }
        return answer;

        /*
        //소수  : 2 3 5 7 11 13 이런거 
        //반소수 : 소수의 곱인 자연수... : 4 6 9 10 14 15 21 이런거 - 를 세미프라임이라고 하나 봄

        //세미프라임의 수를 찾으라고 함
        int[] arr = new int[N+1]; //소수 계산용
        int[] arrCheck = new int[N + 1]; //계산 후 2차 체크용


        int temp = 2;
        //소수 계산용이라 2부터 시작
        //세미프라임이 주어진 값 이하일 때까지 while문 돌림
        while (temp * temp <= N) {
            if (arr[temp] == 0) {
                //첫 방문시에 값 넣어줌
                int cnt = temp * temp;
                while (cnt <= N) {
                    //세미프라임 <= 주어진값
                    if (arr[cnt] == 0) {
                        //값 없으면 temp를 넣어줌
                        arr[cnt] = temp;
                    }
                    cnt += temp;
                }
            }
            temp++;
        }




        int len = P.length;
        int [] answer = new int[P.length];
        for (int i = 0; i < len; i++) {
            answer[i] = 0;
            //P배열 i 번째부터 Q배열 i번째까지 돌려주면 됨
            for (int j = P[i]; j <= Q[i]; j++) {
                //중간에 break 없이 전체 다 순회하는 구조임

                if (arrCheck[j] == 0){ //확인한 적 없으면
                    arrCheck[j] = -1; //확인했다고 바꿈
                    // j가 세미프라임인지 확인
                    if (arr[j] > 0) {
                        if (arr[j / arr[j]] == 0) {
                            //나눠서 0이면 또 -1로 확인했다고 바꿔줌
                            arrCheck[j] = 1; // mark semiprime
                        }
                    }
                }
                //-1이 아니면 1추가

                answer[i] += arrCheck[j] > 0 ? 1 : 0;
            }
        }

        return answer;
        */
    }
}
