public class StrSymmetryPoint_230130 {
    public static void main(String[] args) {
        String S = "racecar";
        //String S = "x";
        System.out.println(solution(S));
    }
    public static int solution(String S) {
        if ((S.length() & 1) == 0) {
            return -1;
        }
        int answer = S.length() / 2;

        for (int i = answer, j = answer; j >= 0; i++, j--) {
            //i j 둘 다 옵션 넣을 수 있음
            //System.out.println(i + "ㅇㅅㅇ" + j);
            if (S.charAt(i) != S.charAt(j)) {
                return -1;
            }
        }
        return answer;
    }
    public static int solution2(String S) {
        if(S.length()%2 != 0){
            //홀수 경우만 처리
            if(S.length() == 1){
                //길이가 1인 경우 0
                return 0;
            }else if(S.length() == 3){
                //길이가 3인 경우 앞 뒤 같으면 0
                if(S.charAt(0) == S.charAt(2)){
                    return 1;
                }else{
                    return 0;
                }
            }else{
                int 절반 = S.length()/2;
                for(int i = 0; i < 절반; i++){
                    //0 1 2
                    //r a c
                    //3
                    //e
                    //4 5 6
                    //c a r
                    int 앞 = 절반 - 1 - i;
                    int 뒤 = 절반+1 + i;
                    if(S.charAt(앞) != S.charAt(뒤)){
                        return 0;
                    }
                }
                return 절반;
            }
        }
        return 0;
    }
}
