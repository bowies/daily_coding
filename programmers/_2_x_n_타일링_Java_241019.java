package programmers;

class _2_x_n_타일링_Java_241019 {

    public int solution(int n) {
        int 나누기 = 1_000_000_007;

        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        
        dp[1] = 1;  // 2x1 크기의 바닥을 채우는 방법은 1가지
        dp[2] = 2;  // 2x2 크기의 바닥을 채우는 방법은 2가지

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 나누기;
        }

        return dp[n];
    }
}
