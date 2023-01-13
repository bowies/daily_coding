import java.util.Arrays;

public class CountNonDivisible_230106 {
    public static void main(String[] args) {
        CountNonDivisible_230106 c = new CountNonDivisible_230106();
        
        int [] A = {3,1,2,3,6};
        System.out.println(Arrays.toString(c.solution(A)));

    }

    
    public int[] solution(int[] A) {
        //A 배열이 주어지면,
        //A[i]의 약수가 아닌 원소가 해당 배열에 몇 개인지를 구하면 된다고 한다.
        /*
        int [] answer = new int[A.length];
        
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                 if(A[i] % A[j] != 0){
                    answer[i]++;
                 }
            }
        }

        return answer;

         */
        //performance 망함! - 그럴 줄 알았다
        
        
        int[][] frequency = new int[A.length * 2 + 1][2];

        for (int i : A) {
            frequency[i][0]++;      // 숫자 세기
            frequency[i][1] = -1;   // 약수 값 초기화
        }

        for (int i : A) {
            if (frequency[i][1] == -1) {
                //접근하지 않은 값인지 확인
                frequency[i][1] = 0;
                for (int j = 1; j * j <= i; j++) {
                    if (i % j == 0 && i / j != j) {
                        frequency[i][1] += frequency[j][0];
                        frequency[i][1] += frequency[i / j][0]; 
                    } else if (i % j == 0 && i / j == j) {
                        frequency[i][1] += frequency[j][0];
                    }
                }
            }
        }

        for (int i = 0; i < A.length; i++) {
            A[i] = A.length - frequency[A[i]][1];
        }

        return A;  
        //https://app.codility.com/demo/results/trainingZKFZ87-KQ9/ 이분 것 참조
    }
}
