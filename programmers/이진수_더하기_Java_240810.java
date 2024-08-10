package programmers;

class 이진수_더하기_Java_240810 {
    public String solution(String bin1, String bin2) {

        //2진수 -> 10진수 -> 2진수

        int n1 = Integer.parseInt(bin1, 2);
        int n2 = Integer.parseInt(bin2, 2);
        int nsum = n1 + n2;

        String answer = Integer.toBinaryString(nsum);
        
        return answer;
    }
}