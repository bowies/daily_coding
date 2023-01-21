import java.util.Arrays;

public class MinAbsSum_230121 {
    public static void main(String[] args) {
        int [] A = {1,5,2,-2};
        System.out.println(solution(A));
    }
    /*
            {−1, 1} 집합에서 N 정수의 배열 A와 N 정수의 시퀀스 S에 대해 다음과 같이 val(A, S)를 정의합니다.
            값(A, S) = | 합계 { A[i]*S[i] for i = 0..N−1 }|
            (0 요소의 합이 0이라고 가정합니다.)
            주어진 배열 A에 대해 우리는 val(A,S)를 최소화하는 시퀀스 S를 찾고 있습니다.

            N개의 정수 배열 A가 주어지면 세트 {−1, 1}에서 N 정수의 모든 가능한 시퀀스 S에 대해
            val(A,S)의 모든 가능한 값에서 val(A,S)의 최소값을 계산합니다.
            예를 들어 주어진 배열은 다음과 같습니다.
            A[0] = 1
            A[1] = 5
            A[2] = 2
            A[3] = -2
            S = [−1, 1, −1, 1], val(A, S) = 0에 대해 가능한 최소값이므로 함수는 0을 반환해야 합니다.
     */
    
     public static int solution(int[] A) {
        //정수 배열이 주어지면 요소의 최소 절대 합계를 찾는다
    
        if (A.length == 0){
            return 0;
        }else if (A.length == 1){
            return A[0];
        }

        int 총합 = 0;
        int 최대값 = A[0];

        for (int i = 0; i < A.length; i++) {
            //음수나 양수나 똑같으므로 그냥 abs를 사용한다
            A[i] = Math.abs(A[i]);
            총합 += A[i];
            최대값 = Math.max(A[i], 최대값);
        }

        //System.out.println(총합 + " ㅇㅅㅇ "  + 최대값 );

        int[] A계산용 = new int[최대값 + 1];
        for (int num : A) {
            A계산용[num]++;
        }


        int[] dp = new int[총합 + 1];
        Arrays.fill(dp, -1); //나중에 0보다 크면 계산용임

        dp[0] = 0;

        for (int i = 0; i <= 최대값; i++) {
            if (A계산용[i] > 0) {
                for (int j = 0; j <= 총합; j++) {
                    if (dp[j] >= 0)
                        dp[j] = A계산용[i];
                    else if (j >= i && dp[j - i] > 0) {
                        dp[j] = dp[j - i] - 1;
                    }
                }
            }
        }

        int answer = 총합;
        for (int i = 0; i <= 총합 / 2; i++) {
            if (dp[i] >= 0)
                answer = Math.min(answer, 총합 - (2 * i));
        }
        return answer;
    }
}
