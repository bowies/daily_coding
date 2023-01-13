import java.util.Arrays;

public class MaxProduct_221221 {
    public static void main(String[] args) {
        int [] A = {-3, 1, 2, -2, 5, 6};
        solution(A);
        
    }
    
    public static int solution(int[] A) {
        // Implement your solution here
        int answer = 0;
        int max = 0;
        int zero = 0;
        //삼중항 최대 곱
        
        Arrays.sort(A);
        max = A[A.length-1] * A[A.length-2] * A[A.length-3];
        
        zero = A[0] * A [1] * A[A.length-1];
        //음수인 경우에는 최대값 * 음수친구들

        answer = Math.max(max, zero);


        return answer;
    }
}
