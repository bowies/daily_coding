public class MinMaxDivision_230113 {

    public static void main(String[] args) {
        MinMaxDivision_230113 m = new MinMaxDivision_230113();
        int K = 3;
        int M = 5;
        int [] A = {2,1,5,1,2,2,2};
        System.out.println(m.solution(K, M, A));
    }

    
    public int solution(int K, int M, int[] A) {
        // N : 1~10만
        // K : 1~10만
        // M : 0~1만
        // A : 0 ~ M범위 내 정수

        int 최소값 = 0;
        int 최대값 = 0;

        for (int i = 0; i < A.length; i++) {
            최대값 += A[i];             
            최소값 = Math.max(최소값, A[i]);
        }        

        int answer = 최대값;
        boolean flag = true;
        int temp = 0;
        int 합계 = 0;

        while (최소값 <= 최대값) {
            int 중간값 = (최소값 + 최대값) / 2;

            flag = true;
            합계 = 0;
            temp = K-1;

            for (int i = 0; i < A.length; i++) {
                합계 += A[i];
                if (합계 > 중간값) {
                    합계 = A[i];
                    temp--;
                }
                if (temp < 0) {
                    flag = false;
                }
            }


            if (flag) {
                최대값 = 중간값 - 1;
                answer = 중간값;
            } else {
                최소값 = 중간값 + 1;
            }
        }
        return answer;

    }
}
