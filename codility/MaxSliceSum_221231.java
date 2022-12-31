package codility;

public class MaxSliceSum_221231 {
    public static void main(String[] args) {
        int [] A  = {3,2,-6,4,0};
        System.out.println(solution(A));
    }   
    
    public static int solution(int[] A) {
            
        if(A.length == 1){
            return A[0];
        }
 
        int max = A[0];
        int temp = A[0];
        int answer = A[0];
        for(int i = 1; i < A.length; i++){
            max = Math.max(A[i], temp + A[i]);  //여기를 A[i]  +A[i+1]로 짜면 오류남! 
            temp = max;
            answer = Math.max(max, answer);
        }

        return answer;
    } 
}
