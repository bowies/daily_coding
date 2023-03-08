package programmers;

import java.util.Arrays;

public class 거스름돈_230308 {
    public int solution(int n, int[] money) {
        int[] answer = new int[100001];
        answer[0] = 1;

        for(int i : money) {
            for(int j = i; j <= n; j++) {
                answer[j] += answer[j-i];
            }
        }
        return answer[n];
    }


    //이것과 유사한
    public int solution2(int total, int[] coin) {
        int[] dp=new int[total+1];
        Arrays.sort(coin);
        dp[0]=1;
        for(int i=0;i<coin.length;i++){
            for(int j=coin[i];j<=total;j++){
                dp[j]+=dp[j-coin[i]];
            }
        }


        return dp[total];
    }
}
