package programmers;

public class 예상대진표_221224 {
    public static void main(String[] args) {
        int n = 8;
        int a = 4;
        int b = 7;
        int ans = solution(n, a, b);
        System.out.println(ans);

    }
    public static int solution(int n, int a, int b)
    {
        int answer = 0;

        /*
         * n명 : 참가자
         * 1~n명까지 배정받음
         * a번 참가자가 b번 참가자랑 만날 라운드 수 찾기
         * 
         * 1 - 2
         * 3 - [4]
         * 5 - 6
         * [7] - 8
         * 
         * 1 - [4]
         * 5 - [7]
         * 
         * [4] - [7] = 3라운드
         * 
         * 다음 라운드에 배정되는 수 : (현재 숫자 + 1)/2
         */
        
         while(true){
            a = (a+1)/2;
            b = (b+1)/2;
            answer++;

            if(a==b){
                break;
            }
         }

        return answer;
    }
}
