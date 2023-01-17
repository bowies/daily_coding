public class MaxNonoverlappingSegments_230117 {
    public static void main(String[] args) {
        int [] A = {1,3,7,9,9};
        int [] B = {5,6,8,9,10};
        System.out.println(solution(A, B));
    }

    
    public static int solution(int[] A, int[] B) {
        //정렬은 되어 있는 기준임

        int N = A.length;
        if (N < 2) {
            return N;
        }
        
        int answer = 1;
        int b = B[0];
        
        for (int i = 0; i < N; i++) {
            if (A[i] > b) {
                answer++;
                b = B[i];
            }
        }
        
        return answer;
    }
}
