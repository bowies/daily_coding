package programmers;

public class 멀리뛰기_221223 {
    
    public static void main(String[] args) {
        int n = 4;
        solution(n);
    }
    public static long solution(int n) {
        long answer = 0;

        //이거 그냥 DP 문제임
        //dp[i] = dp[i-2] + dp[i-1]
        int [] arr = new int [2001]; //1~2000

        arr[1] = 1;
        arr[2] = 2;

        for(int i =3; i<2001; i++){
            arr[i] = (arr[i-2] + arr[i-1])%1234567;
        }
        answer = arr[n];
        System.out.println(answer);
        return answer;
    }
}
