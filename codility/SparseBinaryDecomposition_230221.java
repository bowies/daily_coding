public class SparseBinaryDecomposition_230221 {
    public static void main(String[] args) {
        int N = 26;
        System.out.println(solution(N));
    }

    public static int solution(int N) {
        //N은 이진 표현에 1로 설정된 두 개의 연속 비트가 포함되어 있지 않으면 희소
        //101001 = 희소
        //11010 = 희소하지않음
        int solution =-1;

        for(int i=2; i<=Math.ceil((N-1)/2); i++){
            if(희소확인(i)){
                int j = N-i;
                if(희소확인(j)){
                    return j;
                }
            }
        }
        return solution;
    }
    static boolean 희소확인(int N){
        if((N&(N>>1))>=1){
            return false;
        }
        return true;
    }
}
