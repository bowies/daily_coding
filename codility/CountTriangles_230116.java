import java.util.Arrays;

public class CountTriangles_230116 {
    public static void main(String[] args) {
        int [] A = {10,2,5,1,8,12};
        int ans = solution(A);
        System.out.println(ans);

    }

    public static int solution(int[] A) {
       
        int answer = 0;
        Arrays.sort(A);
        // p + q > r 
        
        for(int p=0; p < A.length-2; p++){
            
            int q = p+1;
            int r = p+2;
            
            while(q < A.length-1){
                
                if(r < A.length && A[p] + A[q] > A[r]){
                    r++; 
                }else{
                    answer = answer + (r - q - 1); //r은 빼줘야함
                    q++; //q를 증가시키는 while문 
                }
            }
        }
        return answer;
    }
}