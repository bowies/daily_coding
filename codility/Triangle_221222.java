import java.util.Arrays;

public class Triangle_221222 {
    public static void main(String[] args) {
        int [] A = {10,2,5,1,8,20};
        solution(A);
    }    
    
    public static int solution(int[] A) {
        //인접한 것만 찾으면 되니까 sort를 해줌
        Arrays.sort(A);

        /*
        p + q > r
        q + r > p
        r + p > q

        => 그냥 중복되지 않은 인덱스 값 나타내주면 됨... 있으면 1 반환...
        */

        for(int i = 0; i < A.length-2; i++){
            if(A[i+1] > A[i+2] - A[i]){
                return 1;
            }
        }

        return 0;
    }
}
