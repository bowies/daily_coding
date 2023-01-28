public class CountConformingBitmasks_230128 {
    public static void main(String[] args) {
        int A = 1073741727;
        int B = 1073741631;
        int C = 1073741679;
        System.out.println(solution(A,B,C));
    }

    public static int solution(int A, int B, int C) {
        int count = 0;
        int max = 1073741823;
        int min = Integer.MAX_VALUE;

        if(min > A){
            min = A;
        }
        if(min > B){
            min = B;
        }
        if(min > C){
            min = C;
        }

        for(int i=min; i<=max; i++){
            if(conform(i, A) || conform(i, B) || conform(i, C)){
                count++;
            }
        }
        return count;
    }


    public static boolean conform(int num1, int num2){
        String[] num1Str = Integer.toBinaryString(num1).split("");
        String[] num2Str = Integer.toBinaryString(num2).split("");

        for(int i = 0; i < num2Str.length; i++){
            String num2Bit = num2Str[i];
            if(num2Bit.equals("0")){
                continue;
            }
            String num1Bit = num1Str[i];
            if(!num2Bit.equals(num1Bit)){
                return false;
            }
        }
        return true;
    }
}
