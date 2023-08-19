package programmers;

class 원하는_문자열_찾기_Java_230819 {
    public int solution(String myString, String pat) {
        int answer = 0;

        if(myString.toLowerCase().contains(pat.toLowerCase())) {
            answer = 1;
        }
        return answer;
    }



}