package programmers;

class 문자열의_앞의_n글자_230522 {
    public String solution(String my_string, int n) {
        String answer = my_string.substring(0,n);
        return answer;
    }
}