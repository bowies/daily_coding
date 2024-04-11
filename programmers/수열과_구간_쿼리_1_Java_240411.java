package programmers;

class 수열과_구간_쿼리_1_Java_240411 {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[arr.length];
        
        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            
            for (int i = start; i <= end; i++) {
                arr[i]++;
            }
        }
        
        for (int i = 0; i < arr.length; i++) {
            answer[i] = arr[i];
        }
        
        return answer;
    }
}
