package programmers;

class 특정_문자열로_끝나는_가장_긴_부분_문자열_찾기_Java_240409 {
    public String solution(String myString, String pat) {
        String answer = "";
        int index = myString.lastIndexOf(pat);
        answer = myString.substring(0, index + pat.length());
        return answer;
    }
}
