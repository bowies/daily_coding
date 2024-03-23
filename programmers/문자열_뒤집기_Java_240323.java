package programmers;

class 문자열_뒤집기_Java_240323 {
    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder();
        
        String subString = my_string.substring(s, e + 1);
        StringBuilder reversedSubString = new StringBuilder(subString).reverse();
        
        answer.append(my_string, 0, s);
        answer.append(reversedSubString);
        answer.append(my_string.substring(e + 1));
        
        return answer.toString();
    }
}
