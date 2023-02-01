public class ArrayInversionCount_230201 {
    public static void main(String[] args) {
        int [] A = {-1,6,3,4,7,4};
        System.out.println(solution(A));
    }


    public static int solution(int[] A) {

        long answer = inversionA(A, 0, A.length - 1);
        if(answer > 1000000000){
            return -1;
        }else{
            return (int) answer;
        }

    }


    static long inversionA(int[] A, int 시작, int 끝) {
        if (시작 >= 끝) {
            return 0;
        }

        int 중간 = (시작 + 끝) / 2;

        long answer = inversionA(A, 시작, 중간) + inversionA(A, 중간 + 1, 끝);
        int[] arr = new int[끝 - 시작 + 1];

        int cnt1 = 시작;
        int cnt2 = 중간 + 1;

        for (int i = 0; i < arr.length; i++) {
            if (cnt2 == 끝 + 1 || (cnt1 != 중간 + 1 && A[cnt1] <= A[cnt2])) {
                arr[i] = A[cnt1];
                cnt1++;
            } else {
                arr[i] = A[cnt2];
                cnt2++;
                answer += 중간 + 1 - cnt1;
            }
        }
        for (int i = 시작; i <= 끝; i++) {
            A[i] = arr[i - 시작];
        }
        return answer;
    }

}
