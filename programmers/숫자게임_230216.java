package programmers;

import java.util.Arrays;

public class 숫자게임_230216 {

        public int solution(int[] A, int[] B) {

            Arrays.sort(A);
            Arrays.sort(B);
            //어차피 큰 순서대로 sort 하는 것이...

            int 에이 = 0;
            int 비 = 0;
            int answer = 0;

            for (int i = 0; i < A.length; i++) {
                if (A[에이] > B[비]) {
                    비++;
                } else if (A[에이] == B[비]) {
                    비++;
                } else {
                    에이++;
                    비++;
                    answer++;
                }
            }
            return answer;

        }
}
