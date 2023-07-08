import java.util.Arrays;
import java.util.Comparator;

public class MinAbsSumOfTwo_230119{
    public static void main(String[] args) {
        int [] A = {1, 4, -3};
        System.out.println(solution(A));
    }
    public static int solution(int[] A) {
        Arrays.sort(A);
        int 맨앞 = A.length - 1;
        int 맨뒤 = 0;
        int temp = 0;

        int answer = Math.abs(A[맨뒤] + A[맨앞]);
        while (맨뒤 <= 맨앞) {
            System.out.println(맨뒤 + "ㅇㅅㅇ" + 맨앞);

            temp = A[맨뒤] + A[맨앞];
            answer = Math.min(answer, Math.abs(temp));
            if (temp <= 0){
                System.out.println("\t" + "ㅎㅅㅎ");
                맨뒤++;
            }else{
                System.out.println("\t" + "ㅇㅅㅎ");
                맨앞--;
            }
        }
        return answer;
    }

    public static int solution_시간복잡도초과(int[] A) {
        int answer = 100000;

        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A.length; j++){
                answer = Math.min(Math.abs(A[i] + A[j]), answer);
            }
        }
        return answer;

        
    }
    /*
        A를 N개의 정수로 구성된 비어 있지 않은 배열이라고 합니다.
        인덱스 쌍(P, Q)에 대한 2 의 절대 합 은 0 ≤ P ≤ Q < N인 경우 절대값 |A[P] + A[Q]|입니다.

        예를 들어, 다음 배열 A:
        A[0] = 1
        A[1] = 4
        A[2] = -3
        인덱스 쌍은 (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2)입니다.
        쌍 (0, 0)에 대한 2의 절대합은 A[0] + A[0] = |1 + 1| = 2.
        쌍 (0, 1)에 대한 2의 절대합은 A[0] + A[1] = |1 + 4| = 5.
        쌍 (0, 2)에 대한 2의 절대합은 A[0] + A[2] = |1 + (−3)| = 2.
        쌍 (1, 1)에 대한 2의 절대합은 A[1] + A[1] = |4 + 4| = 8.
        쌍 (1, 2)에 대한 2의 절대합은 A[1] + A[2] = |4 + (−3)| = 1.
        쌍 (2, 2)에 대한 2의 절대합은 A[2] + A[2] = |(−3) + (−3)| = 6.
        함수 작성:

        class 공배수_230519 { public int solution(int[] A); }

        N개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 이 배열의 인덱스 쌍에 대해 최소 절대합 2를 반환합니다.

        예를 들어 다음과 같은 배열 A가 있다고 가정합니다.

        A[0] = 1
        A[1] = 4
        A[2] = -3
        함수는 위에서 설명한 대로 1을 반환해야 합니다.

        주어진 배열 A:

        A[0] = -8
        A[1] = 4
        A[2] = 5
        A[3] =-10
        A[4] = 3
        함수는 |(−8) + 5|를 반환해야 합니다. = 3.

        다음 가정에 대한 효율적인 알고리즘을 작성 하십시오.

        N은 범위 [ 1 .. 100,000 ] 내의 정수 이고;
        배열 A의 각 요소는 [ −1,000,000,000 .. 1,000,000,000 ] 범위 내의 정수 입니다. 
     */


}