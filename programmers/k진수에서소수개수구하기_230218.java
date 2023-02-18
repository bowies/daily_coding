package programmers;

import java.math.BigInteger;

public class k진수에서소수개수구하기_230218 {
    public static void main(String[] args) {
        int n = 437674;
        int k = 3;
        System.out.println(solution(n,k));
    }

    public int 추천코드(int n, int k) {

        int ans = 0;
        String temp[] = Integer.toString(n, k).split("0");

        Loop : for(String t : temp) {
            if(t.length() == 0) continue;
            long a = Long.parseLong(t);
            if(a == 1) continue;
            for(int i=2; i<=Math.sqrt(a); i++)
                if(a%i == 0) continue Loop;

            ans++;
        }
        return ans;
    }
    public static boolean 소수찾기(long l) {
        if (l == 1){
            return false;
        }
        //1이면 없어지니
        for (int i = 2; i <=(int)Math.sqrt(l); i++) {
            if (l%i==0){
                return false;
            }
        }
        return true;
    }

    public static int solution(int n, int k) {
        int answer = 0;

        String[] arr = new BigInteger(String.valueOf(n)).toString(k).split("0");
        for (String str : arr) {
            if (str.equals("")){
                //빈 문자열이면 넘어감
                continue;
            }else if (소수찾기(Long.parseLong(str))){
                answer++;
            }
        }
        return answer;
    }
}
