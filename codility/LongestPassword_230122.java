import java.util.regex.Pattern;

public class LongestPassword_230122{
    public static void main(String[] args) {
        String s = "test 5 a0A pass007 ?xy1";
        System.out.println(solution(s));
    }
     
    public static int solution(String S) {
        int answer = -1;

        String [] arr = S.split(" ");
        //문자열 S는 공백을 제거하고 분할 하여 단어 로 나눌 수 있습니다. 
        
        for(int i = 0; i < arr.length; i++){
            /*        
                영숫자 문자( a − z , A − Z , 0 − 9 )만 포함해야 합니다.
                짝수의 문자가 있어야 합니다.
                홀수의 자릿수가 있어야 합니다. 
            */
            String [] temp = arr[i].split("");
            int 짝수문자개수 = 0;
            int 홀수자리수 = 0;
            boolean 특수문자체크 = true;

            for(int j = 0; j < temp.length; j++){
                if(Pattern.matches("^[a-zA-Z]*$", temp[j])){
                    짝수문자개수++;
                }else if(Pattern.matches("^[0-9]*$", temp[j])){
                    홀수자리수++;
                }else{
                    특수문자체크 = false;
                }
            }

            if(짝수문자개수%2 == 0 && 홀수자리수%2 != 0 && 특수문자체크 == true){
                //System.out.println(짝수문자개수 + "   " + 홀수자리수 + "  " + arr[i]);
                answer = Math.max(answer, arr[i].length());
            }
        }


        return answer;
    }

}
