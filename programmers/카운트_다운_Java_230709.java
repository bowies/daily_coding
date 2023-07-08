package programmers;

class 카운트_다운_Java_230709 {
    int[][] dp;  // dp 배열
    int target범위 = 100001;  // dp 배열 초기값 범위

    public int[] solution(int target) {
        // dp [i][0] : i를 만들기 위해 필요한 최소 다트 수
        // dp [i][1] : i를 만들기 위해 필요한 최소 싱글/불 횟수

        dp = new int[target + 1][2];
        for (int i = 1; i <= target; i++) {
            dp[i][0] = target범위;
        }

        return 다트_던지기(target);
    }

    int[] 다트_던지기(int n) {
        // dp[n][0]이 초기값인 target범위와 같을 경우에만 계산을 수행한다.
        if (dp[n][0] == target범위) {
            if (n >= 50) { // 불 맞추기
                int[] temp = 다트_던지기(n - 50);
                if ((temp[0] + 1 < dp[n][0]) || (temp[0] + 1 == dp[n][0] && temp[1] + 1 > dp[n][1])) {
                    dp[n][0] = 1 + temp[0];
                    dp[n][1] = 1 + temp[1];
                }
            }

            int start = n >= 20 ? 20 : n;
            int i = start;
            while (i >= 1) {
                int j = 1;
                while (j <= 3) {
                    if (n >= i * j) {
                        int[] temp = 다트_던지기(n - i * j);
                        int cnt = j == 1 ? 1 : 0; // 싱글일 경우 카운트하기
                        if ((temp[0] + 1 < dp[n][0]) || (temp[0] + 1 == dp[n][0] && temp[1] + cnt > dp[n][1])) {
                            dp[n][0] = 1 + temp[0];
                            dp[n][1] = cnt + temp[1];
                        }
                    }
                    j++;
                }
                i--;
            }
        }

        return dp[n];
    }
}
