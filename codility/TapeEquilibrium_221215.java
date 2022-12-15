package codility;

class TapeEquilibrium_221215 {
    public static void main(String[] args) {
        int [] A = {3,1,2,4,3};
        solution(A);
        
    }
    public static int solution(int[] A) {
        //미리 값 계산 안 해놓으면 너무나 시간 복잡도 올라감
        //answer 초기값은 그냥 최대값으로 지정해놨음
        //절대값 사용하기 <- 포인트

        int answer = 100000;
        int [] dp = new int[A.length]; 
        dp[0] = A[0];

        for(int i = 1; i < A.length; i++){
            dp[i] = dp[i-1] + A[i];
        }
        //dp 마지막 : 총합

        for(int i = 1; i < A.length; i++){
            answer = Math.min(answer, Math.abs((dp[i-1]) - (dp[A.length-1]-dp[i-1])));
        }

        return answer;
    }
}


