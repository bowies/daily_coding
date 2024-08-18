package programmers;


class 문자열_다루기_기본_Java_240818 {
    public boolean solution(String s) {

        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        
        return s.matches("\\d+");
    }
}