package programmers;

class 가운데_글자_가져오기_Java_240412 {

    public String solution_good(String s) {

        return s.substring((s.length()-1)/2, s.length()/2 + 1);

    }
    public String solution(String s) {
        int length = s.length();
        
        if (length % 2 == 1) {
            //홀수
            return String.valueOf(s.charAt(length / 2));
        } else {
            //짝수
            return s.substring(length / 2 - 1, length / 2 + 1);
        }
    }
}
