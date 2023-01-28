public class ThreeLetters_230129 {
    public static void main(String[] args) {
        int A = 5;
        int B = 3;

        //System.out.println(solution(A,B));

        A = 3;
        B = 3;
        //System.out.println(solution(A,B));

        A = 1;
        B = 4;
        System.out.println(solution(A,B));
    }

    public static String solution(int A, int B) {

        int ALen = A;
        int BLen = B;
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        String answer = lenSolve(ALen, BLen, sb);


        return answer;
    }

    private static String lenSolve(int aLen, int bLen, StringBuilder sb) {
        int max = aLen;
        int min = bLen;
        String maxStr = "a";
        String minStr = "b";
        int cnt = 0;

        if (aLen < bLen) {
            max = bLen;
            min = aLen;
            maxStr = "b";
            minStr = "a";
        }

        while (true) {
            if(max == 0 && min == 0){
                break;
            }

            if (max != 0) {
                if(max != 0 && min == 0){
                    cnt = 0;
                }
                if (max >= min && cnt != 2) {
                    sb.append(maxStr);
                    max--;
                    cnt++;
                } else {
                    cnt = 0;
                    sb.append(minStr);
                    min--;
                }
            } else {
                sb.append(minStr);
                min--;
            }
        }

        return sb.toString();
    }

}
