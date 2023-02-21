public class SparseBinaryDecomposition_230221 {
    public static void main(String[] args) {
        int N = 26;
        System.out.println(solution(N));
    }

    public static int solution(int N) {
        //N은 이진 표현에 1로 설정된 두 개의 연속 비트가 포함되어 있지 않으면 희소
        //101001 = 희소
        //11010 = 희소하지않음

        if (N <= 2){
            //10 00 01 이런거면 희소로...
            return N;
        }
        for (int i = (N/2); i > 0; i--) {
            if(희소확인(i)){
                if(희소확인(N-i)){
                    return i;
                }
            }
        }
        return -1;
    }

    public static boolean 희소확인(int i){

        int [] arr = new int[32];

        int count = 0;

        while(i > 0 ){
            arr[count] = i%2;

            if(count>1){
                if(arr[count-1]==1 && arr[count]==1){
                    return false;
                }
            }
            count++;
            i = i/2;
        }
        return true;
    }
}
