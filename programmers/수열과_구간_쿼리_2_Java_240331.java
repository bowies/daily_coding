package programmers;

class 수열과_구간_쿼리_2_Java_240331 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];
            int k = queries[i][2];

            int min = Integer.MAX_VALUE;

            for (int j = start; j <= end; j++) {
                if (arr[j] > k && arr[j] < min) {
                    min = arr[j];
                }
            }

            if (min == Integer.MAX_VALUE) {
                answer[i] = -1;
            } else {
                answer[i] = min;
            }
        }
        
        return answer;
    }
}
