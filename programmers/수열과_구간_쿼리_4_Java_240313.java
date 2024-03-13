package programmers;

class 수열과_구간_쿼리_4_Java_240313 {
    public int[] solution(int[] arr, int[][] queries) {
        //문제 꼬라지... -.-) 문제 가독성 0임
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            for (int i = s; i <= e; i++) {
                if (i % k == 0) {
                    arr[i] += 1;
                }
            }
        }
        return arr;
    }
}
