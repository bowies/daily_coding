package codility;

public class MaxDoubleSliceSum_230101 {
    public static void main(String[] args) {
        int [] A = {3,2,6,-1,4,5,-1,2};
        System.out.println(solution(A));
    }

    
    public static int solution(int[] A) {
        
        //이중 슬라이스의 최대 합을 찾는 것이라고 함 ^^...
        //이중 슬라이스란 그냥 배열을 토막 + 토막 쳐서 합친 값임...

        int answer = 0;
        int len = A.length;
        
        if(len == 3){
            //추가!
            return 0;
        }
        
        int [][] arr = new int[2][len];
        //배열을 쓰는 편이 3중 for문보다 낫군! (시간 복잡도에서 1차 떨어진 뒤...)

        for (int i = 1; i < A.length - 1; i++) {
          arr[0][i] = Math.max(0, arr[0][i - 1] + A[i]);
        }
        

        for (int i = A.length - 2; i >= 1; i--) {
          arr[1][i] = Math.max(0, arr[1][i + 1] + A[i]);
        }


        for (int i = 1; i < A.length - 1; i++) {
          int temp = arr[0][i - 1] + arr[1][i + 1];
          if (temp > answer) {
            answer = temp;
          }
        }
        return answer;
    
    }
}
